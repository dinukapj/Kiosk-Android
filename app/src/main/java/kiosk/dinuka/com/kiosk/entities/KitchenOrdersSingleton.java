package kiosk.dinuka.com.kiosk.entities;

import java.util.ArrayList;

/**
 * Created by dinuka on 07/06/2017.
 */

public class KitchenOrdersSingleton {

    private static ArrayList<Order> instance = new ArrayList<Order>();

    private KitchenOrdersSingleton(){}

    public static ArrayList<Order> getInstance(){
        return instance;
    }

}
