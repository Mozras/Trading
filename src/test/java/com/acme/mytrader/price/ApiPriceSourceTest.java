package com.acme.mytrader.price;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.junit.Test;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * ApiPriceSource Tester.
 *
 * @author <Mozamel Rasouli>
 * @since <pre>May 13, 2020</pre>
 * @version 1.0
 */
public class ApiPriceSourceTest {
     /**
     *
     * Method: tick()
     *
     */
    @Test
    public void testTick() throws Exception {
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://financialmodelingprep.com/api/v3/stock/real-time-price/AAPL"+"?apikey=demo")
                .build();

        Response response = client.newCall(request).execute();
        String res = Objects.requireNonNull(response.body()).string();
        JsonObject stock = new Gson().fromJson(res, JsonObject.class);
        String symbol = stock.get("symbol").getAsString();
        assertEquals(symbol, "AAPL"); }
}
