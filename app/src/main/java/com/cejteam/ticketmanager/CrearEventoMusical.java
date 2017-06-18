package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CrearEventoMusical extends AppCompatActivity implements View.OnClickListener{
    private int año,mes,dia;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    int dia1,dia2,mes1,mes2,ano1,ano2;
    private Spinner spinner;
    private EditText event,tittle,eventdescription,eventamount,campofecha,people;
    private Button saved;
    TextView totalapagar;
    AlmacenEventos almacenEventos=new AlmacenEventos();
    private int codeevent=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento_musical);
        event =(EditText)findViewById(R.id.eventcodermusical);
        totalapagar= (TextView)findViewById(R.id.costostotalmusical);
        tittle =(EditText)findViewById(R.id.eventtittlermusical);
        eventdescription =(EditText)findViewById(R.id.eventdescriptionrmusical);
        eventamount =(EditText)findViewById(R.id.costosmusical);
        saved=(Button)findViewById(R.id.savedmusical);
        people=(EditText)findViewById(R.id.peoplesmusical);
        saved.setOnClickListener(this);
        campofecha= (EditText)findViewById(R.id.dateeventrmusical);
        spinner= (Spinner)findViewById(R.id.event_typemusical);
        List list= new ArrayList();

        list.add("Pop");
        list.add("Rock");
        list.add("Rap");
        list.add("Clasica");
        list.add("Reggaeton");
        list.add("Others");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

    }

    public void onClick(View v) {
        int seleccion= v.getId();

        try{
            switch (seleccion) {
                case R.id.savedmusical:

                    Calendar calendario = Calendar.getInstance();
                    ano2 = calendario.get(Calendar.YEAR);
                    mes2 = calendario.get(Calendar.MONTH);
                    dia2 = calendario.get(Calendar.DAY_OF_MONTH);
                    if (TextUtils.isEmpty(spinner.toString()) || TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText()) || TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText()) || TextUtils.isEmpty(people.getText())) {
                        Toast msg = Toast.makeText(this, "POR FAVOR, LLENE LOS CAMPOS QUE ESTAN VACIOS", Toast.LENGTH_SHORT);
                        msg.show();
                    } else if (!almacenEventos.comparardeportivo(campofecha) ||!almacenEventos.compararreligioso(campofecha) ||!almacenEventos.compararmusical(campofecha)   ) {
                        Toast msg = Toast.makeText(this, "ya existe esta fecha", Toast.LENGTH_SHORT);
                        msg.show();
                    } else if (ano1 < ano2) {
                        Toast fmsg = Toast.makeText(this, "ESA FECHA NO ES VALIDA", Toast.LENGTH_SHORT);
                        fmsg.show();
                    } else if (ano1 == ano2 && mes1 < mes2) {
                        Toast fmsg = Toast.makeText(this, "ESA FECHA NO ES VALIDA", Toast.LENGTH_SHORT);
                        fmsg.show();
                    } else if (ano1 == ano2 && mes1 == mes2 && dia1 < dia2) {
                        Toast fmsg = Toast.makeText(this, "ESA FECHA NO ES VALIDA", Toast.LENGTH_SHORT);
                        fmsg.show();
                    } else if(Integer.parseInt(people.getText().toString())>20000){
                        Toast fmsg = Toast.makeText(this, "LA CANTIDAD MAXIMA ES DE 20000 PERSONAS", Toast.LENGTH_SHORT);
                        fmsg.show();
                    } else{
                        codeevent = Integer.parseInt(event.getText().toString());
                        RegistrarEventoMusical r = new RegistrarEventoMusical(spinner.toString(), tittle.getText().toString(), codeevent, eventdescription.getText().toString(), campofecha.getText().toString(), eventamount.getText().toString(), people.getText().toString(),totalapagar.getText().toString());
                        almacenEventos.registrarmusical(r);
                        Toast fmsg = Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT);
                        fmsg.show();
                        Intent intent = new Intent(this, MenuEvents.class);
                        startActivity(intent);
                        finish();
                    }
            }


        }catch (Exception e){

        }
    }


    public void mostrarfecha(){
        dia1=dia;
        mes1=mes;
        ano1=año;


        campofecha.setText(dia+"/"+(mes+1)+"/"+año);
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
    public void mostrarCalendar(View control){
        showDialog(tipo_dialogo);
    }

}
