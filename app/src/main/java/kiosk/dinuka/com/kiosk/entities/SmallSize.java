package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class SmallSize extends BeverageDecorator {

    public SmallSize(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4.4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Selected Small size";
    }
}
