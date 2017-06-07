package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 07/06/2017.
 */

public class KitchenObserver extends Observer {

    public KitchenObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(Order order) {
        KitchenOrdersSingleton.getInstance().add(order);
    }

}
