package com.cejteam.ticketmanager.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cejteam.ticketmanager.R;
import com.cejteam.ticketmanager.RegistrarEventoDeportivo;

import java.util.List;

/**
 * Created by joel.caballero on 24/5/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Items> {
List<RegistrarEventoDeportivo>listaEvents;

    public Adapter(List<RegistrarEventoDeportivo> listaEvents) {
        this.listaEvents = listaEvents;
    }

    @Override
    public Items onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);
        Items i= new Items(v);
        return i;
    }

    @Override
    public void onBindViewHolder(Items holder, int position) {
        //holder.image.setImageResource(listaEvents.get(position).getFoto());
        holder.tittless.setText(listaEvents.get(position).getTittle());
        holder.tittless.setText(listaEvents.get(position).getDate());
        holder.tittless.setText(listaEvents.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listaEvents.size();
    }

    public static class Items extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tittless,datess,descriptionss;

        public Items(View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.imageView);
            tittless=(TextView)  itemView.findViewById(R.id.tittlet);
            datess=(TextView)  itemView.findViewById(R.id.datet);
            descriptionss=(TextView)  itemView.findViewById(R.id.descriptiont);

        }
    }

}
