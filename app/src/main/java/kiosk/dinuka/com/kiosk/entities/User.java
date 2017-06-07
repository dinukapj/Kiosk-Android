package kiosk.dinuka.com.kiosk.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dinuka on 27/03/2017.
 */

public class User {

    private String ID = "";
    private String Name = "";
    private String Picture = "";
    private Account Account = new Account();

    public User(){

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public kiosk.dinuka.com.kiosk.entities.Account getAccount() {
        return Account;
    }

    public void setAccount(kiosk.dinuka.com.kiosk.entities.Account account) {
        Account = account;
    }






}
