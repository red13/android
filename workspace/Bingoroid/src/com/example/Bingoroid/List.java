package com.example.Bingoroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class List extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		int last_value = intent.getIntExtra("last-value", 0);
		if( last_value == 0 ){
			// unexpected
			finish();
		}else{
			int[] data = intent.getIntArrayExtra("all-value");
			
			// int last_index = 1;
			// for( int n = 0; n < data.length; n++ ){
			// 	if( last_value == data[n] ){
			// 		last_index = n;
			// 		break;
			// 	}
			// }
			
			// String[] str = new String[last_index];
			// for( int n = 0; n <= last_index; n++ ){
			// 	str[n] = Integer.toString(data[n]);
			// }
			
			// ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
			// 														 R.layout.list,
			// 														 str );
			
			// setListAdapter(adapter);
			
			finish();
		}
	}
}
