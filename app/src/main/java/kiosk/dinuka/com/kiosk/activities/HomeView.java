package kiosk.dinuka.com.kiosk.activities;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kiosk.dinuka.com.kiosk.R;

public class HomeView extends AppCompatActivity {

    TextView tvBalance;
    Button btnStartOrder, btnHistory, btnLogout;
    int credit = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        ButterKnife.bind(this);

        setTitle("APU Cafe");

        tvBalance = (TextView) findViewById(R.id.tvBalance);
        btnStartOrder = (Button) findViewById(R.id.btnStartOrder);
        btnHistory = (Button) findViewById(R.id.btnHistory);

        loadCredit();

        setClickEvents();

    }

    private void setClickEvents() {
        btnStartOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeView.this, ChooseFoodActivity.class);
                intent.putExtra("credit", credit);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void loadCredit() {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1){
            credit = data.getExtras().getInt("credit");
            loadCredit();
        }
    }
}
