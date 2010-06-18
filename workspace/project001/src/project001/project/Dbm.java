package project001.project;

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

	public Dbm(){
		db = null;
		status = DbmStatus.Closed;
		db_existance = DbmDBExistance.NoExist;
	}
	
	public void open(){
		status = DbmStatus.Opened;
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
	public void onCreate(SQLiteDatabase db){
		// create database
		db_existance = DbmDBExistance.Exist;
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		// not supported
	}
}
