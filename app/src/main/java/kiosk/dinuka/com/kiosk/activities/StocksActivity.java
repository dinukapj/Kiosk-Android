package kiosk.dinuka.com.kiosk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.MenuSingleton;

public class StocksActivity extends AppCompatActivity {

    Switch switch_1, switch_2, switch_3, switch_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);

        setTitle("Availability");

        switch_1 = (Switch) findViewById(R.id.switch_1);
        switch_2 = (Switch) findViewById(R.id.switch_2);
        switch_3 = (Switch) findViewById(R.id.switch_3);
        switch_4 = (Switch) findViewById(R.id.switch_4);

        switch_1.setChecked(MenuSingleton.getInstance().get(0).getAvailable());
        switch_2.setChecked(MenuSingleton.getInstance().get(1).getAvailable());
        switch_3.setChecked(MenuSingleton.getInstance().get(2).getAvailable());
        switch_4.setChecked(MenuSingleton.getInstance().get(3).getAvailable());

        switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                MenuSingleton.getInstance().get(0).setAvailable(checked);
            }
        });

        switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                MenuSingleton.getInstance().get(1).setAvailable(checked);
            }
        });

        switch_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                MenuSingleton.getInstance().get(2).setAvailable(checked);
            }
        });

        switch_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                MenuSingleton.getInstance().get(3).setAvailable(checked);
            }
        });

    }
}
