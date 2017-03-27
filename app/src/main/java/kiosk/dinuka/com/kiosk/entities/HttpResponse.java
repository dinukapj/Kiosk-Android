package kiosk.dinuka.com.kiosk.entities;

/**
 * Created by dinuka on 27/03/2017.
 */

public class HttpResponse<T> {
    public String status;
    public String description;
    public T object;

    public HttpResponse(String status, String description, T object) {
        this.status = status;
        this.description = description;
        this.object = object;
    }
}
