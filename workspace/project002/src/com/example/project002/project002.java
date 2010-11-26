package com.example.project002;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

public class project002 extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button b = (Button)findViewById(R.id.button_id);
		ClickListener listener = new ClickListener();
		b.setOnClickListener(listener);

    }

	Handler mHdlr = new Handler();
	Runnable mGo = new Runnable() {
			public void run(){
				Resources res = getResources();
				Button b = (Button)findViewById(R.id.button_id);
				String s = getString(R.string.button_label2);
				b.setText(s);

				Message msg = mHdlr.obtainMessage();
				mHdlr.postDelayed(mBack, 1000);
			}
		};

	Runnable mBack = new Runnable() {
			public void run(){
				Resources res = getResources();
				Button b = (Button)findViewById(R.id.button_id);
				String s = getString(R.string.button_label);
				b.setText(s);

				Message msg = mHdlr.obtainMessage();
				mHdlr.postDelayed(mGo, 1000);
			}
		};


	class ClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Button b = (Button)v;
			Resources res = getResources();
			String s = res.getString(R.string.button_label2);

			b.setText(s);

			Message msg = mHdlr.obtainMessage();
			mHdlr.postDelayed(mGo, 1000);
		}
	}
}
