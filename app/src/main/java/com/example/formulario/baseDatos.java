package com.example.formulario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class baseDatos<listEstudiantes> extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="bdproyecto.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ESTUDIANTES="create table estudiantes (codigo text primary key, nombre text, carrera text)";


    public baseDatos(Context context) {
        super(context,NOMBRE_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ESTUDIANTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS estudiantes");
        db.execSQL(TABLA_ESTUDIANTES);
        onCreate(db);
    }

    public void agregarEstudiantes(String codigo,String nombre,String carrera){
        SQLiteDatabase db=getReadableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO estudiantes Values('"+codigo+"','"+nombre+"','"+carrera+"')");
            db.close();
        }
    }

    public List<estudianteModelo> mostrarEstudiantes(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM estudiantes",null);
        List<estudianteModelo> listEstudiantes= new ArrayList<>();
            do{
                listEstudiantes.add(new estudianteModelo(cursor.getString(Integer.parseInt(cursor.getString(2)))));
            }while (cursor.moveToNext());
        return listEstudiantes;
    }

    public estudianteModelo buscarEstudiantes(estudianteModelo listEstudiantes, String codigo){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM ESTUDIANTES WHERE CODIGO='"+codigo+"'",null);
        if(cursor.moveToFirst()){
            do {
                listEstudiantes.setCarrera(cursor.getString(1));
                listEstudiantes.SetNombre(cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return listEstudiantes;
    }

}
