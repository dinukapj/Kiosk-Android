package kiosk.dinuka.com.kiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.FirebaseApp;

import kiosk.dinuka.com.kiosk.activities.HomeView;
import kiosk.dinuka.com.kiosk.activities.LoginActivity;
import kiosk.dinuka.com.kiosk.activities.WelcomeActivity;
import kiosk.dinuka.com.kiosk.adapters.MenuAdapter;
import kiosk.dinuka.com.kiosk.entities.MenuItem;
import kiosk.dinuka.com.kiosk.entities.MenuSingleton;
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

        setMenu();

        startActivity(new Intent(this, HomeView.class));
        finish();

    }

    private void setMenu() {

        MenuItem item = new MenuItem();
        item.setAvailable(true);
        item.setId("1");
        item.setName("Coffee");
        item.setPicture("http://blog.wlingua.com/learn-english/wp-content/uploads/sites/11/2016/05/coffee-cup.jpg");
        item.setItemPrice(3.60);
        item.setDescription("Tastes bitter but it definitely keeps you up at night");
        item.setType("beverage");
        MenuSingleton.getInstance().add(item);

        item = new MenuItem();
        item.setAvailable(false);
        item.setId("2");
        item.setName("Milo");
        item.setPicture("https://www.milo.com.ph/sites/milo_philippines2/files/whats-in-a-mug-image.jpg");
        item.setItemPrice(2.60);
        item.setDescription("Tastes like Milo. Trust me, I tried");
        item.setType("beverage");
        MenuSingleton.getInstance().add(item);

        item = new MenuItem();
        item.setAvailable(true);
        item.setId("1");
        item.setName("Fried Rice");
        item.setPicture("http://thewoksoflife.com/wp-content/uploads/2015/12/egg-fried-rice-8.jpg");
        item.setItemPrice(10.20);
        item.setDescription("Delicious piece of shit");
        item.setType("snack");
        MenuSingleton.getInstance().add(item);

        item = new MenuItem();
        item.setAvailable(false);
        item.setId("2");
        item.setName("Noodles");
        item.setPicture("https://budgetbytes.com/wp-content/uploads/2016/05/Lime-Shrimp-Dragon-Noodles-stix.jpg");
        item.setItemPrice(6.80);
        item.setDescription("Our favorite Chinese Noodles");
        item.setType("snack");
        MenuSingleton.getInstance().add(item);

    }

}
