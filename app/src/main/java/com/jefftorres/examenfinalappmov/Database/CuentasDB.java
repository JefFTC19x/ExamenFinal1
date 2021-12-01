package com.jefftorres.examenfinalappmov.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.RestrictionEntry;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class CuentasDB extends DataHelper
{Context context;
    public CuentasDB(@Nullable Context context)
    {
        super(context);
        this.context = context;
    }
    public long Insertar(String nombre,String monto,String fecha, String sucursal1,String sucursal2,String sucursal3,String imagen)
    {
        long id=0;
        try {
            DataHelper dataHelper = new DataHelper(context);
            SQLiteDatabase db = dataHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("monto", monto);
            values.put("fecha", fecha);
            values.put("sucursal1", sucursal1);
            values.put("sucursal2", sucursal2);
            values.put("sucursal3", sucursal3);
            values.put("imagen", imagen);
            id = db.insert(TABLE_CUENTAS, null, values);
        }catch (Exception ex )
        {
            ex.toString();
        }
        return id;
    }
}
