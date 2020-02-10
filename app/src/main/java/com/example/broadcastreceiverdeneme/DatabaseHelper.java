package com.example.broadcastreceiverdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.tech.NfcA;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Deneme.db";
    public static final String TABLE_NAME = "deneme_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate(db);

    }


    public boolean insertData(String name,int counter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name+ " " +counter);
        Log.d("DATABASE",name + counter + "kaydedildi !");
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else
            return true;
    }

}
