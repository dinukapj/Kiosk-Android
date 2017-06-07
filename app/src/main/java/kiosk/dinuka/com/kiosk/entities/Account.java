package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 07/06/2017.
 */

public class Account {

    private double Balance = 0.0;

    public void topup(double amount){
        setBalance(getBalance() + amount);
    }

    public void resetBalance(){
        Balance = 0.0;
    }

    public void deduct(double amount){
        setBalance(getBalance() - amount);
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
