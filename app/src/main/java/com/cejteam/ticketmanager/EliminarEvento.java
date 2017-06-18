package com.cejteam.ticketmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        if(TextUtils.isEmpty(codigo.toString())){
            Toast fmsgs = Toast.makeText(this, "LLENE EL CAMPO", Toast.LENGTH_SHORT);
            fmsgs.show();
        }else if (almacenEventos.verificarexistencia(Integer.parseInt(codigo.getText().toString()))){
            codigoelim=codigo.getText().toString();
            codig= Integer.parseInt(codigoelim);
            almacenEventos.borrarEvento(codig);
        }else{
            Toast fmsg = Toast.makeText(this, "INGRESE UN EVENTO CORRECTO", Toast.LENGTH_SHORT);
            fmsg.show();
        }
    }
}


