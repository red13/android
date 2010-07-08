package project001.project;

import android.util.*;
import android.app.Activity;
import android.os.Bundle;
import project001.project.Dbm;
import android.widget.*;
import java.lang.*;

public class project001 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.e("tag","message");
        Dbm dbm = new Dbm(getBaseContext());
        Log.e("tag","open");
        dbm.open();
        dbm.query("create table test-table (_ID Integer auto inclemental)");
        dbm.close();
        Toast.makeText(getBaseContext(), "toast-test", Toast.LENGTH_LONG).show();
        
        setContentView(R.layout.main);
    }
}