package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.R;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.TD;

/**
 * Created by gagaton on 26/11/2016.
 */

public class TDAdapter extends RecyclerView.Adapter<TDAdapter.ViewHolder> {

    ArrayList<TD> menuList;
    ITDAdapter mITDAdapter;

    public TDAdapter(Context context, ArrayList<TD> menuList) {
        this.menuList = menuList;
        mITDAdapter = (ITDAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TD td = menuList.get(position);
        holder.tvJudul.setText(td.menujudul);
        holder.ibFoto.setImageURI(Uri.parse(td.menufoto));
    }

    @Override
    public int getItemCount() {
        if (menuList != null)
            return menuList.size();
        return 0;
    }

    public interface ITDAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ibFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ibFoto = (ImageView) itemView.findViewById(R.id.imageMenu);
            tvJudul = (TextView) itemView.findViewById(R.id.textMenu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mITDAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}