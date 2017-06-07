package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 07/06/2017.
 */

public class UserSingleton {

    private static User instance = new User();

    private UserSingleton(){}

    public static User getInstance(){
        return instance;
    }

}
