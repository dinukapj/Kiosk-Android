package kiosk.dinuka.com.kiosk.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.entities.KitchenOrdersSingleton;
import kiosk.dinuka.com.kiosk.entities.MenuItem;
import kiosk.dinuka.com.kiosk.entities.Order;

/**
 * Created by dinuka on 07/06/2017.
 */

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.ViewHolder> {

    private List<Order> items;
    private Context context;

    public KitchenAdapter(List<Order> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_kitchen_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = items.get(position);

        String items = "";

        int currentOrderNumber = position + 1;
        items = "<b>Order #" + currentOrderNumber + "</b>";

        int count = 0;
        for (MenuItem item : order.getItems()) {

            if (count != 0) {
                items = items + "<br>" + "<b>" + item.getName() + "</b>";
                items = items + "<br>" + "<p>" + item.getDescription() + "</p>";
            } else {
                items = items + "<br><br>" + "<b>" + item.getName() + "</b>";
                items = items + "<br>" + "<p>" + item.getDescription() + "</p>";
            }

            count++;
        }

        holder.tvOrderDetails.setText(Html.fromHtml(items));
        holder.tvUser.setText("Order placed by " + order.getUser().getName());

        final ViewHolder hl = holder;
        hl.btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Mark as Complete")
                        .setMessage("Are you sure you want to mark this order as complete?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ArrayList<Order> orders = KitchenOrdersSingleton.getInstance();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

        holder.itemView.setTag(order);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderDetails;
        TextView tvUser;
        Button btnComplete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvOrderDetails = (TextView) itemView.findViewById(R.id.tvOrderDetails);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            btnComplete = (Button) itemView.findViewById(R.id.btnComplete);
        }
    }

}