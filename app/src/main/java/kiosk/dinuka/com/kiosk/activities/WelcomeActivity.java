package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import kiosk.dinuka.com.kiosk.R;

public class WelcomeActivity extends AppCompatActivity {

    RelativeLayout rlSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        WelcomeActivity.this.getSupportActionBar().hide();

        rlSwipe = (RelativeLayout) findViewById(R.id.rlSwipe);

        rlSwipe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rlSwipe.setBackgroundResource(R.drawable.flat_button_green_touched);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        rlSwipe.setBackgroundResource(R.drawable.flat_button_green);
                        break;
                    case MotionEvent.ACTION_UP:
                        rlSwipe.setBackgroundResource(R.drawable.flat_button_green);

                        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));

                        break;
                }
                return true;
            }
        });

    }
}
