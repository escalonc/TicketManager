package com.cejteam.ticketmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Create_EventActivity extends AppCompatActivity implements View.OnClickListener {
    private int año,mes,dia;
    private static  final int tipo_dialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;

    private Spinner spinner;
    private EditText event,tittle,eventdescription,eventamount,campofecha;
    private Button saved;
    private ArrayList<Register_events> register;

    public Create_EventActivity(){
        register= new ArrayList<Register_events>();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_create__event);
         event =(EditText)findViewById(R.id.eventcoder);
         tittle =(EditText)findViewById(R.id.eventtittler);
         eventdescription =(EditText)findViewById(R.id.eventdescriptionr);
         eventamount =(EditText)findViewById(R.id.eventamountr);
         saved=(Button)findViewById(R.id.saved);
         saved.setOnClickListener(this);
         campofecha= (EditText)findViewById(R.id.dateeventr);
         spinner= (Spinner)findViewById(R.id.event_type);
         List list= new ArrayList();

        String eventName = event.getText().toString();

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
            switch (seleccion){
                case R.id.saved:
                    if(TextUtils.isEmpty(spinner.toString()) ||TextUtils.isEmpty(event.getText()) || TextUtils.isEmpty(tittle.getText()) || TextUtils.isEmpty(eventdescription.getText())|| TextUtils.isEmpty(eventamount.getText()) || TextUtils.isEmpty(campofecha.getText())){
                        Toast msg = Toast.makeText(this, "POR FAVOR, LLENE LOS CAMPOS QUE ESTAN VACIOS", Toast.LENGTH_SHORT);
                        msg.show();
                    }
                    /*for (int i = 0; i < register.size(); i++) {
                        Calendar fechaActual = Calendar.getInstance();
                        if (register.get(i).getDate().equals(campofecha)) {
                            Toast msg = Toast.makeText(this, "YA HAY UN EVENTO PARA ESA FECHA", Toast.LENGTH_SHORT);
                            msg.show();
                            break;
                        }
                    }*/
                    Toast msg = Toast.makeText(this, "aqui voy", Toast.LENGTH_SHORT);
                    msg.show();
                    Register_events r=new Register_events(spinner.toString(),tittle.getText().toString(),event.getText().toString(), eventdescription.getText().toString(),campofecha.getText().toString(),eventamount.getText().toString());
                     register.add(r);
            Toast fmsg = Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT);
            fmsg.show();
                    break;
            }

        }catch (Exception e){
            Toast msg = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            msg.show();
        };
}
    public void mostrarfecha(){
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
