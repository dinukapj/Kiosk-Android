package kiosk.dinuka.com.kiosk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kiosk.dinuka.com.kiosk.R;

public class HomeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        HomeView.this.getSupportActionBar().hide();


    }
}
