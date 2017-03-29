package kiosk.dinuka.com.kiosk.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import kiosk.dinuka.com.kiosk.R;

public class HomeView extends AppCompatActivity {

    @BindView(R.id.rlProgress)
    RelativeLayout rlProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        ButterKnife.bind(this);

        HomeView.this.getSupportActionBar().hide();

        rlProgress.setVisibility(View.VISIBLE);
        new LoadProducts().execute();

    }

    class LoadProducts extends AsyncTask<Void, Void, Void> {

        public LoadProducts() {

        }

        @Override
        protected Void doInBackground(Void... voids) {

            //Place your code here

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });

            return null;

        }
    }

}
