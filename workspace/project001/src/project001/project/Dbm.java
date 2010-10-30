package project001.project;

import android.util.*;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;




public class Dbm{
	private SQLiteDatabase db;
	private enum DbmStatus{
		Opened,
		Closed
	};
	private DbmStatus status = DbmStatus.Closed;
	private enum DbmDBExistance{
		Exist,
		NoExist
	};
	private DbmDBExistance db_existance = DbmDBExistance.NoExist;
	public static String DATABASE_NAME = "Dbm.db";
	public static int DATABASE_VERSION = 1;
	private static Context context;


	private static class DbmOpenHelper extends SQLiteOpenHelper{
		/**
		 * constructor
		 * @param ctx context
		 */
		public DbmOpenHelper(Context ctx){
			super(ctx, DATABASE_NAME, null, DATABASE_VERSION );
		}

		/**
		 * create table
		 */
		@Override
		public void onCreate(SQLiteDatabase db){
			// create database
//			db_existance = DbmDBExistance.Exist;
			Log.d("OpenHelper.onCreate",">>onCreate");
			try{
				db.execSQL("CREATE TABLE table-a ( _id INTEGER PRIMARY KEY );");
			}catch(Exception e){
				Log.e("aa","bb");
			}
			Log.d("OpenHelper.onCreate","<<onCreate");
		}

		/**
		 * update
		 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}
	}
	private DbmOpenHelper OpenHelper;

	public Dbm(Context ctx){
		db = null;
		status = DbmStatus.Closed;
		db_existance = DbmDBExistance.NoExist;
		context = ctx;
	}
	
	public boolean open(){
		// create OpenHelper
		Log.d("Dbm.open",">>>open");
		OpenHelper = new DbmOpenHelper( context );
		db = OpenHelper.getWritableDatabase();
		if( db == null ){
			Log.e("DbmOpenHelper.open","db == null");
			return false;
		}
		status = DbmStatus.Opened;
		db_existance = DbmDBExistance.Exist;
		Log.d("Dbm.open", "<<<open");
		return (db != null);
	}
	
	public void close(){
		Log.d("Dbm.close",">>>close");
		status = DbmStatus.Closed;
		Log.d("Dbm.close","<<<close");
	}
	
	public void execSQL(String sql){
		Log.d("Dbm.execSQL",">>>execSQL");
		try{
			db.execSQL(sql);
		}catch(Exception e){
			Log.e("Dbm.execSql",e.getMessage());
		}
		Log.d("Dbm.execSQL","<<<execSQL");
	}
	
	public Cursor rawQuery(String sql){
		Cursor c;
		Log.d("Dbm.rawQuery",">>>query");
		if( db_existance == DbmDBExistance.Exist ){
			try{
				c = db.rawQuery(sql, null);
			}catch( Exception e ){
				Log.e("Dbm.rawQuery", e.getMessage());
				return null;
			}
			Log.d("Dbm.rawQuery","<<<query");
			return c;
		}else{
			Log.d("Dbm.query","<<<query");
			return null;
		}
	}


}

