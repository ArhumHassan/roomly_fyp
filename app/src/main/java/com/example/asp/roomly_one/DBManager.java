package com.example.asp.roomly_one;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    private final static String dbname="HM.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "tbl_hmusers";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_BPL = "bpl";
    private static final String KEY_BPH = "bph";
    private static final String KEY_SUGAR = "suger";
    private static final String KEY_CAL = "calorie";


    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String tbl_hmusers;
//        String CREATE_TABLE = " CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_PASS + " TEXT " + ")";
//        String CREATE_TABLE = " CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_PASS + " TEXT, " + KEY_HEIGHT + " FLOAT, " + KEY_WEIGHT + " FLOAT, " + KEY_BPL + " FLOAT, " + KEY_BPH + " FLOAT, " + KEY_SUGAR + " FLOAT, " + KEY_CAL + " FLOAT " + ")";
//        db.execSQL(CREATE_TABLE);
//        String DATABASE_TABLE = "tbl_users";
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_hmusers (name VARCHAR,email VARCHAR,password VARCHAR,height text,weight text,bpl text,bph text,sugar text,calore text)");

//         db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+ id + " integer primary key," + name + "text not null, email text not null, password text not null, age text not null, height text not null, weight text not null, bpl text not null, bph text not null, sugar text not null, calorie text not null");");
/*        db.execSQL(DATABASE_CREATE);
          String query="create table tbl_users(id integer primary key autoincrement,name text,email text,password text,age text,height text,weight text,bpl text,bph text,sugar text,calorie text)";
        String query2="create table tbl_health(id integer primary key autoincrement,age text,height text,weight text,bpl text,bph text,sugar text,calorie text)";
        db.execSQL(query2); */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE TABLE_USERS");
        onCreate(db);
    }
    public int addRecords(String name, String email, String password,String age, String height, String weight, String bpl, String bph, String sugar, String calorie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("age",age);
        contentValues.put("height",height);
        contentValues.put("weight",weight);
        contentValues.put("bpl",bpl);
        contentValues.put("bph",bph);
        contentValues.put("sugar",sugar);
        contentValues.put("calorie",calorie);
//        long res=db.insert(TABLE_USERS,null,contentValues);
        long asd;
        asd = db.insert(TABLE_USERS,null,contentValues);
        if(asd>0)
        {
            return 0;
        }
        else
        {
            return 1;
        }

    }

/*    public int addHealth(String xage, String xheight, String xweight, String xbpl, String xbph, String xsugar, String xcalorie) {
        SQLiteDatabase db=this.getWritableDatabase();
        double age= Double.parseDouble(xage);
        double height= Double.parseDouble(xheight);
        double weight= Double.parseDouble(xweight);
        double bpl= Double.parseDouble(xbpl);
        double bph= Double.parseDouble(xbph);
        double sugar= Double.parseDouble(xsugar);
        double calorie= Double.parseDouble(xcalorie);
        ContentValues Values=new ContentValues();
        Values.put("age",age);
        Values.put("height",height);
        Values.put("weight",weight);
        Values.put("bpl",bpl);
        Values.put("bph",bph);
        Values.put("sugar",sugar);
        Values.put("calorie",calorie);
        long hel=db.insert("tbl_health",null,Values);
        if(hel==1)
        {
            return 0;
        }
        else
        {
            return 1;
        }


    }

 */
}
