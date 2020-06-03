package com.acme.mytrader.price;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * connects to a price source to get stock prices
 * and adds them to an array
 */
public class ApiPriceSource implements PriceSource {

	private final ArrayList<PriceListener> listeners;
	private final String security;
	private double updatedPrice;

	/**
	 * constructor for ApiPriceSource
	 *
	 * @param security Stock symbol
	 */
	public ApiPriceSource(String security) {
		this.listeners = new ArrayList<PriceListener>();
		this.security = security;
	}

	/**
	 * sends a basic get request to fetch the stock price
	 * runs until buy option is fulfilled
	 */
	public boolean tick() {
		if(this.listeners.size() == 0) {
			return true;
		}
		final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://financialmodelingprep.com/api/v3/stock/real-time-price/" + security +"?apikey=demo")
				.build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String res = Objects.requireNonNull(response.body()).string();
            JsonObject current_price = new Gson().fromJson(res, JsonObject.class);
            //gets price value from json body
			updatedPrice = current_price.get("price").getAsDouble();
			//sends chosen stock and current price to be added to the listener arraylist
			updateListeners(security, updatedPrice);
			//this makes sure to send a get request every 5 seconds
			Thread.sleep(5000);

		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	/**
	 * monitors price change of current stock
	 *
	 * @param listener  price monitor for current stock
	 */
    public void addPriceListener(PriceListener listener)
    {
    	this.listeners.add(listener);
    }
    
    /**
     * removes the current PriceListener instance
	 * gets called when buy option is fulfilled
	 *
     * @param listener  price monitor for current stock
     */
    public void removePriceListener(PriceListener listener)
    {
    	this.listeners.remove(listener);
		System.out.println("£"+updatedPrice + " each.");
    }

    /**
	 * updates the current price every time it changes
	 *
     * @param security  Stock symbol
     * @param price     Current stock price
     */
    private void updateListeners(String security, double price)
    {
    	for (int i = 0; i < this.listeners.size(); i++)
    	{
    		PriceListener listener = this.listeners.get(i);
    		listener.priceUpdate(security, price);
    	}
    }

}