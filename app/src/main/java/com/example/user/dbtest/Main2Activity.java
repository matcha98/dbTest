package com.example.user.dbtest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv3;
    private MyDBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv3=findViewById(R.id.textView3);

        helper=new MyDBHelper(this,"expense.db",null,1);

        Intent it=getIntent();
        int cost=Integer.valueOf(it.getStringExtra("cost"));
        String info=it.getStringExtra("info");
        ContentValues values=new ContentValues();
        values.put("cost",cost);
        values.put("info",info);
        long id=helper.getWritableDatabase().insert("exp",null,values);
        Log.d("ADD",id+"");
    }

    public void click3(View v)
    {
        Cursor c=helper.query();
        c.moveToFirst();
        String str="";
        while(c.moveToNext()){
            str=str+c.getString(2)+"\n";
        }
        tv3.setText(str);
    }
}
