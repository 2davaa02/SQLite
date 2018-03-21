package com.example.a2davaa02.sqlite;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyHelper sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sql = new MyHelper(this);
        //EditText id=(EditText)findViewById(R.id.ID);
        //EditText title=(EditText)findViewById(R.id.title);
        //EditText artist=(EditText)findViewById(R.id.artist);
        //EditText year=(EditText)findViewById(R.id.year);

        Button add=(Button)findViewById(R.id.add);
        Button search=(Button)findViewById(R.id.search);
        Button update=(Button)findViewById(R.id.update);
        Button delete=(Button)findViewById(R.id.delete);

        add.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        EditText id=(EditText)findViewById(R.id.ID);
        EditText title=(EditText)findViewById(R.id.title);
        EditText artist=(EditText)findViewById(R.id.artist);
        EditText year=(EditText)findViewById(R.id.year);

        id.setText(Long.toString(sql.insertRecord(title.getText().toString(),artist.getText().toString(),Integer.parseInt(year.getText().toString()))));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        sql.close();
    }


}