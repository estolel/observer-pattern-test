package test;

import main.Broker;
import main.StockMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockMarketTest {


    @Test
    void should_invest_when_update_given_stonks() {
        //given
        StockMarket stockMarket = new StockMarket("A product", "Stinks");
        Broker broker = new Broker();
        Broker broker2 = new Broker();
        stockMarket.addObserver(broker);
        stockMarket.addObserver(broker2);
        stockMarket.outputAppState();
        assertTrue(systemOut().contains("product: A product\nstate: Stinks"));
        //when
        stockMarket.updateMarket("A product","Stonks");
        stockMarket.notifyObservers();
        //then
        assertTrue(systemOut().contains("I invested in A product!!!!"));
    }
    @Test
    void should_not_invest_when_update_given_stinks() {
        //given
        StockMarket stockMarket = new StockMarket("A product", "Stinks");
        Broker broker = new Broker();
        Broker broker2 = new Broker();
        stockMarket.addObserver(broker);
        stockMarket.addObserver(broker2);
        stockMarket.outputAppState();
        assertTrue(systemOut().contains("product: A product\nstate: Stinks"));
        //when
        stockMarket.updateMarket("B product","Stinks");
        stockMarket.notifyObservers();
        //then
        assertTrue(systemOut().contains("I will not invest!!!!"));
    }

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }



}
