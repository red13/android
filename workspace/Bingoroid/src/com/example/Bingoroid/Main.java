package com.example.Bingoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class Main extends Activity
{
	private final int MENU_ID1 = Menu.FIRST;
	private final int MENU_ID2 = MENU_ID1+1;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
			Intent intent = new Intent();
			intent.setClassName(
				"com.example.Bingoroid",
				"com.example.Bingoroid.Roll");
			startActivity(intent);
			return true;
		case MENU_ID2:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
