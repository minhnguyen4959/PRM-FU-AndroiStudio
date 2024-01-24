package com.example.fptu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fptu.bean.UserInfo;

public class DatabaseHandler extends SQLiteOpenHelper {
    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "UserData";
    private final static String USER_TABLE = "USER_TABLE";
    private final static String USERNAME = "USERNAME";
    private final static String PASSWORD = "PASSWORD";
    private final static String ROLE = "ROLE";
    private final static String CAMPUS = "CAMPUS";
    private final static String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "+ USER_TABLE + "("+
            USERNAME + " TEXT NOT NULL PRIMARY KEY, " + PASSWORD + " TEXT,"
            + ROLE + " TEXT," + CAMPUS + " TEXT)";

    private SQLiteDatabase db;
    public DatabaseHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(db.isOpen()){
            db.execSQL(CREATE_USER_TABLE);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(db.isOpen()){
            db.execSQL("DROP TABLE "+ USER_TABLE);
            db.execSQL(CREATE_USER_TABLE);
        }
    }

    public boolean insertUser(String username, String password, String role, String campus){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("USER_NAME", username);
        values.put("PASSWORD", password);
        values.put("ROLE", role);
        values.put("CAMPUS", campus);
        long row = db.insert(USER_TABLE, null, values);
//        Log.d("testinsert", );
        return row > 0;
    }

    public UserInfo getUser(String username) {
        UserInfo userInfo = null;
        String sql = "SELECT * FROM "+ USER_TABLE + " WHERE " + USERNAME + "=?";
        Cursor cursor = db.rawQuery(sql, new String[]{username});
        if (cursor.moveToNext()){
            userInfo = new UserInfo();
            int index = cursor.getColumnIndex(PASSWORD);
            userInfo.setPassword(cursor.getString(index));
            index = cursor.getColumnIndex(ROLE);
            userInfo.setRole(cursor.getString(index));
            index = cursor.getColumnIndex(CAMPUS);
            userInfo.setCampus(cursor.getString(index));
            userInfo.setUsername(username);

            cursor.moveToNext();
        }
        return  userInfo;
    }
}
