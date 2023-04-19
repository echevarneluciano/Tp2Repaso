package com.example.tp2repaso.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2repaso.R;
import com.example.tp2repaso.modelo.Actividad;

import java.util.List;

public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ViewHolder> {
    private Context context;
    private List<Actividad> actividades;
    private LayoutInflater layoutInflater;

    public ActividadAdapter(Context context, List<Actividad> actividades, LayoutInflater layoutInflater) {
        this.context = context;
        this.actividades = actividades;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=layoutInflater.inflate(R.layout.actividad,parent,false);
        return new  ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(actividades.get(position).getNombre()+"");
        holder.fecha.setText(actividades.get(position).getFecha()+"");
        holder.hora.setText(actividades.get(position).getHora()+"");
       /* Glide.with(context)
                .load(productos.get(position).getUrlFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoProducto); */
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,fecha,hora;
        Button btnDetalle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.tvNombre);
            fecha=itemView.findViewById(R.id.tvFecha);
            hora=itemView.findViewById(R.id.tvHora);
            btnDetalle=itemView.findViewById(R.id.btnDetalle);

            btnDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(v.getContext(), DescripcionViewModel.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("actividades", actividades.get(getAdapterPosition()));

                    //intent.putExtras(bundle);

                    //v.getContext().startActivity(intent);
                    Navigation.findNavController( (Activity)context,R.id.nav_host_fragment_content_main_activity_menu).navigate(R.id.action_nav_gallery_to_descripcion,bundle);
                }
            });
        }
    }


}
