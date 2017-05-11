package com.bignerdranch.android.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mButtonCreate;
    private Button mButtonInsert;
    private Button mButtonUpdate;
    private Button mButtonConditionUpdate;
    private Button mButtonDelete;
    private Button mButtonQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonQuery = (Button) findViewById(R.id.query_book);
        mButtonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Category> categories = DataSupport.where("mCategoryCode = ?", "123").order("mId").find(Category.class);
                for (Category c:
                     categories) {
                    Log.i(TAG, "onClick: " + c.getCategoryName() + " " + c.getId() + " " + c.getCategoryCode());
                }
            }
        });

        mButtonDelete = (Button) findViewById(R.id.delete_book);
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Category.class, "mCategoryCode > ?" , "100");
            }
        });
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

        Book firstBook = DataSupport.findFirst(Book.class);
        List<Book> books = DataSupport.select("name", "author").find(Book.class);
    }
}


