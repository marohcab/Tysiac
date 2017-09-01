package com.example.bachor.tysiac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bachor on 2017-09-01.
 */

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Data.db";

    /*

        WSZYSTKIE DANE W GRZE

     */

    public static final String TABLE_NAME = "GameData";
    public static final String ID = "ID";
    public static final String ILOSC = "Gracze";
    public static final String DATA = "Data";
    public static final String RUNDA = "Runda";
    public static final String ZACZYNA = "Zaczyna";
    public static final String ROZDAJE = "Rozdaje";

    public static final String GRACZ1_NAZWA = "Gracz1Nazwa";
    public static final String GRACZ1_PUNKTY = "Gracz1Punkty";
    public static final String GRACZ1_BOMBA = "Gracz1Bomba";

    public static final String GRACZ2_NAZWA = "Gracz2Nazwa";
    public static final String GRACZ2_PUNKTY = "Gracz2Punkty";
    public static final String GRACZ2_BOMBA = "Gracz2Bomba";

    public static final String GRACZ3_NAZWA = "Gracz3Nazwa";
    public static final String GRACZ3_PUNKTY = "Gracz3Punkty";
    public static final String GRACZ3_BOMBA = "Gracz3Bomba";

    public static final String GRACZ4_NAZWA = "Gracz4Nazwa";
    public static final String GRACZ4_PUNKTY = "Gracz4Punkty";
    public static final String GRACZ4_BOMBA = "Gracz4Bomba";

    /*

        OBECNA GRA

     */

    public static final String TABLE_CURRENT = "Current";
    public static final String CURRENT = "ID";

    /*




     */


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CURRENT + "  (ID)");
        db.execSQL("create table " + TABLE_NAME + "  (ID INTEGER PRIMARY KEY, Gracze INTEGER, Data TEXT, Runda INTEGER, Zaczyna TEXT, Rozdaje TEXT, Gracz1Nazwa TEXT, Gracz1Punkty INTEGER, Gracz1Bomba INTEGER, Gracz2Nazwa TEXT, Gracz2Punkty INTEGER, Gracz2Bomba INTEGER, Gracz3Nazwa TEXT, Gracz3Punkty INTEGER, Gracz3Bomba INTEGER, Gracz4Nazwa TEXT, Gracz4Punkty INTEGER, Gracz4Bomba INTEGER, )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}
