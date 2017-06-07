package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 06/06/2017.
 */

public class OrderSingleton {

    private static Order instance = new Order();

    private OrderSingleton(){}

    public static Order getInstance(){
        return instance;
    }

    public static void resetInstance(){
        instance = new Order();
    }

}
