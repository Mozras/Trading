package com.acme.mytrader.price;

import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;

/**
 * ApiPriceSource Tester.
 *
 * @author <Authors name>
 * @since <pre>May 13, 2020</pre>
 * @version 1.0
 */
public class ApiPriceSourceTest {

    @Before
    public void before() throws Exception {
         final ArrayList<PriceListener> listeners;
         final String security;

    }

    @After
    public void after() throws Exception {

    }

    /**
     *
     * Method: tick()
     *
     */
    @Test
    public void testTick() throws Exception {
        ApiPriceSource test1 = new ApiPriceSource("AAPL");

        test1.tick();
        //TODO: Test goes here...
    }

    /**
     *
     * Method: addPriceListener(PriceListener listener)
     *
     */
    @Test
    public void testAddPriceListener() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: removePriceListener(PriceListener listener)
     *
     */
    @Test
    public void testRemovePriceListener() throws Exception {
//TODO: Test goes here...
    }


    /**
     *
     * Method: updateListeners(String security, double price)
     *
     */
    @Test
    public void testUpdateListeners() throws Exception {
//TODO: Test goes here...

    }

}
