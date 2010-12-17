package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Roll extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roll);

		TextView text = (TextView)findViewById(R.id.roll_text);
		ClickListener listener = new ClickListener();
		text.setOnClickListener(listener);
    }

	class ClickListener implements View.OnClickListener	{
		@Override
		public void onClick(View v){
			setResult( RESULT_OK );
			finish();
		}
	}
}
