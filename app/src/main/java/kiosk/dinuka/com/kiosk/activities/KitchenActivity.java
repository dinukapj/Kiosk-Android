package kiosk.dinuka.com.kiosk.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.adapters.KitchenAdapter;
import kiosk.dinuka.com.kiosk.entities.KitchenOrdersSingleton;
import kiosk.dinuka.com.kiosk.entities.Order;

public class KitchenActivity extends AppCompatActivity {

    static RecyclerView rvOrders;
    static Context context;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        setTitle("Kitchen");

        context = KitchenActivity.this;
        activity = KitchenActivity.this;

        KitchenActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvOrders = (RecyclerView) findViewById(R.id.rvOrders);

        setupData();

    }

    private void setupData(){
        ArrayList<Order> orders = KitchenOrdersSingleton.getInstance();
        KitchenAdapter adapter = new KitchenAdapter(orders, context);
        rvOrders.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        rvOrders.setItemAnimator(new DefaultItemAnimator());
        rvOrders.setAdapter(adapter);
    }

}
