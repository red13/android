package com.example.Bingoroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Intent;

public class List extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

		// TextView text = (TextView)findViewById(R.id.list_text);
		// ClickListener listener = new ClickListener();
		// text.setOnClickListener(listener);

		Intent intent = getIntent();
		int last = intent.getIntExtra("last-value", 0);
		int data[] = intent.getIntArrayExtra("all-value");

		
		
    }

	// class ClickListener implements View.OnClickListener	{
	// 	@Override
	// 	public void onClick(View v){
	// 		setResult(RESULT_OK);
	// 		finish();
	// 	}
	// }
}
