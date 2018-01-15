package com.example.user.dbtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        sqLiteDatabase.execSQL("create table if not exists main.exp "+
        "(_id integer primary key not null, "+
        "cost integer, "+
        "info varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table exp");
        onCreate(sqLiteDatabase);
    }

    public Cursor query()
    {
        Log.d("Path",database.getPath());
        return database.rawQuery("select * from main.exp",null);
    }
}
