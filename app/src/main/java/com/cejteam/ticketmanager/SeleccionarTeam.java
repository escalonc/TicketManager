package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SeleccionarTeam extends AppCompatActivity {
    Button team1,team2;
    ArrayList<String> teams1 = new ArrayList<>();
    ArrayList<String> teams2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_team);
        teams1 = (ArrayList<String>) getIntent().getSerializableExtra("teams1");
        teams2 = (ArrayList<String>) getIntent().getSerializableExtra("teams2");


        team1 = (Button) findViewById(R.id.team1team1);
        team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(SeleccionarTeam.this , ListaJugadoresPorEquipo.class);
                intenst.putExtra("teams1",teams1);
                startActivity(intenst);

            }
        });

        team2 = (Button) findViewById(R.id.team2team2);
        team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(SeleccionarTeam.this , ListaJugadoresPorEquipo.class);
                intenst.putExtra("teams1",teams2);
                startActivity(intenst);

            }
        });
    }
}
