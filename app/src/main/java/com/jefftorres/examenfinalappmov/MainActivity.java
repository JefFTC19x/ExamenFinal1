package com.jefftorres.examenfinalappmov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jefftorres.examenfinalappmov.Adapter.CuentaAdapter;
import com.jefftorres.examenfinalappmov.Entidades.Cuenta;
import com.jefftorres.examenfinalappmov.Entidades.CuentaGet;
import com.jefftorres.examenfinalappmov.Servicios.ServiceCuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nuevaCuenta =findViewById(R.id.Registrar);
        nuevaCuenta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent registro = new Intent(getApplicationContext(), NuevaCuenta.class );
                startActivity(registro);
            }
        } );

        Button Sincronizar =findViewById(R.id.Sincronizar);
        Sincronizar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RecyclerView rv = findViewById(R.id.Lista);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServiceCuenta service =retrofit.create(ServiceCuenta.class);

                service.allRepos().enqueue(new Callback<List<CuentaGet>>() {
                    @Override
                    public void onResponse(Call<List<CuentaGet>> call, Response<List<CuentaGet>> response)
                    {

                        if(response.code() == 200)
                        {
                            CuentaAdapter adapter = new CuentaAdapter(response.body());
                            rv.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CuentaGet>> call, Throwable t)
                    {
                        Log.i("Main_App","Fallo de conexión" );
                    }
                });
            }
        } );


    }




}