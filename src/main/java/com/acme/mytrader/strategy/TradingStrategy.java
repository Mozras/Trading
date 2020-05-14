package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy implements PriceListener {
	
	private final ExecutionService executionService;
	private final PriceSource priceSource;
	private final int amountToBuy;
	private final double priceToBuy;
	private final String securityToBuy;

	/**
	 * initialize values and add strategy
	 *
	 * @param  amountToBuy        Volume needed to buy
	 * @param  executionService   Interface for buy and sell methods
	 * @param  priceToBuy         Set price of stock to buy at
	 * @param  securityToBuy      Holds symbol for stock to buy
	 */
	public TradingStrategy(int amountToBuy, ExecutionService executionService, double priceToBuy, PriceSource priceSource, String securityToBuy) {
		this.amountToBuy = amountToBuy;
		this.executionService = executionService;
		this.priceSource = priceSource;
		this.priceToBuy = priceToBuy;
		this.priceSource.addPriceListener(this);
		this.securityToBuy = securityToBuy;
	}

	/**
	 * orders a buy if the current stock price is less than or equal to buying price
	 *
	 * @param security   Stock symbol
	 * @param price      Current price of stock
	 */
	public void priceUpdate(String security, double price) {
    	if (this.securityToBuy.equals(security) && price <= this.priceToBuy) {
    		this.executionService.buy(this.securityToBuy, this.priceToBuy, this.amountToBuy);

    		// we only want to do the trade once, so stop listening after we buy
    		this.priceSource.removePriceListener(this);
    	}
    }
}
