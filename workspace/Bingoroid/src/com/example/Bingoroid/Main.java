package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Main extends Activity
{
	private final int MENU_ID1 = Menu.FIRST;
	private final int MENU_ID2 = MENU_ID1+1;

	private final int STATE_INITIAL = 0;
	private final int STATE_STARTED = 1;
	private int mStatus = STATE_INITIAL;

	private ArrayList<Integer> mBalls = new ArrayList(125);
	private int mCurIndex = 0;

	private final int REQUEST_CODE_ROLL = 1;
	private final int REQUEST_CODE_LIST = 2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button b = (Button)findViewById(R.id.main_button);
		ClickListener listener = new ClickListener();
		b.setOnClickListener(listener);

		initialize();
    }

	public void initialize(){
		mBalls.clear();
		for ( int n = 0; n < 125; n++ ){
			mBalls.add(n+1);
		}
		Collections.shuffle(mBalls);

		mStatus = STATE_INITIAL;
		mCurIndex = 0;

		Resources res = getResources();
		TextView txt_st = (TextView)findViewById(R.id.main_status);
		txt_st.setText(res.getString(R.string.main_status_initial));

		TextView txt_num = (TextView)findViewById(R.id.main_num_center);
		txt_num.setText(Integer.toString(mCurIndex));
	}

	// menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);

		menu.add(0,
				 MENU_ID1,
				 0,
				 getString(R.string.menu_revert)).setIcon(android.R.drawable.ic_menu_crop);
		menu.add(0,
				 MENU_ID2,
				 1,
				 getString(R.string.menu_exit)).setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		super.onPrepareOptionsMenu(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case MENU_ID1:
			initialize();
			return true;
		case MENU_ID2:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if( requestCode == REQUEST_CODE_ROLL ){
			Intent intent = new Intent();
			intent.setClassName("com.example.Bingoroid",
								"com.example.Bingoroid.List");
			intent.putExtra("last-value", mBalls.get(mCurIndex));
			intent.putExtra("all-value", mBalls.toArray());
			startActivityForResult(intent, REQUEST_CODE_LIST);
		}else /* if( requestCode == REQUEST_CODE_LIST ) */ {
			Resources res = getResources();
			TextView txt_st = (TextView)findViewById(R.id.main_status);
			txt_st.setText(res.getString(R.string.main_status_started));
			
			TextView txt_num = (TextView)findViewById(R.id.main_num_center);
			txt_num.setText(Integer.toString(mCurIndex+1));
		}
	}

	class ClickListener implements View.OnClickListener	{
		@Override
		public void onClick(View v){

			if( mStatus == STATE_INITIAL ){
				mStatus = STATE_STARTED;
			}else{
				mCurIndex++;
			}

			Intent intent = new Intent();
			intent.setClassName("com.example.Bingoroid",
								"com.example.Bingoroid.Roll");
			intent.putExtra("next-value", (Integer)mBalls.get(mCurIndex));
			startActivityForResult(intent, REQUEST_CODE_ROLL);

			// Toast.makeText( getBaseContext(),
			// 				Integer.toString(mCurIndex)+ " : " + Integer.toString(mBalls.get(mCurIndex)),
			// 				Toast.LENGTH_LONG ).show();

		}
	}
}
