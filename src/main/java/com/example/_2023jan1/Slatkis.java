package com.example._2023jan1;

public class Slatkis extends Poklon {
    public Slatkis(String naziv, String ID, int cena) {
        super(naziv, ID, cena);
    }

    @Override
    public boolean prikladanPoklon(PolDeteta polDeteta) {
        return true;
    }
}
