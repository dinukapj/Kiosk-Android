package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.adapters.CartAdapter;
import kiosk.dinuka.com.kiosk.adapters.MenuAdapter;
import kiosk.dinuka.com.kiosk.entities.MenuItem;
import kiosk.dinuka.com.kiosk.entities.OrderSingleton;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    Button btnAdd, btnCheckout;
    TextView tvTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setTitle("Your Cart");

        rvCart = (RecyclerView) findViewById(R.id.rvCart);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);
        tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, ChooseFoodActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        setupCart();

    }

    private void setupCart() {
        ArrayList<MenuItem> cartItems = OrderSingleton.getInstance().getItems();
        CartAdapter adapter = new CartAdapter(cartItems, CartActivity.this);
        rvCart.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CartActivity.this);
        rvCart.setLayoutManager(mLayoutManager);
        rvCart.addItemDecoration(new DividerItemDecoration(CartActivity.this, LinearLayoutManager.VERTICAL));
        rvCart.setItemAnimator(new DefaultItemAnimator());
        rvCart.setAdapter(adapter);

        double totalPrice = 0.0;
        for (int i = 0; i < cartItems.size(); i++) {
            totalPrice = totalPrice + cartItems.get(i).getItemPrice();
        }
        DecimalFormat f = new DecimalFormat("##.00");
        tvTotalPrice.setText("RM" + f.format(totalPrice));
    }
}
