package com.example.servicio_limpieza;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private List<Propiedad> propiedades;

    public PropertyAdapter(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_item, parent, false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        Propiedad propiedad = propiedades.get(position);
        holder.propertyName.setText(propiedad.getNombre());
        holder.propertyAddress.setText(propiedad.getDireccion());
        holder.propertyState.setText(propiedad.getEstado());

        holder.btnReservarLimpieza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Utiliza el contexto del itemView para iniciar la actividad
                Intent intent = new Intent(v.getContext(), ReservarLimpiezaActivity.class);
                intent.putExtra("propiedad_id", propiedad.getIdPropiedad());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return propiedades.size();
    }

    public static class PropertyViewHolder extends RecyclerView.ViewHolder {

        public TextView propertyName;
        public TextView propertyAddress;
        public TextView propertyState;
        public Button btnReservarLimpieza;

        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            propertyName = itemView.findViewById(R.id.tv_property_name);
            propertyAddress = itemView.findViewById(R.id.property_address);
            propertyState = itemView.findViewById(R.id.property_state);
            btnReservarLimpieza = itemView.findViewById(R.id.btn_reservar_limpieza);
        }
    }
}
