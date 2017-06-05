package kiosk.dinuka.com.kiosk.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import kiosk.dinuka.com.kiosk.R;

public class CheckoutActivity extends AppCompatActivity {

    LinearLayout llSuccess, llProcessing;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        llProcessing = (LinearLayout) findViewById(R.id.llProcessing);
        llSuccess = (LinearLayout) findViewById(R.id.llSuccess);



    }
}
