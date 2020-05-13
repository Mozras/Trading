package com.acme.mytrader.execution;

import org.junit.Test;


/**
 * ApiExecutionService Tester.
 *
 * @author <Mozamel Rasouli>
 * @since <pre>May 13, 2020</pre>
 * @version 1.0
 */
public class ApiExecutionServiceTest {
    /**
     *
     * Method: buy(String security, double price, int volume)
     *
     */
    @Test
    public void testBuy() throws Exception {
        ApiExecutionService Buy = new ApiExecutionService();

        String security = "AAPL";
        double price = 350.2;
        int volume = 200;

        String string = Buy.buy(security, price, volume);
        assert string.equals("Bought " + volume + " " + security +  " stock @ " + price);
    }

}
