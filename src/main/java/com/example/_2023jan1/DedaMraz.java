package com.example._2023jan1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DedaMraz extends Application {
    private List<Paketic> paketici;
    List<UredjeniPar<Poklon, Integer>> spisakPoklona;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox vbGlavni = new VBox(10);
        vbGlavni.setPadding(new Insets(10, 10, 10, 10));

        HBox hb1 = new HBox(10);
        VBox vbLevi = new VBox(10);
        VBox vbDesni = new VBox(10);

        Label lbIme = new Label("Ime i prezime:");
        TextField tfIme = new TextField();
        Label lbPol = new Label("Pol deteta:");
        RadioButton rbMuski = new RadioButton("Muski");
        RadioButton rbZenski = new RadioButton("Zenski");
        ToggleGroup tg = new ToggleGroup();
        rbMuski.setToggleGroup(tg);
        rbZenski.setToggleGroup(tg);
        Label lbBudzet = new Label("Budzet za paketic:");
        TextField tfBudzet = new TextField();
        Button btnNapuni = new Button("Napuni paketic");
        vbLevi.getChildren().addAll(lbIme, tfIme, lbPol, rbMuski, rbZenski, lbBudzet, tfBudzet, btnNapuni);

        TextArea ta = new TextArea();
        ta.setPrefHeight(400);
        ta.setPrefWidth(200);
        HBox hbZaDugmice = new HBox(10);
        Button btnUcitaj = new Button("Ucitaj poklone");
        Button btnPrikazi = new Button("Prikazi spisak za Deda Mraza");

        Path putanja = Paths.get("src", "pokloni.txt");
        TreeMap<String, Pair<String, Integer>> pokloni = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        String naziv = "", idS = "";
        try(Scanner ulaz = new Scanner(putanja)) {
            while(ulaz.hasNext()) {
                if(ind == 0) {
                    idS = ulaz.next().substring(0, 2);
                    ind = 1;
                }
                if(ind == 1) {
                    sb.append(ulaz.next());
                    naziv = sb.toString();
                    if(naziv.charAt(naziv.length()-1) == ',') {
                        ind = 2;
                        sb.delete(0, sb.length());
                    }
                    sb.append(" ");
                }
                if(ind == 2) {
                    String cena = ulaz.next();
                    ta.appendText(idS + " - " + naziv + " " + cena + '\n');
                    naziv = "";
                    ind = 0;
                }
            }
        } catch(Exception f) {
            System.out.println("ehhhhh");
            f.printStackTrace();
            System.exit(1);
        }
        List<Map.Entry<String, Pair<String, Integer>>> listaPoklona = new ArrayList<>(pokloni.entrySet());
        btnUcitaj.setOnAction(e -> {
            for(Map.Entry<String, Pair<String, Integer>> it : listaPoklona) {
                String id = it.getKey();
                Pair<String, Integer> pom = it.getValue();
                String naziv1 = pom.getKey();
                String cena1 = pom.getValue().toString();
                ta.appendText(id + " - " + naziv1 + ", " + cena1);
            }
        });
        hbZaDugmice.getChildren().addAll(btnUcitaj, btnPrikazi);
        vbDesni.getChildren().addAll(ta, hbZaDugmice);
        hb1.getChildren().addAll(vbLevi, vbDesni);
        vbGlavni.getChildren().addAll(hb1);

        Scene scena = new Scene(vbGlavni, 500, 300);
        stage.setScene(scena);
        stage.setTitle("Deda Mrazov pomocnik");
        stage.show();
    }
}
