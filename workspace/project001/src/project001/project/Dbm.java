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
			try{
				db.execSQL("CREATE TABLE ");
			}catch(Exception e){
				Log.e("aa","bb");
			}
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
		OpenHelper = new DbmOpenHelper( context );
		db = OpenHelper.getWritableDatabase();
		status = DbmStatus.Opened;
		return (db != null);
	}
	
	public void close(){
		status = DbmStatus.Closed;
	}
	
	public Cursor query(String sql){
		if( db_existance == DbmDBExistance.Exist ){
			return db.rawQuery(sql, null);
		}else{
			return null;
		}
	}


}

