package kiosk.dinuka.com.kiosk.activities.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.adapters.MenuAdapter;
import kiosk.dinuka.com.kiosk.entities.MenuItem;

public class SnacksFragment extends Fragment {

    private static final String ARG_PAGE = "param1";
    private int mPage;
    RecyclerView rvList;
    MenuAdapter adapter;
    ArrayList<MenuItem> items = new ArrayList<>();

    public SnacksFragment() {
    }

    public static SnacksFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SnacksFragment fragment = new SnacksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_snacks_fragment, container, false);
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {

                    return true;
                }
                return false;
            }
        });

        rvList = (RecyclerView) rootView.findViewById(R.id.rvList);

        setMenu();

        return rootView;
    }

    private void setMenu() {

        MenuItem item = new MenuItem();
        item.setAvailable(true);
        item.setId("1");
        item.setName("Fried Rice");
        item.setPicture("http://thewoksoflife.com/wp-content/uploads/2015/12/egg-fried-rice-8.jpg");
        item.setPrice(10.20);
        item.setDescription("Delicious piece of shit");
        items.add(item);

        item = new MenuItem();
        item.setAvailable(false);
        item.setId("2");
        item.setName("Noodles");
        item.setPicture("https://budgetbytes.com/wp-content/uploads/2016/05/Lime-Shrimp-Dragon-Noodles-stix.jpg");
        item.setPrice(6.80);
        item.setDescription("Our favorite Chinese Noodles");
        items.add(item);

        adapter = new MenuAdapter(items, getActivity());
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(mLayoutManager);
        rvList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);

    }
}