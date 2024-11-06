package com.example.appdeportistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JugadoresAdapter jugadoresAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        jugadoresAdapter = new JugadoresAdapter(this, obtenerJugadoresDesdeDB());
        recyclerView.setAdapter(jugadoresAdapter);
    }

    private ArrayList<Jugador> obtenerJugadoresDesdeDB() {
        DBJugadores dbJugadores = new DBJugadores(this);
        return dbJugadores.mostrarJugadores();
    }
}