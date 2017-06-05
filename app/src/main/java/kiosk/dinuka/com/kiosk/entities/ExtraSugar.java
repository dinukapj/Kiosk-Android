package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 05/06/2017.
 */

public class ExtraSugar extends BeverageDecorator {

    public ExtraSugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Added Extra Sugar";
    }
}
