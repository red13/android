package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class List extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

		TextView text = (TextView)findViewById(R.id.list_text);
		ClickListener listener = new ClickListener();
		text.setOnClickListener(listener);
    }

	class ClickListener implements View.OnClickListener	{
		@Override
		public void onClick(View v){
			finish();
		}
	}
}
