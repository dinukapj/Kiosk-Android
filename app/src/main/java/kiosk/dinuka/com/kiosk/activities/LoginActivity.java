package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.api.UserAPI;
import kiosk.dinuka.com.kiosk.entities.HttpResponse;
import kiosk.dinuka.com.kiosk.entities.User;
import kiosk.dinuka.com.kiosk.helpers.ResponseCallBack;
import kiosk.dinuka.com.kiosk.helpers.SharedData;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rlBack, rlLogin, rlProgress;
    EditText etCollegeId, etPassword;
    TextView tvError;
    HttpResponse<User> response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity.this.getSupportActionBar().hide();

        rlBack = (RelativeLayout) findViewById(R.id.rlBack);
        etCollegeId = (EditText) findViewById(R.id.etCollegeId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rlLogin = (RelativeLayout) findViewById(R.id.rlLogin);
        rlProgress = (RelativeLayout) findViewById(R.id.rlProgress);
        tvError = (TextView) findViewById(R.id.tvError);

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rlLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rlLogin.setBackgroundResource(R.drawable.flat_button_green_touched);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        rlLogin.setBackgroundResource(R.drawable.flat_button_green);
                        break;
                    case MotionEvent.ACTION_UP:
                        rlLogin.setBackgroundResource(R.drawable.flat_button_green);

                        rlProgress.setVisibility(View.VISIBLE);

                        new Login(etCollegeId.getText().toString(), etPassword.getText().toString()).execute();

                        break;
                }
                return true;
            }
        });

    }

    class Login extends AsyncTask<Void, Void, Void> {

        String collegeId, password;

        public Login(String collegeId, String password) {
            this.collegeId = collegeId;
            this.password = password;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            UserAPI api = new UserAPI();
            api.LoginUser(collegeId, password, new ResponseCallBack<HttpResponse<User>>() {
                @Override
                public void onSuccess(HttpResponse<User>... t) {

                    response = t[0];

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (response.status.equals("SUCCESS")) {
                                tvError.setText("");
                                
                                User user = response.object;
                                SharedData.getInstance().setUser(user);

                                Intent intent = new Intent(LoginActivity.this, HomeView.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                tvError.setText(response.description);
                            }
                            rlProgress.setVisibility(View.GONE);
                        }
                    });
                }

                @Override
                public void onFailure(String error) {
                    tvError.setText(response.description);
                    rlProgress.setVisibility(View.GONE);
                }
            });

            return null;

        }
    }
}
