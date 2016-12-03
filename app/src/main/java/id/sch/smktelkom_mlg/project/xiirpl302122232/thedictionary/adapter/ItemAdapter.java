package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.R;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.Item;

/**
 * Created by gagaton on 02/12/2016.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    ArrayList<Item> Item;
    ItemAdapterI itemAdapter;
    MediaPlayer mp;


    public ItemAdapter(Context context, ArrayList<Item> Item) {
        this.Item = Item;
        itemAdapter = (ItemAdapter.ItemAdapterI) context;
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_item, parent, false);
        ItemAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item it = Item.get(position);
        holder.tvitem.setText(it.Item);
        holder.ivitem.setImageURI(Uri.parse(it.ItemFoto));
        it.mp = new MediaPlayer();
        it.mp = MediaPlayer.create(it.context, getId(it.song, R.raw.class));
        this.mp = it.mp;
    }

    @Override
    public int getItemCount() {
        if (Item != null)
            return Item.size();
        return 0;
    }

    public interface ItemAdapterI {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivitem;
        TextView tvitem;

        public ViewHolder(View itemView) {
            super(itemView);
            ivitem = (ImageView) itemView.findViewById(R.id.imageItem);
            tvitem = (TextView) itemView.findViewById(R.id.textItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }

}