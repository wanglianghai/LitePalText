package com.bignerdranch.android.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class MainActivity extends AppCompatActivity {
    private Button mButtonCreate;
    private Button mButtonInsert;
    private Button mButtonUpdate;
    private Button mButtonConditionUpdate;

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

        mButtonUpdate = (Button) findViewById(R.id.update_book);
        mButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = DataSupport.find(Category.class, 5);
                c.setCategoryCode(100);
                c.save();
            }
        });

        mButtonConditionUpdate = (Button) findViewById(R.id.condition_update);
        mButtonConditionUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = new Category();
                c.setCategoryName("B");
                c.updateAll("mCategoryCode = ? ", "123");
            }
        });
    }
}
