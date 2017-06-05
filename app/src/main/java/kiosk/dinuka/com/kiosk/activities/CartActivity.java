package kiosk.dinuka.com.kiosk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import kiosk.dinuka.com.kiosk.R;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    Button btnAdd, btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setTitle("Your Cart");

        rvCart = (RecyclerView) findViewById(R.id.rvCart);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);



    }
}
