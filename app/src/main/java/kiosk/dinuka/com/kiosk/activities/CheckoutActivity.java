package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.KitchenObserver;
import kiosk.dinuka.com.kiosk.entities.OrderSingleton;
import kiosk.dinuka.com.kiosk.entities.Subject;
import kiosk.dinuka.com.kiosk.entities.UserSingleton;

public class CheckoutActivity extends AppCompatActivity {

    private LinearLayout llSuccess, llProcessing;
    private Handler handler = new Handler();
    private Button btnDone;
    private double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        getSupportActionBar().hide();

        total = getIntent().getExtras().getDouble("total");

        llProcessing = (LinearLayout) findViewById(R.id.llProcessing);
        llSuccess = (LinearLayout) findViewById(R.id.llSuccess);
        btnDone = (Button) findViewById(R.id.btnDone);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserSingleton.getInstance().getAccount().deduct(total);
                llProcessing.setVisibility(View.GONE);
                llSuccess.setVisibility(View.VISIBLE);
            }
        }, 3000);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Subject subject = new Subject();
                new KitchenObserver(subject);
                subject.setState(OrderSingleton.getInstance());

                OrderSingleton.resetInstance();

                Intent intent = new Intent(CheckoutActivity.this, HomeView.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }
}
