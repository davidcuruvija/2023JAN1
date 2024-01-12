package com.example._2023jan1;

public enum PolDeteta {
    MUSKI('M'),
    ZENSKI('Z');
    protected char skracenica;

    PolDeteta(char skracenica) {
        this.skracenica = skracenica;
    }

    public char getSkracenica() {
        return skracenica;
    }

    public static PolDeteta odSkracenice(char skracenica) {
        if(skracenica == 'M') {
            return MUSKI;
        }
        else if(skracenica == 'Z') {
            return ZENSKI;
        }
        else {
            System.err.println("Nevalidan pol.");
            System.exit(1);
            return MUSKI;
        }
    }
}
