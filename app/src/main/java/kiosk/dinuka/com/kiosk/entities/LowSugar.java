package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class LowSugar extends BeverageDecorator {

    public LowSugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5.0;
    }

    @Override
    public String getExtraDetails() {
        return super.getExtraDetails() + " + Added Low Sugar";
    }
}
