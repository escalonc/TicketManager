package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaJugadoresPorEquipo extends AppCompatActivity {

        ListView listajugadores;
        ArrayList<String> teams1 = new ArrayList<>();


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores_por_equipo);
        try {
            listajugadores = (ListView) findViewById(R.id.ListadeEquipos);
            teams1 = (ArrayList<String>) getIntent().getSerializableExtra("teams1");
            ArrayAdapter adaptador2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, teams1);
            listajugadores.setAdapter(adaptador2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}