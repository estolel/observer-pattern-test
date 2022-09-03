package main;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class StockMarket {
    private String product;
    private String state;
    private final Set<StockMarketObserver> stockMarketObserverSet;

    public StockMarket(String product, String state) {
        this.product = product;
        this.state = state;
        this.stockMarketObserverSet = new HashSet<>();
    }

    public String getProduct() {
        return product;
    }

    public String getState() {
        return state;
    }

    public void outputAppState() {
        System.out.println("product: " + this.product + "\n" +
                "state: " + this.state);
    }

    public void addObserver(StockMarketObserver stockMarketObserver) {
        this.stockMarketObserverSet.add(stockMarketObserver);
    }

    public void removeObserver(StockMarketObserver stockMarketObserver) {
        this.stockMarketObserverSet.remove(stockMarketObserver);
    }
    public void updateMarket(String product, String state) {
        this.product = product;
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        this.stockMarketObserverSet.forEach(stockMarketObserver ->
                stockMarketObserver.marketUpdate(this));
    }
}
