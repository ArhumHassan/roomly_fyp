package com.example.asp.roomly_one;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "databasehm.db";
    public static final String TBL_Name = "hm_users_tbl.db";
    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASS = "password";
    public static final String AGE = "age";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String BPL = "bpl";
    public static final String BPH = "bph";
    public static final String SUGAR = "sugar";
    public static final String CALORIE = "calorie";

    public DBHelper(Context context) {
        super(context, DB_Name, null, 1);
//        SQLiteDatabase dp = this.getWritableDatabase();
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table " + TBL_Name + " (ID INTEGER PRIMARY KEY, NAME TEXT, EMAIL TEXT, PASS TEXT, AGE TEXT, HEIGHT TEXT, WEIGHT TEXT, BPL TEXT, BPH TEXT, SUGAR TEXT, CALORIE TEXT )");
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBL_Name);
        onCreate(db);
    }

    public void addData(String name, String email, String pass, String age, String height, String weight, String bpl, String bph, String sugar, String calorie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(EMAIL,email);
        values.put(PASS,pass);
        values.put(AGE,age);
        values.put(HEIGHT,height);
        values.put(WEIGHT,weight);
        values.put(BPL,bpl);
        values.put(BPH,bph);
        values.put(SUGAR,sugar);
        values.put(CALORIE,calorie);
/*        long ret = db.insert(TBL_Name,null,values);
        if (ret == -1){
            return false;
        }
        else
        {
            return true;
        }

 */
    }

}
