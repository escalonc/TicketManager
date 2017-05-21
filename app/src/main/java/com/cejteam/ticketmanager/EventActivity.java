package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IntDef;
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
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.cejteam.ticketmanager.R.id.dateeventr;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
  private Spinner spinner;
    private int año,mes,dia;
    private Button guardar;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    ArrayList<EventActivity> items;

    public EventActivity(){
        this.items= new ArrayList<EventActivity>();
    }
/*ELEMENTOS DE LA PANTALLA*/



    EditText event =(EditText)findViewById(R.id.eventcoder);
    EditText tittle =(EditText)findViewById(R.id.eventtittler);
    EditText eventdescription =(EditText)findViewById(R.id.eventdescriptionr);
    EditText eventamount =(EditText)findViewById(R.id.eventamountr);
    Button saved=(Button)findViewById(R.id.saved);
    EditText campofecha= (EditText)findViewById(R.id.dateeventr);
    /*FIN ELEMENTOS DE LA PANTALLA*/



    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
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



        spinner= (Spinner)findViewById(R.id.event_type);


        List list= new ArrayList();
        list.add("Deportivo");
        list.add("Musical");
        list.add("Religioso");

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

    }

    public void mostrarfecha(){
        campofecha.setText(dia+"/"+(mes+1)+"/"+año);
    }

    @Override
    protected  Dialog onCreateDialog(int id){
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

    @Override
    public void onClick(View v) {
        int seleccion= v.getId();
        try{
            switch (seleccion){
                case R.id.saved:
                    if(spinner.equals("")||event.equals("")|| tittle.equals("")|| eventdescription.equals("")|| eventamount.equals("") ){
                        Toast msg = Toast.makeText(this, "POR FAVOR, LLENE LOS CAMPOS QUE ESTAN VACIOS", Toast.LENGTH_SHORT);
                        msg.show();
                    }
                    for (int i = 0; i <items.size(); i++) {
                       Calendar fechaActual= Calendar.getInstance();
                        if(items.get(i).campofecha.equals(campofecha)){
                            Toast msg = Toast.makeText(this, "YA HAY UN EVENTO PARA ESA FECHA", Toast.LENGTH_SHORT);
                            msg.show();
                            break;
                        }else{
                            items.add(new EventActivity());
                        }
                    }
                    break;
            }

        }catch (Exception e){
            Toast msg = Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT);
            msg.show();
        };



    }




}
