package tw.rackx.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private final static int _Version = 1;
	
	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public DBHelper(Context context, String name) {
		super(context, name, null, _Version);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		String DATABASE_CREATE_TABLE =
			     "CREATE TABLE Config("
			       + "_ID INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"
			             + "key VARCHAR,"
			             + "value VARCHAR"
			         + ");";
		db.execSQL(DATABASE_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion ) {
		db.execSQL("DROP TABLE IF EXISTS newMemorandum"); //刪除舊有的資料表
		onCreate(db);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
	
	@Override
	public synchronized void close() {
		super.close();
	}
}
