package kiosk.dinuka.com.kiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.FirebaseApp;

import kiosk.dinuka.com.kiosk.activities.HomeView;
import kiosk.dinuka.com.kiosk.activities.LoginActivity;
import kiosk.dinuka.com.kiosk.activities.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);

        MainActivity.this.getSupportActionBar().hide();

        startActivity(new Intent(this, WelcomeActivity.class));
        finish();

    }
}
