package com.example._2023jan1;

import java.util.Comparator;

public abstract class Poklon {
    private String naziv;
    private String ID;
    private int cena;

    public Poklon(String naziv, String ID, int cena) {
        this.naziv = naziv;
        this.ID = ID;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getID() {
        return ID;
    }

    public int getCena() {
        return cena;
    }

    public abstract boolean prikladanPoklon(PolDeteta polDeteta);

    @Override
    public String toString() {
        return ID + " - " + naziv + ", " + cena + " din";
    }

}
