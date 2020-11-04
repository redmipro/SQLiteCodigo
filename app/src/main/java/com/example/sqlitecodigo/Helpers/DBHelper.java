package com.example.sqlitecodigo.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlitecodigo.SQLConstants;

public class DBHelper extends SQLiteOpenHelper {
    public  static final int SQL_DB_V = 1;

    public DBHelper(Context context){
        super(context, SQLConstants.DB,null,SQL_DB_V);//
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //crear base de datos
        sqLiteDatabase.execSQL(SQLConstants.SQL_CREATE_TABLE_USUARIOS);//Crear tabla

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLConstants.SQL_DELETE);//Eliminar tabla anterior e insertar la nueva
        onCreate(sqLiteDatabase);
    }
}
