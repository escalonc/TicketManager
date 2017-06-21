package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipoDeEventoEditar extends AppCompatActivity implements View.OnClickListener{
    Button editar;
    EditText codigo;
    int nuevo=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_evento_editar);
        editar = (Button)findViewById(R.id.botoneditar);
        editar.setOnClickListener(this);
        codigo = (EditText)findViewById(R.id.codigoeditar);
        codigo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            AlmacenEventos almacenEventos= new AlmacenEventos();
            int seleccion = v.getId();
            switch (seleccion) {
                case R.id.botoneditar:
                    if(TextUtils.isEmpty(codigo.getText().toString())){
                        Toast msg = Toast.makeText(this, "Fill the field code please", Toast.LENGTH_SHORT);
                        msg.show();
                    } else if(!TextUtils.isEmpty(codigo.getText().toString())){
                        int code= Integer.parseInt(codigo.getText().toString());
                         if(almacenEventos.verificarexistencia(code)){
                             RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(code);
                             RegistrarEventoReligioso registrarEventoReligioso = almacenEventos.buscareventoreligioso(code);
                             RegistrarEventoMusical registrarEventoMusical = almacenEventos.buscareventomusical(code);

                             if (registrarEventoDeportivo!=null ){
                                 Intent intenst = new Intent(this,CrearEventoDeportivo.class);
                                 intenst.putExtra("enviarcodigo",  Integer.parseInt(codigo.getText().toString()));
                                 intenst.putExtra("nuevo",nuevo);
                                 startActivity(intenst);
                                 finish();
                                 break;
                             } else if(registrarEventoMusical!=null ){
                                 Intent intent = new Intent(this,CrearEventoMusical.class);
                                 intent.putExtra("enviarcodigo",  Integer.parseInt(codigo.getText().toString()));
                                 intent.putExtra("nuevo",nuevo);
                                 startActivity(intent);
                                 finish();
                                 break;
                             }else if(registrarEventoReligioso!=null ){
                                 Intent intents = new Intent(this,CrearEventoReligioso.class);
                                 intents.putExtra("nuevo",nuevo);
                                 intents.putExtra("enviarcodigo",  Integer.parseInt(codigo.getText().toString()));
                                 startActivity(intents);
                                 finish();
                                 break;
                             }

                         }else{
                             Toast msg = Toast.makeText(this, "Can not find the code entered", Toast.LENGTH_SHORT);
                             msg.show();
                         }
                    }

                    break;
            }
        } catch (Exception e) {
        }

    }
}
