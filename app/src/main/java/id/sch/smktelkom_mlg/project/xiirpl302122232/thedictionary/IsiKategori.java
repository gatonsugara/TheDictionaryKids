package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.adapter.ItemAdapter;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.Item;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.TD;

public class IsiKategori extends AppCompatActivity implements ItemAdapter.ItemAdapterI {

    ItemAdapter mAdapter;
    ArrayList<Item> mItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_kategori);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TD td = (TD) getIntent().getSerializableExtra(MainActivity.TD);
        setTitle(td.menujudul);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewItem);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ItemAdapter(this, mItem);
        recyclerView.setAdapter(mAdapter);

        Resources resources = getResources();
        String[] categories = getResources().getStringArray(R.array.menu);
        TextView tv = (TextView) findViewById(R.id.textItem);
        ImageView ib = (ImageView) findViewById(R.id.imageItem);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void doClick(int pos) {

    }
}