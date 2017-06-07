package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class ExtraMilk extends BeverageDecorator {

    public ExtraMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.5;
    }

    @Override
    public String getExtraDetails() {
        return super.getExtraDetails() + " + Added Extra Milk";
    }
}
