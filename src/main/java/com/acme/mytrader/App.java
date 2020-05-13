package com.acme.mytrader;

import java.util.Scanner;

import com.acme.mytrader.execution.ApiExecutionService;
import com.acme.mytrader.price.ApiPriceSource;
import com.acme.mytrader.strategy.TradingStrategy;

/**
 * executes the main trading strategy
 */
public class App
{
	/**
	 * @param security  Stock symbol
	 * @return returns price of stock
	 */
	public static ApiPriceSource buildApiPriceSource(String security) {
		return new ApiPriceSource(security);
	}

	/**
	 * builds a design pattern for executing the app
	 *
	 * @param  security  Stock symbol
	 */
	public static void buildTradingStrategy(int amount, double price, ApiPriceSource priceSource, String security) {
		ApiExecutionService executionService = new ApiExecutionService();

		TradingStrategy myTradingStrategy = new TradingStrategy(amount, executionService, price, priceSource, security);
	}

	/**
	 * todo: add input validation
	 * execute program logic by taking user input
	 *
	 * @param args   stock, price and volume intended to buy at.
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("security:");
		String security = input.next();

		System.out.println("price:");
		double price = input.nextDouble();

		System.out.println("amount:");
		int amount = input.nextInt();

		ApiPriceSource ps = buildApiPriceSource(security);
		buildTradingStrategy(amount, price, ps, security);

		//runs until a successful buy is confirmed
		while (true) {
			if(ps.tick()) {
				break;
			}
		}
		input.close();
	}
}
