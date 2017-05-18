package kiosk.dinuka.com.kiosk.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kiosk.dinuka.com.kiosk.R;

public class ChooseFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_food);

        setTitle("Choose Dish");

        ChooseFoodActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
