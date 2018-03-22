package com.example.a2davaa02.sqlite;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyHelper sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sql = new MyHelper(this);

        Button add=(Button)findViewById(R.id.add);
        Button search=(Button)findViewById(R.id.search);
        //Button update=(Button)findViewById(R.id.update);
        //Button delete=(Button)findViewById(R.id.delete);

        add.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        EditText id=(EditText)findViewById(R.id.ID);
                        EditText title=(EditText)findViewById(R.id.Title);
                        EditText artist=(EditText)findViewById(R.id.artist);
                        EditText year=(EditText)findViewById(R.id.year);

                        String sTitle = title.getText().toString(), sArtist =artist.getText().toString();
                        long lYear = Long.parseLong(year.getText().toString());

                        long insertId = sql.insertRecord(sTitle, sArtist, lYear);

                        id.setText(Long.toString(insertId));
                    }
                }
        );
        search.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        EditText id=(EditText)findViewById(R.id.ID);
                        EditText title=(EditText)findViewById(R.id.Title);
                        EditText artist=(EditText)findViewById(R.id.artist);
                        EditText year=(EditText)findViewById(R.id.year);

                        Song s=sql.findSong(Integer.parseInt(id.getText().toString()));

                        title.setText(s.getTitle());
                        artist.setText(s.getArtist());
                        year.setText(Long.toString(s.getYear()));
                    }
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sql.close();
    }


}