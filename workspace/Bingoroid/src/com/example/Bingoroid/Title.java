package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class Title extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);

		TextView text = (TextView)findViewById(R.id.title);
		ClickListener listener = new ClickListener();
		text.setOnClickListener(listener);
    }

	class ClickListener implements View.OnClickListener	{
		@Override
		public void onClick(View v){
			Intent i = new Intent();
			i.setClassName("com.example.Bingoroid",
						   "com.example.Bingoroid.Main");
			startActivity(i);
		}
	}
}
