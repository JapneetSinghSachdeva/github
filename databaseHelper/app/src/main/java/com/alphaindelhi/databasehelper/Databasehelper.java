package com.alphaindelhi.databasehelper;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "Mystudent.db";
    public final static String TABLE_NAME = "mystudent_table";
    public final static String COL_1 = "ID";
    public final static String COL_2 = "NAME";
    public final static String COL_3 = "EMAIL";
    public final static String COL_4 = "COURSE_COUNT";


    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT ," +
                " EMAIL TEXT ," +
                " COURSE_COUNT INTEGER) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);



    }

    public boolean insertData(String name , String email, String courseCount)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2 , name);
        contentValues.put(COL_3 , email);
        contentValues.put(COL_4 , courseCount);

        long result = sdb.insert(TABLE_NAME , null , contentValues);

        if(result==-1)
        {
            return false;
        } else

        {return true;}


    }

    public boolean updateData (String id, String name, String email, String courseCount)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1 , id);
        contentValues.put(COL_2 , name);
        contentValues.put(COL_3 , email);
        contentValues.put(COL_4 , courseCount);

        sdb.update(TABLE_NAME,contentValues, "ID=?" , new String[]{id});
        return true;
    }

    public Cursor getData(String id)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();
        String query  = "SELECT * FROM "+TABLE_NAME+" WHERE ID='"+id+"'" ;

        Cursor cursor = sdb.rawQuery(query , null);
        return cursor;


    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();

                return sdb.delete(TABLE_NAME, "ID=?", new String[]{id});
    }

    public Cursor getAllData(){

        SQLiteDatabase sdb = this.getWritableDatabase();

    Cursor cursor = sdb.rawQuery("SELECT * FROM "+TABLE_NAME, null) ;
    return cursor;

    }










}














