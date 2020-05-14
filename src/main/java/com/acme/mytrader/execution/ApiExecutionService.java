package com.acme.mytrader.execution;

public class ApiExecutionService implements ExecutionService{

	/**
	 * buys the current selected stock at a specific volume and price
	 *
	 * @param security    Stock symbol
	 * @param price       Stock price to buy at
	 * @param volume      Amount of stock to buy
	 *
	 * @return  returns the string message created
	 */
	public String buy(String security, double price, int volume) {
    	String message = "\nBought " + volume + " " + security +" shares for:";
    	System.out.println(message);
		return message;
	}

    /**
     * Sells buys the current selected stock at a specific volume and price
	 * (not implemented as not needed)
	 *
	 * @param security    Stock symbol
	 * @param price    	  Stock price to sell at
	 * @param volume      Amount of stock to sell
	 */
    public void sell(String security, double price, int volume) {
    	String message = "SELL " + volume + " " + security + " @ " + price;
    	System.out.println(message);
    }
}