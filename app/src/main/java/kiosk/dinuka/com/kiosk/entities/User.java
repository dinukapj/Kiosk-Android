package kiosk.dinuka.com.kiosk.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dinuka on 27/03/2017.
 */

public class User {

    @SerializedName("id")
    private String ID = "";

    @SerializedName("name")
    private String Name = "";

    @SerializedName("picture")
    private String Picture = "";

    public User(){

    }

    public User(String ID, String name, String picture) {
        this.ID = ID;
        Name = name;
        Picture = picture;
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


}
