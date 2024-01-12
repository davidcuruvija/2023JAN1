package com.example._2023jan1;

public enum VrstaIgracke {
    MUSKA('M'),
    ZENSKA('Z'),
    NEUTRALNA('N');
    private char skracenica;

    VrstaIgracke(char skracenica) {
        this.skracenica = skracenica;
    }

    public char getSkracenica() {
        return skracenica;
    }

    public static VrstaIgracke odSkracenice(char skracenica) {
        if(skracenica == 'M') {
            return MUSKA;
        }
        else if(skracenica == 'Z') {
            return ZENSKA;
        }
        else {
            return NEUTRALNA;
        }
    }
}
