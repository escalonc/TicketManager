package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaJugadoresPorEquipo extends AppCompatActivity {

    Button menu;

        ListView listajugadores;
        ArrayList<String> teams1 = new ArrayList<>();
        ArrayList<String> teams2 = new ArrayList<>();
        ArrayList<String> all = new ArrayList<>();







        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores_por_equipo);


            menu=(Button)findViewById(R.id.menu900);
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intenst = new Intent(ListaJugadoresPorEquipo.this,MenuEvents.class);
                    startActivity(intenst);
                }
            });







        try {
            listajugadores = (ListView) findViewById(R.id.ListadeEquipos);

            teams1 = (ArrayList<String>) getIntent().getSerializableExtra("teams1");
            teams2 = (ArrayList<String>) getIntent().getSerializableExtra("teams2");

            add();
            ArrayAdapter adaptador2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, all);
            listajugadores.setAdapter(adaptador2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void add() {
        for (String j : teams1) {
            all.add(j);
        }
        for (String j : teams2) {
            all.add(j);
        }
    }

}