package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_inicial);

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

            }
        });
    }

        /////////////////////////////////////////////////////////////////

    public void mostrarfecha(){
        dia1=dia;
        mes1=mes;
        ano1=año;


        fecha.setText(dia+"/"+(mes+1)+"/"+año);
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
