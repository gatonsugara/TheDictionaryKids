
package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.Serializable;

/**
 * Created by gagaton on 02/12/2016.
 */

public class Item implements Serializable {
    public String Item;
    public String ItemFoto;
    public String song;
    public Context context;
    public MediaPlayer mp;

    public Item(String Item, String ItemFoto, String song, Context context) {
        this.Item = Item;
        this.ItemFoto = ItemFoto;
        this.song = song;
        this.context = context;
        this.mp = new MediaPlayer();
    }
}