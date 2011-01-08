package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import android.content.res.Resources;
import android.content.Intent;
import android.view.Gravity;

public class Roll extends Activity
{
	private int mNumber;
	private int mCount = 0;
	private Handler mHdlr = new Handler();
	private Runnable mRun = new Runnable(){
			public void run(){
				mCount++;

				if( mCount < 5 ){
					Resources res = getResources();
					TextView v = (TextView)findViewById(R.id.roll_text);
					if( (mCount % 2) == 0 ){
						v.setTextSize( 12 );
					}else{
						v.setTextSize( 15 );
					}
					Message msg = mHdlr.obtainMessage();
					mHdlr.postDelayed(mRun, 500);

				}else if( mCount == 5 ){
					Resources res = getResources();
					TextView v = (TextView)findViewById(R.id.roll_text);
					String s = new String();
					if( mNumber <= 15 ){
						s = "B-";
					}else if( mNumber <= 30 ){
						s = "I-";
					}else if( mNumber <= 45 ){
						s = "N-";
					}else if( mNumber <= 60 ){
						s = "G-";
					}else{
						s = "O-";
					}
					s = s + Integer.toString(mNumber);
					v.setText( s );
					v.setGravity(Gravity.CENTER);
					v.setTextSize( 18 );

					Message msg = mHdlr.obtainMessage();
					mHdlr.postDelayed(mRun, 3000);

				}else{
					mCount = 0;
					setResult( RESULT_OK );
					finish();
				}
			}};
			

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roll);

		Intent intent = getIntent();
		mNumber = intent.getIntExtra("next-value", 0);
		if( mNumber == 0 ){
			setResult( RESULT_CANCELED );
			finish();
		}

		Message msg = mHdlr.obtainMessage();
		mHdlr.postDelayed(mRun, 500);

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
