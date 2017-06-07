package kiosk.dinuka.com.kiosk.activities;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.UserSingleton;

public class HomeView extends AppCompatActivity {

    TextView tvBalance;
    Button btnStartOrder, btnHistory, btnLogout, btnTopup;
    int credit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        ButterKnife.bind(this);

        setTitle("APU Kiosk");

        tvBalance = (TextView) findViewById(R.id.tvBalance);
        btnStartOrder = (Button) findViewById(R.id.btnStartOrder);
        btnHistory = (Button) findViewById(R.id.btnHistory);
        btnTopup = (Button) findViewById(R.id.btnTopup);

        loadCredit();

        setClickEvents();

    }

    private void setClickEvents() {
        btnStartOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserSingleton.getInstance().getAccount().getBalance() > 30) {
                    Intent intent = new Intent(HomeView.this, ChooseFoodActivity.class);
                    intent.putExtra("credit", credit);
                    startActivity(intent);
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Sorry, your balance needs to be at least RM30 to continue", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeView.this, TopupActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void loadCredit() {

        credit = (int) UserSingleton.getInstance().getAccount().getBalance();

        if (UserSingleton.getInstance().getAccount().getBalance() < 0) {
            Snackbar.make(findViewById(android.R.id.content), "You have an outstanding amount in your account. This amount will be deducted from your next top-up", Snackbar.LENGTH_LONG).show();
        }

        credit = Integer.parseInt(credit + "");

        if (credit != 0) {
            ValueAnimator animator = new ValueAnimator();
            animator.setObjectValues(0, credit);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    tvBalance.setText("RM" + String.valueOf(animation.getAnimatedValue()));
                }
            });
            animator.setEvaluator(new TypeEvaluator<Integer>() {
                public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                    return Math.round(startValue + (endValue - startValue) * fraction);
                }
            });
            animator.setDuration(1500);
            animator.start();
        }
    }

    private void deductAnimation(int existingCredit, int newCredit){
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(existingCredit, newCredit);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                tvBalance.setText("RM" + String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(1500);
        animator.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1){
            loadCredit();
            Snackbar.make(findViewById(android.R.id.content), "Successfully topped up account balance", Snackbar.LENGTH_LONG).show();

            double outstandingBalance = data.getDoubleExtra("outstanding", 0.0);

            int outstanding = (int) outstandingBalance;
            outstanding = Integer.parseInt(outstanding + "");

            if(outstandingBalance != 0.0){
                Snackbar mySnackbar = Snackbar.make(findViewById(android.R.id.content), "Outstanding balance of " + Math.abs(outstanding) + " will be deducted from your account", Snackbar.LENGTH_INDEFINITE);
                final int finalOutstanding = Math.abs(outstanding);;
                mySnackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        UserSingleton.getInstance().getAccount().deduct(finalOutstanding);

                        int newBalance = (int) UserSingleton.getInstance().getAccount().getBalance();
                        newBalance = Integer.parseInt(newBalance + "");
                        deductAnimation(credit, newBalance);
                    }
                });
                mySnackbar.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.kitchen_button) {

            Intent intent = new Intent(HomeView.this, KitchenActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
