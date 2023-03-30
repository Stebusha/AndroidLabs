package com.example.mydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ACHIEVEMENTS = "achievements";
    public static final String ACHIEVEMENT_ID = "achievement_id";
    public static final String ACHIEVEMENT_NAME = "achievement_title";

    private static final String SQL_CREATE_ACHIEVEMENTS_TABLE = "CREATE TABLE " + TABLE_ACHIEVEMENTS + " (" + ACHIEVEMENT_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + ACHIEVEMENT_NAME + " VARCHAR(255));";

    private static final String SQL_DELETE_ACHIEVEMENTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_ACHIEVEMENTS;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ACHIEVEMENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w("Lcx;_Tag", "Upgrading DB from version " + oldVersion + " to version " + newVersion);
        sqLiteDatabase.execSQL(SQL_DELETE_ACHIEVEMENTS_TABLE);
        onCreate(sqLiteDatabase);
    }
}
