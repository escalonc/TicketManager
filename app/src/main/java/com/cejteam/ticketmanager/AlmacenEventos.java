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

    public static ArrayList<RegistrarEventoDeportivo> registrarEventoDeportivoseliminados = new ArrayList<>();
    public static ArrayList<RegistrarEventoMusical> registrarEventoMusicalseliminados = new ArrayList<>();
    public static ArrayList<RegistrarEventoReligioso> registrarEventoReligiososeliminados = new ArrayList<>();


    public void registrardeportivo(RegistrarEventoDeportivo dr) {
        registrarEventoDeportivos.add(dr);
    }
    public void registrarmusical(RegistrarEventoMusical dr) {
        registrarEventoMusicals.add(dr);
    }

    public void registrarreligioso(RegistrarEventoReligioso dr) {
        registrarEventoReligiosos.add(dr);
    }
    public boolean comparardeportivo(String campofecha) {
        for (RegistrarEventoDeportivo k : registrarEventoDeportivos) {
            if (k.getDate().equals( String.valueOf(campofecha.toString()))) {
                return false;
            }
        }
        return true;
    }

    public boolean compararreligioso(String campofecha) {
        for (RegistrarEventoReligioso j : registrarEventoReligiosos) {
            if (j.getDate().equals( String.valueOf(campofecha.toString())) ){
                return false;
            }
        }
        return true;
    }
    public boolean compararmusical(String campofecha) {
        for (RegistrarEventoMusical j : registrarEventoMusicals) {
            if (j.getDate().equals( String.valueOf(campofecha.toString())) ){
                return false;
            }
        }
        return true;
    }

    public  void borrarEvento(int cod) {
        for (RegistrarEventoMusical e : registrarEventoMusicals) {
            if (e.getEvent() == cod) {
                registrarEventoMusicalseliminados.add(e);
                registrarEventoMusicals.remove(e);
            }
        }
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == cod) {
                registrarEventoDeportivoseliminados.add(e);
                registrarEventoDeportivos.remove(e);
            }
        }
        for (RegistrarEventoReligioso e : registrarEventoReligiosos) {
            if (e.getEvent() == cod) {
                registrarEventoReligiososeliminados.add(e);
                registrarEventoReligiosos.remove(e);
            }
        }


    }

    public  boolean verificarexistencia(int codigo) {
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == codigo) {
                return true;
            }
        }
        for (RegistrarEventoMusical e : registrarEventoMusicals) {
            if (e.getEvent() == codigo) {
                return true;
            }
        }
        for (RegistrarEventoReligioso e : registrarEventoReligiosos) {
            if (e.getEvent() == codigo) {
                return true;
            }
        }
        return false;
    }

    public RegistrarEventoDeportivo buscarEventodeportivo(int cod) {
        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getEvent() == cod) {
                return e;
            }
        }


        return null;
    }

    public RegistrarEventoMusical buscareventomusical(int cod) {
        for (RegistrarEventoMusical e : registrarEventoMusicals) {
            if (e.getEvent() == cod) {
                return e;
            }
        }


        return null;
    }

    public RegistrarEventoReligioso buscareventoreligioso(int cod) {
        for (RegistrarEventoReligioso e : registrarEventoReligiosos) {
            if (e.getEvent() == cod) {
                return e;
            }
        }


        return null;
    }



    public boolean buscarfechadep(String fecha, RegistrarEventoDeportivo deportivo) {

        for (RegistrarEventoDeportivo e : registrarEventoDeportivos) {
            if (e.getDate().equals(fecha) && e != deportivo) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarfechamus(String fecha, RegistrarEventoMusical musical) {

        for (RegistrarEventoMusical e : registrarEventoMusicals) {
            if (e.getDate().equals(fecha) && e != musical) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarfecharel(String fecha, RegistrarEventoReligioso religioso) {

        for (RegistrarEventoReligioso e : registrarEventoReligiosos) {
            if (e.getDate().equals(fecha) && e != religioso) {
                return true;
            }
        }
        return false;
    }

}
