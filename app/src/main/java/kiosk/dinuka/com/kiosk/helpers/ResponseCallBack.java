package kiosk.dinuka.com.kiosk.helpers;

/**
 * Created by dinuka on 27/03/2017.
 */

public interface ResponseCallBack<T> {
    void onSuccess(T... t);
    void onFailure(String error);
}
