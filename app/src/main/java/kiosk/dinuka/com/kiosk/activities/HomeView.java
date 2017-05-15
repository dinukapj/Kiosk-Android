package kiosk.dinuka.com.kiosk.activities;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kiosk.dinuka.com.kiosk.R;

public class HomeView extends AppCompatActivity {

    TextView tvBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        ButterKnife.bind(this);

        setTitle("APU Cafe");

        tvBalance = (TextView) findViewById(R.id.tvBalance);

        loadCredit();

    }

    private void loadCredit() {

        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, 200);
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
