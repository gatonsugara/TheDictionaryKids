package id.sch.smktelkom_mlg.project.xiirpl302122232.thedictionary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SMK Telkom SP Malang on 29/11/2016.
 */
public class PrefManager
{

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "androidhive-welcome";
    private static final  String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsFirstTimeLaunch(boolean isFirstTimeLaunch){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch);
        editor.commit();
    }
    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}