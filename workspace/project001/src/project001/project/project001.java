package project001.project;

import android.app.Activity;
import android.os.Bundle;
import project001.project.Dbm;

public class project001 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Dbm dbm = new Dbm();
        dbm.open();
        dbm.close();
        
        setContentView(R.layout.main);
    }
}