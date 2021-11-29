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

        return newDBData;
    }

    // return array of 3 random restaurants from db
    public dbData[] getRandomData()
    {
        // obj array to return at the end
        dbData objArray[] = new dbData[3];

        String[] options = new String[3];
        options[0] = "Asian";
        options[1] = "Mexican/Hispanic";
        options[2] = "Seafood";

        for(int i = 0; i < 3; i++)
        {
            // query the db
            c = db.rawQuery("select restName, price, tagline, distance, typeArr from restList where typeArr = '" + options[i] + "' order by random()", new String[]{});

            String restName = "";
            int price = -1;
            String tagline = "";
            int distance = -1;
            String typeArr = "";

            // some horseshit right here
            while(c.moveToNext())
            {
                restName = c.getString(0);
                price = c.getShort(1);
                tagline = c.getString(2);
                distance = c.getShort(3);
                typeArr = c.getString(4);
            }

            // data object to return
            dbData newDBData = new dbData(
                    restName, // restaurant name
                    price, // price
                    tagline, // tagline
                    distance, // distance
                    typeArr // typeArr
            );

            System.out.println(newDBData.restName);
            System.out.println(newDBData.price);
            System.out.println(newDBData.tagline);
            System.out.println(newDBData.distance);
            System.out.println(newDBData.typeArr);

            objArray[i] = newDBData; // append to object array
        }

        return objArray;
    }

    // return array of objects from db according to the preferences
    public dbData getSortedData(PreferenceObj preference)
    {
        String name = preference.getRestName();
        int price = preference.getPrice();
        int distance = preference.getDistance();
        boolean asian = preference.isAsian();
        boolean isCafe = preference.isCafe();
        boolean isMexicanHispanic = preference.isMexicanHispanic();
        boolean isFastFood = preference.isFastFood();
        boolean isPizza = preference.isPizza();
        boolean isItalian = preference.isItalian();
        boolean isSandwiches = preference.isSandwiches();
        boolean isBurgers = preference.isBurgers();
        boolean isDessert = preference.isDessert();
        boolean isChickenWings = preference.isChickenWings();
        boolean isAmerican = preference.isAmerican();
        boolean isBar = preference.isBar();
        boolean isForeign = preference.isForeign();
        boolean isSeafood = preference.isSeafood();
        boolean isBakery = preference.isBakery();
        boolean isOther = preference.isOther();

        // call db with the appropriate filters
        c = db.rawQuery("select price, tagline, distance, typeArr from restList where restName = '" + name + "'", new String[]{});

        String tagline = "";
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

        return newDBData;
    }
}


