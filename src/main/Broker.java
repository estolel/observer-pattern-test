package main;

import java.util.Observable;
import java.util.Observer;

public class Broker implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        invest(o);
    }

    private void invest(Object arg) {
        StockMarket currentStockMarket = (StockMarket) arg;
        if(currentStockMarket.state.equals("Stonks"))
            System.out.println("I invested in "+currentStockMarket.product+"!!!!");
        else
            System.out.println("I will not invest!!!!");
    }
}
