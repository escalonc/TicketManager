package com.cejteam.ticketmanager;

import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by joel.caballero on 16/6/2017.
 */

public class AlmacenEventos {
    public static ArrayList<RegistrarEventoDeportivo> registrarEventoDeportivos = new ArrayList<>();
    public static ArrayList<RegistrarEventoMusical> registrarEventoMusicals = new ArrayList<>();
    public static ArrayList<RegistrarEventoReligioso> registrarEventoReligiosos = new ArrayList<>();


    public void registrardeportivo(RegistrarEventoDeportivo dr) {
        registrarEventoDeportivos.add(dr);
    }
    public void registrarmusical(RegistrarEventoMusical dr) {
        registrarEventoMusicals.add(dr);
    }

    public void registrarreligioso(RegistrarEventoReligioso dr) {
        registrarEventoReligiosos.add(dr);
    }
    public boolean comparardeportivo(EditText campofecha) {
        for (RegistrarEventoDeportivo k : registrarEventoDeportivos) {
            if (k.getDate() == String.valueOf(campofecha.toString())) {
                return false;
            }
        }
        return true;
    }

    public boolean compararreligioso(EditText campofecha) {
        for (RegistrarEventoReligioso j : registrarEventoReligiosos) {
            if (j.getDate() == String.valueOf(campofecha.toString())) {
                return false;
            }
        }
        return true;
    }
    public boolean compararmusical(EditText campofecha) {
        for (RegistrarEventoMusical j : registrarEventoMusicals) {
            if (j.getDate() == String.valueOf(campofecha.toString())) {
                return false;
            }
        }
        return true;
    }

    public  void borrarEvento(int cod) {
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == cod) {
                registrarEventoDeportivos.remove(e);
            }
        }
    }

    public  boolean verificarexistencia(int codigo) {
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == codigo) {
                return true;
            }
        }
        return false;
    }

    public RegistrarEventoDeportivo buscarEvento(int cod) {
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == cod) {
                return e;
            }
        }
        return null;
    }

}
