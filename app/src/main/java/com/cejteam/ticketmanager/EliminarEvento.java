package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class EliminarEvento extends AppCompatActivity implements View.OnClickListener {
    Button eliminar;
    EditText codigo;
    String codigoelim;
    AlmacenEventos almacenEventos= new AlmacenEventos();
    int codig=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_evento);
        eliminar = (Button) findViewById(R.id.cancelarevento);
        codigo = (EditText) findViewById(R.id.codigodelevento);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calendar hoy = Calendar.getInstance();
        int ano = hoy.get(Calendar.YEAR);
        int mes = hoy.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        if (TextUtils.isEmpty(codigo.toString())) {
            Toast fmsgs = Toast.makeText(this, "PLEASE, FILL THE FIELD", Toast.LENGTH_SHORT);
            fmsgs.show();
        } else if (!TextUtils.isEmpty(codigo.toString())) {
            RegistrarEventoDeportivo registrarEventoDeportivo = almacenEventos.buscarEventodeportivo(Integer.parseInt(codigo.getText().toString()));
            RegistrarEventoReligioso registrarEventoReligioso = almacenEventos.buscareventoreligioso(Integer.parseInt(codigo.getText().toString()));
            RegistrarEventoMusical registrarEventoMusical = almacenEventos.buscareventomusical(Integer.parseInt(codigo.getText().toString()));
            if (registrarEventoReligioso != null) {
                codigoelim = codigo.getText().toString();
                codig = Integer.parseInt(codigoelim);
                almacenEventos.borrarEvento(codig);
                Toast fmsg = Toast.makeText(this, "\n" + "Event successfully deleted", Toast.LENGTH_SHORT);
                fmsg.show();
                Intent intent = new Intent(this, MenuEvents.class);
                startActivity(intent);
                finish();
            } else if (registrarEventoDeportivo != null) {
                if (registrarEventoDeportivo.getAño() == ano && registrarEventoDeportivo.getMes() == mes && ((registrarEventoDeportivo.getDia() - dia == 1) || (registrarEventoDeportivo.getDia() - dia == 0))) {
                    double costo = Integer.parseInt(registrarEventoDeportivo.getAmount());
                    double cobrar = costo / 2;
                    registrarEventoDeportivo.setAmount(String.valueOf(cobrar));
                }
                codigoelim = codigo.getText().toString();
                codig = Integer.parseInt(codigoelim);
                almacenEventos.borrarEvento(codig);
                Toast fmsg = Toast.makeText(this, "\n" + "Event successfully deleted", Toast.LENGTH_SHORT);
                fmsg.show();
                Intent intent = new Intent(this, MenuEvents.class);
                startActivity(intent);
                finish();
            } else if (registrarEventoMusical != null) {
                if (registrarEventoMusical.getAño() == ano && registrarEventoMusical.getMes() == mes && ((registrarEventoMusical.getDia() - dia == 1) ||(registrarEventoMusical.getDia() - dia == 0) )){
                    double costo = Integer.parseInt(registrarEventoMusical.getAmount());
                    double cobrar = costo / 2;
                    registrarEventoMusical.setAmount(String.valueOf(cobrar));
                }
                codigoelim = codigo.getText().toString();
                codig = Integer.parseInt(codigoelim);
                almacenEventos.borrarEvento(codig);
                Toast fmsg = Toast.makeText(this, "\n" + "Event successfully deleted", Toast.LENGTH_SHORT);
                fmsg.show();
                Intent intent = new Intent(this, MenuEvents.class);
                startActivity(intent);
                finish();
            }else{
                Toast fmsg = Toast.makeText(this, "ENTER A CORRECT EVENT", Toast.LENGTH_SHORT);
                fmsg.show();
            }
        } else {
            Toast fmsg = Toast.makeText(this, "ENTER A CORRECT EVENT", Toast.LENGTH_SHORT);
            fmsg.show();

        }
    }
}


