package com.bignerdranch.android.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/9/009.
 */

public class Category extends DataSupport {
    private int mId;
    private String mCategoryName;
    private int mCategoryCode;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public int getCategoryCode() {
        return mCategoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        mCategoryCode = categoryCode;
    }
}
