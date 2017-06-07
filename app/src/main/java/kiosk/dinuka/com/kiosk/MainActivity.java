package kiosk.dinuka.com.kiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.FirebaseApp;

import kiosk.dinuka.com.kiosk.activities.HomeView;
import kiosk.dinuka.com.kiosk.activities.LoginActivity;
import kiosk.dinuka.com.kiosk.activities.WelcomeActivity;
import kiosk.dinuka.com.kiosk.entities.UserSingleton;
import kiosk.dinuka.com.kiosk.helpers.SharedData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);

        MainActivity.this.getSupportActionBar().hide();

        SharedData.getInstance().setBaseURL("http://192.168.1.66:8086/");

        UserSingleton.getInstance().setName("Dinuka");
        UserSingleton.getInstance().getAccount().setBalance(50.0);

        startActivity(new Intent(this, HomeView.class));
        finish();

    }
}
