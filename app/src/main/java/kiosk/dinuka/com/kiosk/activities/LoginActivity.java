package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.api.UserAPI;
import kiosk.dinuka.com.kiosk.entities.User;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rlBack, rlLogin;
    EditText etCollegeId, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity.this.getSupportActionBar().hide();

        rlBack = (RelativeLayout) findViewById(R.id.rlBack);
        etCollegeId = (EditText) findViewById(R.id.etCollegeId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rlLogin = (RelativeLayout) findViewById(R.id.rlLogin);

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

                        UserAPI api = new UserAPI();
                        User user = api.LoginUser(etCollegeId.getText().toString(), etPassword.getText().toString());
                        if(user.getID().length() != 0){

                        }
                        else{

                        }

                        break;
                }
                return true;
            }
        });

    }
}
