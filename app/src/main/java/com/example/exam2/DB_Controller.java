package com.example.exam2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                         int version) {
        super(context, "book.db", factory, version);
    }
    // this code create table name
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Book(BID VARCHAR PRIMARY KEY, BName VARCHAR, BPrice VARCHAR, BUnit VARCHAR);");
    }

    // this code for check table if have table same name will drop it
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists Book");
        onCreate(db);
    }

    // this code for insert data for database
    public void insert_product(String BID, String BName, String BPrice, String BUnit){
        ContentValues contentValues = new ContentValues();
        contentValues.put("BID", BID);
        contentValues.put("BName", BName);
        contentValues.put("BPrice", BPrice);
        contentValues.put("BUnit", BUnit);
        this.getWritableDatabase().insertOrThrow("Book", "",contentValues);
    }

    // this code for update data
    public void update_product(String BID, String BName, String BPrice, String BUnit){
        this.getWritableDatabase().execSQL("UPDATE Book set BName ='"+BName+"',BPrice='"+BPrice+"',BUnit='"+BUnit+"' where BID='"+BID+"'");
    }

    // this code for delete data
    public void delete_product(String BID){
        this.getWritableDatabase().delete("Book", "BID ='"+BID+"'",null);
    }

    // this code for Display datas
    public void list_product(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM Book", null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(0)+""+cursor.getString(1)+cursor.getString(2)+cursor.getString(3)+"\n");
        }
    }
}
