package com.niti.androidstorageapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDatabaseHelper extends SQLiteOpenHelper {

	public SqlDatabaseHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	private static final String DB_NAME = "blog.sqlite";
	private static final int VERSION = 1;
	
	private static final String TABLE_BLOG = "blog";
	public static final String BLOG_TEXT = "blog_text";
	public static String COLUMN_ID = "_id";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_BLOG + " ( " + COLUMN_ID + " integer primary key autoincrement, " + BLOG_TEXT + " varchar)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public long insertBlog(Blog blog) {
		ContentValues cv = new ContentValues();
		cv.put(BLOG_TEXT, blog.getMessage());
		return getWritableDatabase().insert(TABLE_BLOG, null, cv);
	}
	
}
