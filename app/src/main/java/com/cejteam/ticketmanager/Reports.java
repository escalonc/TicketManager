package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reports extends AppCompatActivity {
    Button pasado,futuro,more;
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
                finish();
            }
        });
        futuro = (Button)findViewById(R.id.futuros);
        futuro.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intenst = new Intent(Reports.this,EventosFuturosActivity.class);
                    startActivity(intenst);
                    finish();
            }
        });

        more = (Button)findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(Reports.this,FechaInicial.class);
                startActivity(intenst);
                finish();
            }
        });
    }
}
