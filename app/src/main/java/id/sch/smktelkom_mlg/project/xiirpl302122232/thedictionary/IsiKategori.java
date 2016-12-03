package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.adapter.ItemAdapter;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.Item;
import id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model.TD;

public class IsiKategori extends AppCompatActivity implements ItemAdapter.ItemAdapterI {

    ItemAdapter mAdapter;
    ArrayList<Item> mItem = new ArrayList<>(30);

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for :"
                    + resourceName + " / " + c, e);
        }
    }

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

        String data[] = null;
        String foto[] = null;

        if (td.menujudul.equals(categories[0])) {
            fillData("animals_name", "animals_picture", "animals_song");
        } else if (td.menujudul.equals(categories[1])) {
            fillData("fruit_name", "fruit_picture", "fruit_song");
        } else if (td.menujudul.equals(categories[2])) {
        } else if (td.menujudul.equals(categories[3])) {
            fillData("transportation_name", "transportation_picture", "transportation_song");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void fillData(String cat, String catFoto, String catSound) {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(getId(cat, R.array.class));
        TypedArray a = resources.obtainTypedArray(getId(catFoto, R.array.class));
        MediaPlayer mp = new MediaPlayer();
        String[] arSong = resources.getStringArray(getId(catSound, R.array.class));

        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + "/"
                    + resources.getResourceEntryName(id);
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mItem.add(new Item(arJudul[i], arFoto[i], arSong[i], this));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        mItem.get(pos).mp.start();

    }
}