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

public class AdaptadorDeVistaDeEventos extends ArrayAdapter<Event> {
    public AdaptadorDeVistaDeEventos(@NonNull Context context, ArrayList<Event> eventos) {
        super(context, R.layout.vista_de_eventos_por_fecha,eventos);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.vista_de_eventos_por_fecha, parent, false);
        Event singleItem = getItem(position);
        TextView TextViewCodigo = (TextView) customView.findViewById(R.id.CodigoDeEventoMostrar);
        TextView TextViewTipo = (TextView) customView.findViewById(R.id.TipoDeEventoMostrar);
        TextView TextViewTitulo = (TextView) customView.findViewById(R.id.TituloDeEventoMostrado);
        TextView TextViewFecha = (TextView) customView.findViewById(R.id.FechaDeEventoMostrado);
        TextView TextViewMonto = (TextView) customView.findViewById(R.id.MontoDeEventoMostrado);
        ImageView ImagenLista = (ImageView) customView.findViewById(R.id.ImagenDeEvento);
        try {
            TextViewCodigo.setText("Code: " + String.valueOf(singleItem.getEvent()));
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
        return customView;
    }

}
