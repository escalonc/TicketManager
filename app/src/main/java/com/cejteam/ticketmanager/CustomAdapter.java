package com.cejteam.ticketmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by joel.caballero on 20/6/2017.
 */

public class CustomAdapter extends ArrayAdapter<Event> {
    public CustomAdapter(@NonNull Context context, ArrayList<Event> eventos) {
        super(context, R.layout.custom_listview ,eventos);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_listview, parent, false);

        Event singleItem = getItem(position);
        TextView TextViewCodigo = (TextView) customView.findViewById(R.id.textViewCodigo);
        TextView TextViewTipo = (TextView) customView.findViewById(R.id.textViewTipo);
        TextView TextViewTitulo = (TextView) customView.findViewById(R.id.textViewTitulo);
        TextView TextViewFecha = (TextView) customView.findViewById(R.id.textViewFecha);
        TextView TextViewMonto = (TextView) customView.findViewById(R.id.textViewMonto);
        ImageView ImagenLista = (ImageView) customView.findViewById(R.id.imageViewLista);
        try {
            TextViewCodigo.setText("Code: " + String.valueOf(singleItem.getEvent()));
            //para saber el tipo de evento
            if (singleItem instanceof RegistrarEventoDeportivo) {
                TextViewTipo.setText("Event Type: Sports");
                ImagenLista.setImageResource(R.drawable.deportivo);
            } else if (singleItem instanceof RegistrarEventoMusical) {
                TextViewTipo.setText("Event Type: Musical");
                ImagenLista.setImageResource(R.drawable.musicali);
            } else if (singleItem instanceof RegistrarEventoReligioso) {
                TextViewTipo.setText("Event Type: Religious");
                ImagenLista.setImageResource(R.drawable.religiosoi);
            }

            TextViewTitulo.setText("Title: " + singleItem.getTittle());
            TextViewFecha.setText("Date: " + singleItem.getDate());
            TextViewMonto.setText("Amount payable: " + String.valueOf(singleItem.getAmount()));


        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        //para saber el tipo de dato


        return customView;
    }

}
