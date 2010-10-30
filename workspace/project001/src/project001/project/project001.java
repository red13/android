package project001.project;

import android.util.*;
import android.app.Activity;
import android.os.Bundle;
import project001.project.Dbm;
import android.widget.*;
import android.database.*;

public class project001 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d("project001.onCreate",">new Dbm");
        Dbm dbm = new Dbm(getBaseContext());
        Log.d("project001.onCreate","<new Dbm");

        Log.d("project001.onCreate",">Dbm.open");
        dbm.open();
        Log.d("project001.onCreate","<Dbm.open");

        Log.d("project001.onCreate",">Dbm.query");
        dbm.execSQL("create table test_table (_id integer primary key, f1 integer, f2 char(30) );");
        Log.d("project001.onCreate","<Dbm.query");

        Log.d("project001.onCreate",">Dbm.query2");
        dbm.execSQL("insert into test_table ( f1, f2 ) values ( 1, 'android' );");
        dbm.execSQL("insert into test_table ( f1, f2 ) values ( 2, 'android' );");
        dbm.execSQL("insert into test_table ( f1, f2 ) values ( 3, 'android' );");
        dbm.execSQL("insert into test_table ( f1, f2 ) values ( 4, 'android' );");
        dbm.execSQL("insert into test_table ( f1, f2 ) values ( 5, 'android' );");
        Log.d("project001.onCreate","<Dbm.query2");

        Cursor c;
        Log.d("project001.onCreate",">Dbm.query3");
        c = dbm.rawQuery("select * from test_table;");
        Log.d("project001.onCreate","<Dbm.query3");

        if( c != null ){
	
	        Log.d("project001.onCreate", "count:"+c.getCount());
	        String str[] = c.getColumnNames();
	        for (int n = 0; n < c.getColumnCount(); n++){
	        	Log.d("project001.onCreate", "CulumnNames:"+str[n]);
	        }
	        while( c.moveToNext() ){
		        for (int n = 0; n < c.getColumnCount(); n++){
			        for (int m = 0; m < c.getColumnCount(); m++){
			        	Log.d("project001.onCreate", str[m]+":"+c.getString(m));
			        }
		        }
	        }
        }
        
        Log.d("project001.onCreate", ">Dbm.query4");
        dbm.execSQL("drop table test_table;");
        Log.d("project001.onCreate", "<Dbm.query4");
        
        Log.d("project001.onCreate",">Dbm.close");
        dbm.close();
        Log.d("project001.onCreate","<Dbm.close");
        
        Toast.makeText(getBaseContext(), "toast-test", Toast.LENGTH_LONG).show();
        
        setContentView(R.layout.main);
    }
}