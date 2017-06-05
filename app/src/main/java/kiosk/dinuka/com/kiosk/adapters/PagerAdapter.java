package kiosk.dinuka.com.kiosk.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kiosk.dinuka.com.kiosk.activities.fragments.BeveragesFragment;
import kiosk.dinuka.com.kiosk.activities.fragments.SnacksFragment;

/**
 * Created by dinuka on 02/06/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = { "Snacks", "Beverages" };
    private Context context;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return SnacksFragment.newInstance(index);
            case 1:
                return BeveragesFragment.newInstance(index);

        }
        return null;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

}


