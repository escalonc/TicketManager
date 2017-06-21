package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaJugadoresPorEquipo extends AppCompatActivity {
    ListView listajugadores;
     ArrayList<String> teams1 = new ArrayList<>();
     ArrayList<String> teams2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores_por_equipo);

        teams1 = (ArrayList<String>) getIntent().getExtras().get("teams1");
        teams2 = (ArrayList<String>) getIntent().getExtras().get("teams2");
        ArrayAdapter adaptador2= new ArrayAdapter(this, android.R.layout.simple_list_item_1, teams1);
        listajugadores.setAdapter( adaptador2 );
    }
}
