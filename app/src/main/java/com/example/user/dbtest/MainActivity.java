package com.example.user.dbtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
    }

    public void click(View v)
    {
        Intent it=new Intent(MainActivity.this,Main2Activity.class);
        it.putExtra("cost",ed1.getText().toString());
        it.putExtra("info",ed2.getText().toString());
        startActivity(it);
    }
}
