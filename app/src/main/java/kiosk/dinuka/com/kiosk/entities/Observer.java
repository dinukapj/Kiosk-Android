package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 07/06/2017.
 */

public abstract class Observer {

    protected Subject subject;
    public abstract void update(Order order);

}
