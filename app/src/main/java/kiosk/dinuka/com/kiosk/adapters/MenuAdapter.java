package kiosk.dinuka.com.kiosk.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

import kiosk.dinuka.com.kiosk.R;
import kiosk.dinuka.com.kiosk.activities.AddonsActivity;
import kiosk.dinuka.com.kiosk.activities.CartActivity;
import kiosk.dinuka.com.kiosk.entities.MenuItem;
import kiosk.dinuka.com.kiosk.entities.OrderSingleton;

/**
 * Created by dinuka on 02/06/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuItem> items;
    private Context context;
    private Activity activity;

    public MenuAdapter(List<MenuItem> items, Context context, Activity activity) {
        this.items = items;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_menu_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MenuItem item = items.get(position);

        //set name
        holder.tvName.setText(item.getName());

        //set description
        holder.tvDetails.setText(item.getDescription());

        //set price
        holder.tvPrice.setText("RM" + item.getItemPrice());

        //set availability
        if (item.getAvailable()) {
            holder.tvStatus.setText("Available");
        } else {
            holder.tvStatus.setText("Out of order");
        }

        //set image
        Uri imageUri = Uri.parse(item.getPicture());
        int width = 300, height = 300;
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(imageUri)
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setOldController(holder.sdvPicture.getController())
                .setImageRequest(request)
                .build();
        holder.sdvPicture.setController(controller);

        final ViewHolder hl = holder;
        hl.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.getAvailable()) {
                    if (item.getType().equals("beverage")) {
                        Intent intent = new Intent(context, AddonsActivity.class);
                        intent.putExtra("beverageName", item.getName());
                        context.startActivity(intent);
                    } else {
                        OrderSingleton.getInstance().getItems().add(item);
                        Intent intent = new Intent(context, CartActivity.class);
                        context.startActivity(intent);
                    }
                }
                else{
                    Snackbar.make(activity.findViewById(android.R.id.content), "Sorry the selected item is currently out of order", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetails, tvPrice, tvStatus;
        SimpleDraweeView sdvPicture;
        LinearLayout content;
        Button btnAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDescription);
            sdvPicture = (SimpleDraweeView) itemView.findViewById(R.id.sdvPicture);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            content = (LinearLayout) itemView.findViewById(R.id.content);
            btnAdd = (Button) itemView.findViewById(R.id.btnAdd);
        }
    }

}

