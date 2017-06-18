package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformacionDeleEvento extends AppCompatActivity {
    int codigo=0;
    TextView fecha,codigocam,titulo,descripcion,acercade,monto;
    Button regresar;
    ImageView eventotipo;
    AlmacenEventos almacenEventos=new AlmacenEventos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_dele_evento);
        codigo = getIntent().getExtras().getInt("codigoenviado");
        fecha=(TextView)findViewById(R.id.mostrarfecha);
        codigocam=(TextView)findViewById(R.id.mostrarcodigo);
        titulo=(TextView)findViewById(R.id.mostrartitulo);
        descripcion=(TextView)findViewById(R.id.mostrardescripcion);
        acercade=(TextView)findViewById(R.id.mostraramount);
        monto=(TextView)findViewById(R.id.mostrarmonto);
        regresar=(Button)findViewById(R.id.mostrarregresar);
        eventotipo=(ImageView) findViewById(R.id.mostrarimagen);
        RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEvento(codigo);

        fecha.setText(registrarEventoDeportivo.getDate().toString());
        codigocam.setText(String.valueOf( registrarEventoDeportivo.getEvent()));
        titulo.setText(String.valueOf( registrarEventoDeportivo.getTittle()));
        descripcion.setText(String.valueOf( registrarEventoDeportivo.getDescription()));
        acercade.setText(String.valueOf( registrarEventoDeportivo.getAmount()));
        monto.setText(String.valueOf( registrarEventoDeportivo.getAmount()));

        if(registrarEventoDeportivo.getType().equals("Deportivo")){
            eventotipo.setImageResource(R.drawable.deportivo);
        }else if(registrarEventoDeportivo.getType().equals("Musical")){
            eventotipo.setImageResource(R.drawable.musicali);
        }else if(registrarEventoDeportivo.getType().equals("Religioso")){
            eventotipo.setImageResource(R.drawable.religiosoi);
        }
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
