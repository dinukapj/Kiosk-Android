package kiosk.dinuka.com.kiosk.api;

import android.util.Log;

import kiosk.dinuka.com.kiosk.entities.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dinuka on 27/03/2017.
 */

public class UserAPI {

    User user = new User();

    public User LoginUser(String collegeId, String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3306/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIServices service = retrofit.create(APIServices.class);

        Call<User> call = service.login(collegeId, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return user;
    }

}
