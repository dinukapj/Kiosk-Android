package kiosk.dinuka.com.kiosk.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.UserSingleton;

public class TopupActivity extends AppCompatActivity {

    EditText etAmount;
    Button btnTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        setTitle("Top-up Account");

        etAmount = (EditText) findViewById(R.id.etAmount);
        btnTopup = (Button) findViewById(R.id.btnTopup);

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAmount.getText().length() != 0) {
                    double newAmount = Double.valueOf(etAmount.getText().toString());

                    double existingBalance = UserSingleton.getInstance().getAccount().getBalance();

                    double outstandingBalance = 0.0;

                    if(existingBalance < 0){
                        outstandingBalance = existingBalance;
                        UserSingleton.getInstance().getAccount().resetBalance();
                    }

                    UserSingleton.getInstance().getAccount().topup(newAmount);

                    Intent resultIntent = new Intent(TopupActivity.this, HomeView.class);
                    resultIntent.putExtra("outstanding", outstandingBalance);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
                else{
                    Snackbar.make(findViewById(android.R.id.content), "Enter an amount to top-up", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}
