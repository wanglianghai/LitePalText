package com.bignerdranch.android.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/9/009.
 */

public class Book extends DataSupport {
    private int mId;
    private String mAuthor;
    private double mPrice;
    private int mPages;
    private String mName;
    private String mPress;

    public String getPress() {
        return mPress;
    }

    public void setPress(String press) {
        mPress = press;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getPages() {
        return mPages;
    }

    public void setPages(int pages) {
        mPages = pages;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
