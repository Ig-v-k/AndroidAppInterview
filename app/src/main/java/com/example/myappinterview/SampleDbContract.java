package com.example.myappinterview;

import android.provider.BaseColumns;

public final class SampleDbContract {
  private SampleDbContract() { }

  public static class EmployeeDb implements BaseColumns {
	public static final String TABLE_NAME = "bws_coworkers";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_TELEPHONE = "telephone";
	public static final String COLUMN_AGE = "age";
	public static final String COLUMN_SEX = "sex";
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
		  TABLE_NAME + " (" +
		  _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		  COLUMN_NAME + " TEXT, " +
		  COLUMN_TELEPHONE + " TEXT, " +
		  COLUMN_AGE + " INTEGER, " +
		  COLUMN_SEX + " TEXT" + ")";
  }

}
