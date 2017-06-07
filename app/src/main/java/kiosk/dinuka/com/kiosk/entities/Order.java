package kiosk.dinuka.com.kiosk.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dinuka on 06/06/2017.
 */

public class Order {

    private User user = new User();
    private ArrayList<MenuItem> items = new ArrayList<>();
    private Date orderDate;
    private Time orderTime;
    private double totalAmount;
    private int kioskID;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getKioskID() {
        return kioskID;
    }

    public void setKioskID(int kioskID) {
        this.kioskID = kioskID;
    }
}
