package kiosk.dinuka.com.kiosk.helpers;

import kiosk.dinuka.com.kiosk.entities.User;

/**
 * Created by dinuka on 27/03/2017.
 */

public class SharedData {

    private String BaseURL = "";
    private User User = new User();

    private static volatile SharedData config;

    public static SharedData getInstance(){
        if (config == null){
            config = new SharedData();
        }
        return config;
    }

    public String getBaseURL() {
        return BaseURL;
    }

    public void setBaseURL(String baseURL) {
        BaseURL = baseURL;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }
}
