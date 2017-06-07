package kiosk.dinuka.com.kiosk.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 07/06/2017.
 */

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private Order order = new Order();

    public Order getState() {
        return order;
    }

    public void setState(Order order) {
        this.order = order;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}
