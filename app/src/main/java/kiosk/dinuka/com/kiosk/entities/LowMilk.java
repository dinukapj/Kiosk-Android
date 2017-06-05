package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class LowMilk extends BeverageDecorator {

    public LowMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.5;
    }
}
