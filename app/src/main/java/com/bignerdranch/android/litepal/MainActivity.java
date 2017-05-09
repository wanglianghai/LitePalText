package com.bignerdranch.android.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {
    private Button mButtonCreate;
    private Button mButtonInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonCreate = (Button) findViewById(R.id.create_database_button);
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = LitePal.getDatabase();
            }
        });

        mButtonInsert = (Button) findViewById(R.id.add_book);
        mButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = new Category(1, "A", 123);
                c.save();
            }
        });
    }
}
