package com.example.sqlitecodigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlitecodigo.Helpers.DBHelper;
import com.example.sqlitecodigo.POJOs.Usuario;

public class Data {
    //maneja todos los datos que se manipulan en la app entrada-salida
    private Context context;
    private SQLiteDatabase sqLiteDatabase;// ejecutar instruccions abrir BD, cerrar BD,  insertar dato
    private SQLiteOpenHelper sqLiteOpenHelper;

    //constructor
    public Data(Context context) {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context); //dbhelper herencia de sqliteopenhelper
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();//obtener base de datos en modo escritura y lectura
    }

    public void open() { //abrir BD
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() { //cerrar BD
        sqLiteOpenHelper.close();
    }

    public void insertUsuario(Usuario usuario) {
        ContentValues contentValues = usuario.contentValues();
        sqLiteDatabase.insert(SQLConstants.tableUsuarios, null, contentValues);
    }

    public Usuario readUsuario(String id) {
        Usuario usuario = new Usuario();
        String[] whereArgs = new String[]{id};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.tableUsuarios, SQLConstants.ALL_COLUMNS, SQLConstants.SQL_READ_BY_ID, whereArgs, null, null, null);
        //recorrer uno o+ resultados
        //while (cursor.moveToNext()) {
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            usuario.setEdad(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_EDAD)));
            usuario.setCorreo(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CORREO)));
        }
        return usuario;
    }

    public void deleteUser(String id){
        String  [] whereArgs = new String [] {String.valueOf(id)};
        sqLiteDatabase.delete(SQLConstants.tableUsuarios, SQLConstants.WHEREID_CLAUSE, whereArgs);
    }

    public void updateUser(String id, ContentValues contentValues){
        String [] whereArgs = new String []{String.valueOf(id)};
        sqLiteDatabase.update(SQLConstants.tableUsuarios, contentValues, SQLConstants.WHEREID_CLAUSE, whereArgs);
    }

}
