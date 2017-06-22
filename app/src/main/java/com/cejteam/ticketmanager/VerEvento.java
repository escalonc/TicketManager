package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerEvento extends AppCompatActivity {
    Button verevento, menu;
    EditText codigoevento;
    AlmacenEventos almacenEventos= new AlmacenEventos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_evento);
        verevento = (Button) findViewById(R.id.vereventocodigos);
        codigoevento = (EditText) findViewById(R.id.codigodeleventover);
        verevento.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codigoEventoEspecifico = codigoevento.length() > 0?Integer.parseInt(codigoevento.getText().toString()):-1;
                    if(almacenEventos.verificarexistencia(codigoEventoEspecifico)){
                        Intent intent = new Intent(VerEvento.this, InformacionDeleEvento.class);
                        intent.putExtra("codigoenviado",codigoEventoEspecifico);
                        startActivity(intent);
                        finish();
                    }

            }
        });

        menu=(Button)findViewById(R.id.menu1);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(VerEvento.this,MenuEvents.class);
                startActivity(intenst);
            }
        });
    }
}
