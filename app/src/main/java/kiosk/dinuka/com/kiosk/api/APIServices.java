package kiosk.dinuka.com.kiosk.api;

import java.util.List;

import kiosk.dinuka.com.kiosk.entities.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dinuka on 27/03/2017.
 */

public interface APIServices {

    @GET("accounts/getprofile")
    Call<List<User>> getProfile(@Query("id") int userId);

    @POST("accounts/login")
    @FormUrlEncoded
    Call<User> login(@Field("collegeId") String collegeId, @Field("password") String password);

}
