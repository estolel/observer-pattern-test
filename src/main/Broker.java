package main;

import java.util.Observable;
import java.util.Observer;

public class Broker implements StockMarketObserver {

    private void invest(StockMarket stockMarket) {
        if(stockMarket.getState().equals("Stonks"))
            System.out.println("I invested in "+stockMarket.getProduct()+"!!!!");
        else
            System.out.println("I will not invest!!!!");
    }

    @Override
    public void marketUpdate(StockMarket stockMarket) {
        invest(stockMarket);
    }
}