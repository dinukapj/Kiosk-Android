package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class LargeSize extends BeverageDecorator {

    public LargeSize(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 6.6;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Selected Large size";
    }
}
