package app.com.example.administrator.myek3.app;

/**
 * Created by Darth Vader on 28.02.2017.
 * Die Klasse Artikel erstellt Produkt Objekte für die Einkaufslite her.
 * Über Getter und Setter gibt sie ihre Attribute preis / bzw. kann man
 * ihre Attribute ändern
 */

public class Artikel {

// Attribute
    private String artikel;
    private String anzahl;
    private String einheit;
    private double preis;
    private String kommentar;
    private boolean status;

// Konstruktoren
    public Artikel(String artikel, String anzahl, boolean status){
        this.artikel = artikel;
        this.anzahl = anzahl;
        this.status = status;
    }
    public Artikel(String artikel, String anzahl, String einheit){
        this.artikel = artikel;
        this.anzahl = anzahl;
        this.einheit = einheit;
    }
    public Artikel(String artikel, String anzahl, String einheit, double preis, String kommentar){
        this.artikel = artikel;
        this.anzahl = anzahl;
        this.einheit = einheit;
        this.preis = preis;
        this.kommentar = kommentar;
    }

// Setter()
    public void setArtikel(String artikel){
        this.artikel = artikel;
    }

    public void setAnzahl(String anzahl) {
        this.anzahl = anzahl;
    }
    public void setEinheit(String einheit){
        this.einheit = einheit;
    }
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

// Getter()
    public String getArtikel() {
        return artikel;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public String getEinheit() {
        return einheit;
    }

    public String getKommentar() {
        return kommentar;
    }

    public boolean isStatus() {
        return status;
    }
}
