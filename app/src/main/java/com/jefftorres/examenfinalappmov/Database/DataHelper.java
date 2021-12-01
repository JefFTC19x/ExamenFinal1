package com.jefftorres.examenfinalappmov.Database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static  final  String DATABASE_NOMBRE = "agenda.db";
    public  static  final   String TABLE_CUENTAS ="t_cuentas";

    public DataHelper(@Nullable Context context)
    {
        super(context,DATABASE_NOMBRE,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_CUENTAS +"("+
                "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
