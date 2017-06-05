package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 02/06/2017.
 */

public class MenuItem {

    private String Id = "";
    private String Name = "";
    private String Description = "";
    private String Picture = "";
    private Double ItemPrice = 0.0;
    private Boolean isAvailable = false;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        ItemPrice = itemPrice;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

}
