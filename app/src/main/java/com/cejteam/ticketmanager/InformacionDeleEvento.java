package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InformacionDeleEvento extends AppCompatActivity {
    int codigo=0;
    TextView fecha,codigocam,titulo,descripcion,acercade,monto;
    Button regresar,listado,menu;
    ImageView eventotipo;
    AlmacenEventos almacenEventos=new AlmacenEventos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_dele_evento);

        menu=(Button)findViewById(R.id.menu34343);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(InformacionDeleEvento.this,MainActivity.class);
                startActivity(intenst);
            }
        });
        codigo = getIntent().getExtras().getInt("codigoenviado");
        fecha=(TextView)findViewById(R.id.mostrarfecha);
        codigocam=(TextView)findViewById(R.id.mostrarcodigo);
        titulo=(TextView)findViewById(R.id.mostrartitulo);
        descripcion=(TextView)findViewById(R.id.mostrardescripcion);
        monto=(TextView)findViewById(R.id.mostrarmonto);
        regresar=(Button)findViewById(R.id.mostrarregresar);
        eventotipo=(ImageView) findViewById(R.id.mostrarimagen);

        RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(codigo);
        RegistrarEventoReligioso registrarEventoReligioso = almacenEventos.buscareventoreligioso(codigo);
        RegistrarEventoMusical registrarEventoMusical = almacenEventos.buscareventomusical(codigo);

        if(registrarEventoDeportivo!=null){
            fecha.setText(registrarEventoDeportivo.getDate().toString());
            codigocam.setText(String.valueOf( registrarEventoDeportivo.getEvent()));
            titulo.setText(String.valueOf( registrarEventoDeportivo.getTittle()));
            descripcion.setText(String.valueOf( registrarEventoDeportivo.getDescription()));
             monto.setText(String.valueOf( registrarEventoDeportivo.getAmount()));
            eventotipo.setImageResource(R.drawable.deportivo);



        }else if(registrarEventoReligioso!=null){
            fecha.setText(registrarEventoReligioso.getDate().toString());
            codigocam.setText(String.valueOf( registrarEventoReligioso.getEvent()));
            titulo.setText(String.valueOf( registrarEventoReligioso.getTittle()));
            descripcion.setText(String.valueOf( registrarEventoReligioso.getDescription()));
           monto.setText(String.valueOf( registrarEventoReligioso.getAmount()));
            eventotipo.setImageResource(R.drawable.religiosoi);


        }else if(registrarEventoMusical!=null){
            fecha.setText(registrarEventoMusical.getDate().toString());
            codigocam.setText(String.valueOf( registrarEventoMusical.getEvent()));
            titulo.setText(String.valueOf( registrarEventoMusical.getTittle()));
            descripcion.setText(String.valueOf( registrarEventoMusical.getDescription()));
            monto.setText(String.valueOf( registrarEventoMusical.getAmount()));
            eventotipo.setImageResource(R.drawable.musicali);
        }

        listado=(Button)findViewById(R.id.listado);
        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarEventoDeportivo registrarEventoDeportivos = almacenEventos.buscarEventodeportivo(codigo);
                RegistrarEventoReligioso registrarEventoReligiosos = almacenEventos.buscareventoreligioso(codigo);
                RegistrarEventoMusical registrarEventoMusicals = almacenEventos.buscareventomusical(codigo);

                if(registrarEventoDeportivos!=null){

                    ArrayList<String> array= registrarEventoDeportivos.getTeams1();
                    ArrayList<String> array2= registrarEventoDeportivos.getTeams2();
                    Intent intenst = new Intent(InformacionDeleEvento.this , SeleccionarTeam.class);
                    intenst.putExtra("teams1",array);
                    intenst.putExtra("teams2",array2);
                    startActivity(intenst);
                    finish();
                }else if(registrarEventoMusicals!=null){
                    ArrayList<String> array2= registrarEventoMusicals.getPeopleOfSupport();
                    Intent intenst = new Intent(InformacionDeleEvento.this , ListaJugadoresPorEquipo.class);
                    intenst.putExtra("teams1",array2);
                    startActivity(intenst);
                }else if(registrarEventoReligiosos!=null){
                    Toast msg = Toast.makeText(InformacionDeleEvento.this, "No contiene lista", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(InformacionDeleEvento.this,MenuEvents.class);
                startActivity(intents);
                finish();
            }
        });



    }
}
