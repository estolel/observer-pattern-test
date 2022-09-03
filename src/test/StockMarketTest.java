package test;

import main.StockMarket;
import main.Broker;
import org.junit.jupiter.api.Test;

public class StockMarketTest {


    @Test
    void should_update_app_state_when_update_given_app() {
        //given
        StockMarket stockMarket = new StockMarket("A product", "Stinks");
        Broker broker = new Broker();
        Broker broker2 = new Broker();
        stockMarket.addObserver(broker);
        stockMarket.addObserver(broker2);
        //when
        stockMarket.updateMarket("A product","Stonks");
        stockMarket.notifyObservers();
        //then
        System.out.println();
    }



}
