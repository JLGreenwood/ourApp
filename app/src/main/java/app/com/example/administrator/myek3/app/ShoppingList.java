package app.com.example.administrator.myek3.app;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Darth Vader on 02.03.2017
 * Einkaufslistse implementiert Serializable und kann somit gespeichert werden.
 * Mit der Klasse Einkaufsliste erstellen wir Einkaufslisten-Objekte. Als Attribut hat sie
 * den Listen Namen, eine fortlaufende Listennummer, eine ArrayListe mit den Artikel-Objekten, den Betrag den der Benutzer
 * ausgegeben hat und eine Status Variable.
 * Darüber hinaus hat sie noch Getter() und Setter
 */

public class ShoppingList implements Serializable{
    // Attribute
    private String listenName;
    private static int listenNummer = 0;
    private ArrayList<Article> listenArtikel;
    private String gezahlterBetrag;
    private boolean status;

    // Konstruktor
    public ShoppingList(String listenName){
        this.listenName = listenName;
        this.listenNummer++;
        this.gezahlterBetrag = "";
        this.status = false;
    }
    public ShoppingList(String listenName, ArrayList<Article> listenArtikel){
        this.listenName = listenName;
        this.listenNummer++;
        this.listenArtikel = listenArtikel;
        this.gezahlterBetrag = "";
        this.status = false;
    }
    public ShoppingList(String listenName, ArrayList<Article> listenArtikel, String gezahlterBetrag){
        this.listenName = listenName;
        this.listenNummer++;
        this.listenArtikel = listenArtikel;
        this.gezahlterBetrag = gezahlterBetrag;
        this.status = false;
    }

    // Getter()/Setter()
    public String getListenName() {
        return listenName;
    }

    public static int getListenNummer() {
        return listenNummer;
    }

    public ArrayList<Article> getListenArtikel() {
        return listenArtikel;
    }

    public String getGezahlterBetrag() {
        return gezahlterBetrag;
    }

    public boolean isStatus() {
        return status;
    }

    public void setListenName(String listenName) {
        this.listenName = listenName;
    }

    public static void setListenNummer(int listenNummer) {
        ShoppingList.listenNummer = listenNummer;
    }

    public void setListenArtikel(ArrayList<Article> listenArtikel) {
        this.listenArtikel = listenArtikel;
    }

    public void setGezahlterBetrag(String gezahlterBetrag) {
        this.gezahlterBetrag = gezahlterBetrag;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
