package kiosk.dinuka.com.kiosk.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.astuetz.PagerSlidingTabStrip;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.adapters.PagerAdapter;

public class ChooseFoodActivity extends AppCompatActivity {

    ViewPager vpMenu;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_food);

        setTitle("Choose Dish");

        ChooseFoodActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpMenu = (ViewPager) findViewById(R.id.vpMenu);

        adapter = new PagerAdapter(ChooseFoodActivity.this, getSupportFragmentManager());
        vpMenu.setAdapter(adapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(vpMenu);

    }
}
