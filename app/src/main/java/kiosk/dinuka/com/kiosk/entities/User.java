package kiosk.dinuka.com.kiosk.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dinuka on 27/03/2017.
 */

public class User {

    @SerializedName("ID")
    private String ID = "";

    @SerializedName("Name")
    private String Name = "";

    @SerializedName("Picture")
    private String Picture = "";

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


}
