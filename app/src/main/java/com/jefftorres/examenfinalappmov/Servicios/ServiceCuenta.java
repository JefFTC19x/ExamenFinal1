package com.jefftorres.examenfinalappmov.Servicios;

import com.jefftorres.examenfinalappmov.Entidades.Cuenta;
import com.jefftorres.examenfinalappmov.Entidades.CuentaGet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceCuenta
{
    @GET("n00194025/accounts/")
    Call<List<CuentaGet>> allRepos();

    @POST("n00194025/accounts/")
    Call<Cuenta> create(@Body Cuenta acount);
}
