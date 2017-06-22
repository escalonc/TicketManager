package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class FechaInicial extends AppCompatActivity {
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    EditText fecha;
    int año,mes,dia,dia1,mes1,ano1;
    Button menu,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_inicial);



        menu=(Button)findViewById(R.id.menu343);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(FechaInicial.this,MenuEvents.class);
                startActivity(intenst);
            }
        });








      /////////////////////////////////////////////////////////////////
        Calendar calendar= Calendar.getInstance();
        año= calendar.get(Calendar.YEAR);
        mes= calendar.get(Calendar.MONTH);
        dia= calendar.get(Calendar.DAY_OF_MONTH);
        mostrarfecha();
        oyenteSelectorFecha = new  DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año=year;
                mes=month;
                dia=dayOfMonth;
                mostrarfecha();
            }

        };
        /////////////////////////////////////////////////////////////////


        fecha= (EditText)findViewById(R.id.fechainicialcalendar);
        next=(Button)findViewById(R.id.fechainicialcalc);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenst = new Intent(FechaInicial.this,FechaFinal.class);
                intenst.putExtra("ano1",ano1);
                intenst.putExtra("mes1",mes1);
                intenst.putExtra("dia1",dia1);
                startActivity(intenst);
                finish();
            }
        });
    }

        /////////////////////////////////////////////////////////////////

    public void mostrarfecha() {
        try {
            dia1 = dia;
            mes1 = mes;
            ano1 = año;


            fecha.setText(dia + "/" + (mes + 1) + "/" + año);
        }catch (Exception e){}
    }
    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this, oyenteSelectorFecha, año, mes, dia);

            /*
            POR SI LA FECHA APARECE EN 1900 INICIALIZADA
            return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia)
            */

        }
        return null;
    }
    public void mostrarCalendar1(View control){
        showDialog(tipo_dialogo);
    }

}
