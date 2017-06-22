package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reports extends AppCompatActivity {
    Button pasado,futuro,cancelado,more,perfil,menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        pasado = (Button)findViewById(R.id.realizados);
        pasado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(Reports.this,EventosRealizadosActivity.class);
                startActivity(intenst);
            }
        });
        futuro = (Button)findViewById(R.id.futuros);
        futuro.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intenst = new Intent(Reports.this,EventosFuturosActivity.class);
                    startActivity(intenst);
            }
        });

        more = (Button)findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(Reports.this,FechaInicial.class);
                startActivity(intenst);
            }
        });

        menu = (Button) findViewById(R.id.principalMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(Reports.this,MainActivity.class);
                startActivity(intenst);
            }
        });

        cancelado=(Button)findViewById(R.id.cancel);
        cancelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(Reports.this,EventosCancelados.class);
                startActivity(intenst);
            }
        });
    }
}
