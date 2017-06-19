package com.cejteam.ticketmanager;

import java.util.ArrayList;

/**
 * Created by joel.caballero on 24/5/2017.
 */

public class RegistrarEventoDeportivo extends Event {
    private String team1, team2;
    private ArrayList<String> teams1 = new ArrayList<>();
    private ArrayList<String> teams2 = new ArrayList<>();
    private String type;



    public void registrarteam1(String name) {
        teams1.add(name);
    }

    public void registrarteam2(String name) {
        teams2.add(name);
    }


    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }


    public ArrayList<String> getTeams1() {
        return teams1;
    }

    public void setTeams1(ArrayList<String> teams1) {
        this.teams1 = teams1;
    }

    public ArrayList<String> getTeams2() {
        return teams2;
    }

    public void setTeams2(ArrayList<String> teams2) {
        this.teams2 = teams2;
    }

    public RegistrarEventoDeportivo() {
        super();

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RegistrarEventoDeportivo(String type, String s, int codeevent, String description, String date, String amount, String team1, String team2, String people, int año, int mes, int dia, ArrayList<String> teams1, ArrayList<String> teams2) {
        super(codeevent, s, description, date, amount, people, dia, mes, año);
        this.team1 = team1;
        this.team2 = team2;
        this.teams1=teams1;
        this.teams2=teams2;

    }
}



