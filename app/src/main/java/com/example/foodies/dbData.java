package com.example.foodies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class dbData
{
    public String restName = "";
    public int price = -1;
    public String tagline = "";
    public int distance = -1;
    public String typeArr = "";

    // constructor for data from db
    public dbData(String restName, int price, String tagline, int distance, String typeArr)
    {
        this.restName = restName;
        this.price = price;
        this.tagline = tagline;
        this.distance = distance;
        this.typeArr = typeArr;
    }
}
