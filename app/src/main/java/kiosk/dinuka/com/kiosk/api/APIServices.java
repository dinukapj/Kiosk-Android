package kiosk.dinuka.com.kiosk.api;

import java.util.List;

import kiosk.dinuka.com.kiosk.entities.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by dinuka on 27/03/2017.
 */

public interface APIServices {

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId);

    @POST("login")
    Call<User> login(@Body String collegeId, @Body String password);

}
