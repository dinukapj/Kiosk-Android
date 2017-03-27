package kiosk.dinuka.com.kiosk.api;

import android.util.Log;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.HttpResponse;
import kiosk.dinuka.com.kiosk.entities.User;
import kiosk.dinuka.com.kiosk.helpers.ResponseCallBack;
import kiosk.dinuka.com.kiosk.helpers.SharedData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dinuka on 27/03/2017.
 */

public class UserAPI {

    HttpResponse<User> httpResponse = new HttpResponse<>("", "", new User());

    public void LoginUser(String collegeId, String password, final ResponseCallBack<HttpResponse<User>> callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SharedData.getInstance().getBaseURL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIServices service = retrofit.create(APIServices.class);

        Call<HttpResponse<User>> call = service.login(collegeId, password);
        call.enqueue(new Callback<HttpResponse<User>>() {
            @Override
            public void onResponse(Call<HttpResponse<User>> call, Response<HttpResponse<User>> response) {
                if (response.isSuccessful()) {
                    httpResponse = response.body();
                    callBack.onSuccess(httpResponse);
                }
            }

            @Override
            public void onFailure(Call<HttpResponse<User>> call, Throwable t) {
                callBack.onFailure("Server error. Please try again later");
                Log.d("DINSTER", t.toString());
            }
        });
    }

}
