package com.example.appdeportistas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class JugadoresAdapter extends RecyclerView.Adapter<JugadoresAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Jugador> listaJugadores;

    public JugadoresAdapter(MainActivity mainActivity, ArrayList<Jugador> obtenerJugadoresDesdeDB) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

   static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtClub;
        ImageView imgFoto;
        ImageButton btnEditar;
        ImageButton btnEliminar;

        ViewHolder(View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtClub = itemView.findViewById(R.id.txtClub);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}