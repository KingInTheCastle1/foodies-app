package com.example.foodies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseAccess
{
    private SQLiteAssetHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    // private constructor to contain objects in this class
    private DatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // method to return instance of class
    public static DatabaseAccess getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    // method to open db
    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }

    // method to close db
    public void close()
    {
        if(db != null)
        {
            this.db.close();
        }
    }

    // method to query database & return a data object
    public dbData getData(String name)
    {
        // query the db
        c = db.rawQuery("select price, tagline, distance, typeArr from restList where restName = '" + name + "'", new String[]{});

        int price = -1;
        String tagline = "";
        int distance = -1;
        String typeArr = "";

        // some horseshit right here
        while(c.moveToNext())
        {
            price = c.getShort(0);
            tagline = c.getString(1);
            distance = c.getShort(2);
            typeArr = c.getString(3);
        }

        // data object to return
        dbData newDBData = new dbData(
            name, // restaurant name
            price, // price
            tagline, // tagline
            distance, // distance
            typeArr // typeArr
        );

        /*
        System.out.println(newDBData.restName);
        System.out.println(newDBData.price);
        System.out.println(newDBData.tagline);
        System.out.println(newDBData.distance);
        System.out.println(newDBData.typeArr);
         */
        return newDBData;
    }
}
