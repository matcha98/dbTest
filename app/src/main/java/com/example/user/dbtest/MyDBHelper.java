package com.example.user.dbtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2017/12/31.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        database=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table main.exp "+
        "(_id integer primary key not null, "+
        "cost integer, "+
        "info varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public Cursor query()
    {
        return database.rawQuery("select * from main.exp",null);
    }
}
