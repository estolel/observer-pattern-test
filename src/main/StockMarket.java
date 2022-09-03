package main;

import java.util.Observable;

public class StockMarket extends Observable {
    String product;
    String state;
    public StockMarket(String product, String state){
       this.product=product;
       this.state=state;
    }
    public void outputAppState(){
        System.out.println("product: "+product+"\n"+
                "state"+state
        );
    }

    public void updateMarket(String a_product, String state) {
        this.product=a_product;
        this.state=state;
        setChanged();
    }
}
