package com.example._2023jan1;

public class Igracka extends Poklon {
    private VrstaIgracke vrsta;

    public Igracka(String naziv, String ID, int cena, VrstaIgracke vrsta) {
        super(naziv, ID, cena);
        this.vrsta = vrsta;
    }

    public VrstaIgracke getVrsta() {
        return vrsta;
    }

    public void setVrsta(VrstaIgracke vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public boolean prikladanPoklon(PolDeteta polDeteta) {
        if(polDeteta.getSkracenica() == 'M') {
            if(vrsta.getSkracenica() == 'Z')
                return false;
            return true;
        }
        else if(polDeteta.getSkracenica() == 'Z') {
            if(vrsta.getSkracenica() == 'M') {
                return false;
            }
            return true;
        }
        return false;
    }
}
