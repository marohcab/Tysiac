package com.example.bachor.tysiac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bachor on 2017-08-31.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Dane.db";
    public static final String TABLE_NAME = "dane_table";
   // public static final String TABLE_NAME2 = "current_table";  //która była ostatnia gra z całej listy
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATA";
    public static final String COL_3 = "ILOSC";
    public static final String COL_4 = "RUNDA";
    public static final String COL_5 = "KOLEJ";
    public static final String COL_6 = "NAZWA_GRACZ1";
    public static final String COL_7 = "PUNKTY_GRACZ1";
    public static final String COL_8 = "NAZWA_GRACZ2";
    public static final String COL_9 = "PUNKTY_GRACZ2";
    public static final String COL_10 = "NAZWA_GRACZ3";
    public static final String COL_11 = "PUNKTY_GRACZ3";
    public static final String COL_12 = "NAZWA_GRACZ4";
    public static final String COL_13 = "PUNKTY_GRACZ4";
    public static final String COL_14 = "BOMBA_GRACZ1";
    public static final String COL_15 = "BOMBA_GRACZ2";
    public static final String COL_16 = "BOMBA_GRACZ3";
    public static final String COL_17 = "BOMBA_GRACZ4";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "   (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATA TEXT, ILOSC INTEGER, RUNDA INTEGER, KOLEJ TEXT, NAZWA_GRACZ1 TEKST, PUNKTY_GRACZ1 INTEGER, NAZWA_GRACZ2 TEXT, PUNKTY_GRACZ2 INTEGER, NAZWA_GRACZ3 TEXT, PUNKTY_GRACZ3 INTEGER, NAZWA_GRACZ4 TEXT, PUNKTY_GRACZ4 INTEGER, BOMBA_GRACZ1 INTEGER, BOMBA_GRACZ2 INTEGER, BOMBA_GRACZ3 INTEGER, BOMBA_GRACZ4 INTEGER)");
       // db.execSQL("create table " + TABLE_NAME2 + "   (ID INTEGER PRIMARY KEY AUTOINCREMENT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String data, int ilosc, int runda, String kolej, String nazwa_gracz1, int punkty_gracz1, String nazwa_gracz2, int punkty_gracz2, String nazwa_gracz3, int punkty_gracz3, String nazwa_gracz4, int punkty_gracz4, int bomba_gracz1, int bomba_gracz2, int bomba_gracz3, int bomba_gracz4){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, data);
        contentValues.put(COL_3, ilosc);
        contentValues.put(COL_4, runda);
        contentValues.put(COL_5, kolej);
        contentValues.put(COL_6, nazwa_gracz1);
        contentValues.put(COL_7, punkty_gracz1);
        contentValues.put(COL_8, nazwa_gracz2);
        contentValues.put(COL_9, punkty_gracz2);
        contentValues.put(COL_10, nazwa_gracz3);
        contentValues.put(COL_11, punkty_gracz3);
        contentValues.put(COL_12, nazwa_gracz4);
        contentValues.put(COL_13, punkty_gracz4);
        contentValues.put(COL_14, bomba_gracz1);
        contentValues.put(COL_15, bomba_gracz2);
        contentValues.put(COL_16, bomba_gracz3);
        contentValues.put(COL_17, bomba_gracz4);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    // SETTERY


    //GETTERY
}
