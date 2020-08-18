package com.example.myappinterview.db.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *  Generally DataBase configuration
 */
public class SampleDbSQLiteHelper extends SQLiteOpenHelper {

  private static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "sample_database";

  public SampleDbSQLiteHelper(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
	sqLiteDatabase.execSQL(SampleDbContract.EmployeeDb.CREATE_TABLE);
  }
  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
	sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDbContract.EmployeeDb.TABLE_NAME);
	onCreate(sqLiteDatabase);
  }
}
