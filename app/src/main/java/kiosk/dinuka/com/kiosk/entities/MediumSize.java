package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class MediumSize extends BeverageDecorator {

    public MediumSize(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5.5;
    }

    @Override
    public String getExtraDetails() {
        return super.getExtraDetails() + " + Selected Medium size";
    }
}
