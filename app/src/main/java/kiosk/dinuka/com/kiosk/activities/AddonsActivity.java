package kiosk.dinuka.com.kiosk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.Beverage;
import kiosk.dinuka.com.kiosk.entities.ExtraMilk;
import kiosk.dinuka.com.kiosk.entities.ExtraSugar;
import kiosk.dinuka.com.kiosk.entities.LargeSize;
import kiosk.dinuka.com.kiosk.entities.LowMilk;
import kiosk.dinuka.com.kiosk.entities.LowSugar;
import kiosk.dinuka.com.kiosk.entities.MediumSize;
import kiosk.dinuka.com.kiosk.entities.OrderSingleton;
import kiosk.dinuka.com.kiosk.entities.PlainBeverage;
import kiosk.dinuka.com.kiosk.entities.SmallSize;

public class AddonsActivity extends AppCompatActivity {

    RelativeLayout rlSmallSize, rlMediumSize, rlLargeSize;
    RelativeLayout rlLowSugar, rlExtraSugar;
    RelativeLayout rlLowMilk, rlExtraMilk;
    Button btnContinue;
    TextView rlExtraMilkText;

    String size = "small";
    String sugarLevels = "low";
    String milkLevels = "low";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addons);

        setTitle("Choose Addons");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        rlSmallSize = (RelativeLayout) findViewById(R.id.rlSmallSize);
        rlMediumSize = (RelativeLayout) findViewById(R.id.rlMediumSize);
        rlLargeSize = (RelativeLayout) findViewById(R.id.rlLargeSize);
        rlLowSugar = (RelativeLayout) findViewById(R.id.rlLowSugar);
        rlExtraSugar = (RelativeLayout) findViewById(R.id.rlExtraSugar);
        rlLowMilk = (RelativeLayout) findViewById(R.id.rlLowMilk);
        rlExtraMilk = (RelativeLayout) findViewById(R.id.rlExtraMilk);
        btnContinue = (Button) findViewById(R.id.btnContinue);

        setupClicks();

    }

    private void setupClicks() {

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAddons();
            }
        });

        //size
        rlSmallSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlSmallSize.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rlMediumSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlLargeSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                size = "small";
            }
        });
        rlMediumSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlSmallSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlMediumSize.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rlLargeSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                size = "medium";
            }
        });
        rlLargeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlSmallSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlMediumSize.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlLargeSize.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                size = "large";
            }
        });

        //sugar levels
        rlLowSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLowSugar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rlExtraSugar.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                sugarLevels = "low";
            }
        });
        rlExtraSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLowSugar.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlExtraSugar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                sugarLevels = "extra";
            }
        });

        //milk levels
        rlLowMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLowMilk.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rlExtraMilk.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                milkLevels = "low";
            }
        });
        rlExtraMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLowMilk.setBackgroundColor(getResources().getColor(R.color.lightgrey));
                rlExtraMilk.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                milkLevels = "extra";
            }
        });

    }

    private void calculateAddons() {
        Beverage beverage = null;

        if(size.equals("small")){
            if(sugarLevels.equals("low")){
                if(milkLevels.equals("low")){
                    beverage = new SmallSize(new LowSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new SmallSize(new LowSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
            else{
                if(milkLevels.equals("low")){
                    beverage = new SmallSize(new ExtraSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new SmallSize(new ExtraSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
        }

        if(size.equals("medium")){
            if(sugarLevels.equals("low")){
                if(milkLevels.equals("low")){
                    beverage = new MediumSize(new LowSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new MediumSize(new LowSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
            else{
                if(milkLevels.equals("low")){
                    beverage = new MediumSize(new ExtraSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new MediumSize(new ExtraSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
        }

        if(size.equals("large")){
            if(sugarLevels.equals("low")){
                if(milkLevels.equals("low")){
                    beverage = new LargeSize(new LowSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new LargeSize(new LowSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
            else{
                if(milkLevels.equals("low")){
                    beverage = new LargeSize(new ExtraSugar(new LowMilk(new PlainBeverage())));
                }
                else{
                    beverage = new LargeSize(new ExtraSugar(new ExtraMilk(new PlainBeverage())));
                }
            }
        }

        //Log.d("DINSTER", "size " + size);
        //Log.d("DINSTER", "sugarLevels " + sugarLevels);
        //Log.d("DINSTER", "milkLevels " + milkLevels);
        //Log.d("DINSTER", "TOTAL " + beverage.getPrice());

        PlainBeverage newBeverage = new PlainBeverage();
        newBeverage.setName("TEST NAME");
        newBeverage.setDescription(beverage.getDescription());
        newBeverage.setItemPrice(beverage.getPrice());

        OrderSingleton.getInstance().getItems().add(newBeverage);

        Intent intent = new Intent(AddonsActivity.this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
