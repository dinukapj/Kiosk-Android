package kiosk.dinuka.com.kiosk.entities;

import java.util.ArrayList;

/**
 * Created by dinuka on 07/06/2017.
 */

public class MenuSingleton {
    private static ArrayList<MenuItem> instance = new ArrayList<MenuItem>();

    private MenuSingleton(){}

    public static ArrayList<MenuItem> getInstance(){
        return instance;
    }
}
