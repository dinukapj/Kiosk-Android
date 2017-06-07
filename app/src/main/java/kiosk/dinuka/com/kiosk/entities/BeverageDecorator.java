package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public abstract class BeverageDecorator implements Beverage {

    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double getPrice() {
        return beverage.getPrice();
    }

    @Override
    public String getExtraDetails() {
        return beverage.getExtraDetails();
    }
}
