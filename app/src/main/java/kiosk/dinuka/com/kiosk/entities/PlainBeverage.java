package kiosk.dinuka.com.kiosk.entities;

import android.util.Log;

/**
 * Created by dinuka on 05/06/2017.
 */

public class PlainBeverage extends MenuItem implements Beverage {

    @Override
    public double getPrice() {
        return 12.0;
    }

    @Override
    public String getExtraDetails() {
        //Selected Beverage
        return super.getDescription() + "";
    }
}
