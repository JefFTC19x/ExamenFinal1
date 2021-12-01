package com.jefftorres.examenfinalappmov.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jefftorres.examenfinalappmov.Entidades.Cuenta;
import com.jefftorres.examenfinalappmov.Entidades.CuentaGet;
import com.jefftorres.examenfinalappmov.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CuentaAdapter extends RecyclerView.Adapter<CuentaAdapter.CuentaViewHolder>{

    private List<CuentaGet> data;
    String val;

    public CuentaAdapter(List<CuentaGet> data){
        this.data=data;
    }

    @Override
    public CuentaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_cuenta,parent,false);
        return new CuentaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CuentaViewHolder holder, int i) {
        CuentaGet cuenta = data.get(i);
        TextView vnombre = holder.itemView.findViewById(R.id.nombreit);
        TextView vmonto = holder.itemView.findViewById(R.id.montoit);
        TextView vfecha = holder.itemView.findViewById(R.id.fechait);
        TextView vsucursal1 = holder.itemView.findViewById(R.id.sucursal1it);
        TextView vsucursal2 = holder.itemView.findViewById(R.id.sucursal2it);
        TextView vsucursal3 = holder.itemView.findViewById(R.id.sucursal3it);
        ImageView baseImg64 = holder.itemView.findViewById(R.id.foto);

        TextView Link =holder.itemView.findViewById(R.id.link);

        vnombre.setText(cuenta.getNombre());
        vmonto.setText(cuenta.getMonto());
        vfecha.setText(cuenta.getFecha());
        vsucursal1.setText(cuenta.getSucursal1());
        vsucursal2.setText(cuenta.getSucursal2());
        vsucursal3.setText(cuenta.getSucursal3());
        val = cuenta.getImagen();

        String completo = "https://upn.lumenes.tk/n00194025/accounts" + val;
        Link.setText(completo);

        Picasso.get()
               .load(completo)
               .into(baseImg64);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class CuentaViewHolder extends RecyclerView.ViewHolder{

        public CuentaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
