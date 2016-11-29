package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary.model;

import java.io.Serializable;

/**
 * Created by gagaton on 26/11/2016.
 */

public class TD implements Serializable {
    public String menujudul;
    public String menufoto;

    public TD(String menujudul, String menufoto) {
        this.menujudul = menujudul;
        this.menufoto = menufoto;
    }
}