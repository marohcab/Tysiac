package com.example.bachor.tysiac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String GRACZE = "Gracze";
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
    public static final String CURRENT = "GRA";
    public static final String CURRENTID = "ID";

    /*




     */


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + TABLE_CURRENT + "  (ID INTEGER PRIMARY KEY, GRA INTEGER)");
        db.execSQL("create table if not exists " + TABLE_NAME + "  (ID INTEGER PRIMARY KEY, Gracze INTEGER, Data TEXT, Runda INTEGER, Zaczyna TEXT, Rozdaje TEXT, " +
                "Gracz1Nazwa TEXT, Gracz1Punkty INTEGER, Gracz1Bomba INTEGER, " +
                "Gracz2Nazwa TEXT, Gracz2Punkty INTEGER, Gracz2Bomba INTEGER, " +
                "Gracz3Nazwa TEXT, Gracz3Punkty INTEGER, Gracz3Bomba INTEGER, " +
                "Gracz4Nazwa TEXT, Gracz4Punkty INTEGER, Gracz4Bomba INTEGER, )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    //Dodawanie nowych danych (wierszy)
    public boolean insertData(int gracze, String data, int runda, String zaczyna, String rozdaje,
                              String gracz1nazwa, int gracz1punkty, int gracz1bomba,
                              String gracz2nazwa, int gracz2punkty, int gracz2bomba,
                              String gracz3nazwa, int gracz3punkty, int gracz3bomba,
                              String gracz4nazwa, int gracz4punkty, int gracz4bomba) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int id;
        Cursor getID;
        getID = db.rawQuery("select count(ID) from TABLE", null);
        id = getID.getInt(0) + 1;

        contentValues.put(ID, id);
        contentValues.put(GRACZE, gracze);
        contentValues.put(DATA, data);
        contentValues.put(RUNDA, runda);
        contentValues.put(ZACZYNA, zaczyna);
        contentValues.put(ROZDAJE, rozdaje);

        contentValues.put(GRACZ1_NAZWA, gracz1nazwa);
        contentValues.put(GRACZ1_PUNKTY, gracz1punkty);
        contentValues.put(GRACZ1_BOMBA, gracz1bomba);

        contentValues.put(GRACZ2_NAZWA, gracz2nazwa);
        contentValues.put(GRACZ2_PUNKTY, gracz2punkty);
        contentValues.put(GRACZ2_BOMBA, gracz2bomba);

        contentValues.put(GRACZ3_NAZWA, gracz3nazwa);
        contentValues.put(GRACZ3_PUNKTY, gracz3punkty);
        contentValues.put(GRACZ3_BOMBA, gracz3bomba);

        contentValues.put(GRACZ4_NAZWA, gracz4nazwa);
        contentValues.put(GRACZ4_PUNKTY, gracz4punkty);
        contentValues.put(GRACZ4_BOMBA, gracz4bomba);


        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //settery dla kazdej danej

    public void setRunda(){

    }

    public void setZaczyna(){

    }

    public void setRozdaje(){

    }

    public void setGracz1Punkty(){

    }

    public void setGracz1Bomba(boolean bomba){
        SQLiteDatabase db = this.getWritableDatabase();
        int bomba2;
        if(bomba==true){
            bomba2=1;
        }
        else{
            bomba2=0;
        }
        String id=String.valueOf(getCurrent());
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRACZ1_BOMBA, bomba2);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

    }

    public void setGracz2Punkty(){

    }

    public void setGracz2Bomba(boolean bomba){
        SQLiteDatabase db = this.getWritableDatabase();
        int bomba2;
        if(bomba==true){
            bomba2=1;
        }
        else{
            bomba2=0;
        }
        String id=String.valueOf(getCurrent());
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRACZ2_BOMBA, bomba2);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

    }

    public void setGracz3Punkty(){

    }

    public void setGracz3Bomba(boolean bomba){
        SQLiteDatabase db = this.getWritableDatabase();
        int bomba2;
        if(bomba==true){
            bomba2=1;
        }
        else{
            bomba2=0;
        }
        String id=String.valueOf(getCurrent());
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRACZ3_BOMBA, bomba2);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

    }

    public void setGracz4Punkty(){

    }

    public void setGracz4Bomba(boolean bomba){
        SQLiteDatabase db = this.getWritableDatabase();
        int bomba2;
            if(bomba==true){
                bomba2=1;
            }
            else{
              bomba2=0;
            }
        String id=String.valueOf(getCurrent());
        ContentValues contentValues = new ContentValues();
        contentValues.put(GRACZ4_BOMBA, bomba2);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

    }

    public void setCurrent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        //String id2 ="1";
        ContentValues contentValues = new ContentValues();
        contentValues.put(CURRENT, id);
        db.update(TABLE_CURRENT, contentValues, "ID = ?", new String[]{"1"});
    }

    //
    //
    //
    //gettery dla kazdej danej
    //
    //
    //

    public String getGracz1Nazwa(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + GRACZ1_NAZWA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public int getGracz1Punkty(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ1_PUNKTY + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        return get.getInt(0);
    }

    public boolean getGracz1Bomba(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ1_BOMBA + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        if(get.getInt(0)!=0)
            return false;
        else
            return true;
    }

    public String getGracz2Nazwa(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + GRACZ2_NAZWA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public int getGracz2Punkty(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ2_PUNKTY + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        return get.getInt(0);
    }

    public boolean getGracz2Bomba(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ1_BOMBA + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        if(get.getInt(0)!=0)
            return false;
        else
            return true;
    }

    public String getGracz3Nazwa(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + GRACZ3_NAZWA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public int getGracz3Punkty(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ3_PUNKTY + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        return get.getInt(0);
    }

    public boolean getGracz3Bomba(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ1_BOMBA + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        if(get.getInt(0)!=0)
            return false;
        else
            return true;
    }

    public String getGracz4Nazwa(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + GRACZ4_NAZWA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public int getGracz4Punkty(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ4_PUNKTY + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        return get.getInt(0);
    }

    public boolean getGracz4Bomba(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + GRACZ1_BOMBA + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        if(get.getInt(0)!=0)
            return false;
        else
            return true;
    }

    public int getRunda(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get = db.rawQuery("select " + RUNDA + " from " + TABLE_NAME + " where " + ID + "=" + id,null);
        get.moveToFirst();
        return get.getInt(0);
    }

    public String getZaczyna(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + ZACZYNA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public String getRozdaje(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + ROZDAJE + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public String getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getCurrent();
        Cursor get =  db.rawQuery("select " + DATA + " from " + TABLE_NAME + " where " + ID + "=" + id, null);
        get.moveToFirst();
        return get.toString();
    }

    public int getCurrent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor getID = db.rawQuery("select " + CURRENT + " from " + TABLE_CURRENT, null);
        return getID.getInt(0);
    }


    //usuwanie jednego wiersza

    //usuwanie całości


}
