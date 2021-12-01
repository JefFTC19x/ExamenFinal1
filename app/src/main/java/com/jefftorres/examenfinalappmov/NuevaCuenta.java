package com.jefftorres.examenfinalappmov;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jefftorres.examenfinalappmov.Entidades.Cuenta;
import com.jefftorres.examenfinalappmov.Servicios.ServiceCuenta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NuevaCuenta extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView FotoparamostrarB;
    private TextView base64;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_cuenta);

        Button agregar = findViewById(R.id.guardarCuenta);
        agregar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v2)
            {
                TextView imgbase64 =findViewById(R.id.base64);
                EditText nombre =findViewById(R.id.nombre);
                EditText monto =findViewById(R.id.monto);
                EditText fecha =findViewById(R.id.fecha);
                EditText sucursal_1 =findViewById(R.id.sucursal1);
                EditText sucursal_2 =findViewById(R.id.sucursal2);
                EditText sucursal_3 =findViewById(R.id.sucursal3);

                String vnombre = String.valueOf(nombre.getText());
                String vmonto = String.valueOf(monto.getText());
                String vfecha = String.valueOf(fecha.getText());
                String sucursal1 = String.valueOf(sucursal_1.getText());
                String sucursal2 = String.valueOf(sucursal_2.getText());
                String sucursal3 = String.valueOf(sucursal_3.getText());
                String imagen = String.valueOf(imgbase64.getText());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServiceCuenta servicio =retrofit.create(ServiceCuenta.class);
                Cuenta cuenta = new Cuenta();
                cuenta.setNombre(vnombre);
                cuenta.setMonto(vmonto);
                cuenta.setFecha(vfecha);
                cuenta.setSucursal1(sucursal1);
                cuenta.setSucursal2(sucursal2);
                cuenta.setSucursal3(sucursal3);
                cuenta.setImagen(imagen);



                servicio.create(cuenta).enqueue(new Callback<Cuenta>() {
                    @Override
                    public void onResponse(Call<Cuenta> call, Response<Cuenta> response) {
                        Log.i("MAIN_APP",new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Cuenta> call, Throwable t) {

                    }
                });
            }
        });

        base64 = findViewById(R.id.base64);

        FotoparamostrarB = findViewById(R.id.fotocuenta);
        Button tomarfotopoke = findViewById(R.id.BotFoto);
        tomarfotopoke.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v1) {
                if(NuevaCuenta.this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    NuevaCuenta.this.requestPermissions(new String[]{Manifest.permission.CAMERA},10001);
                }
                else{dispatchTakePictureIntent();}
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap2 = (Bitmap) extras.get("data");
            FotoparamostrarB.setImageBitmap(imageBitmap2);
            String base64String = ImageUtil.convert(imageBitmap2);
            base64.setText(base64String);
        }
    }

    //  static final int REQUEST_IMAGE_CAPTURE = 1;
    private void dispatchTakePictureIntent()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}