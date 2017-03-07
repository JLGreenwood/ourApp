package app.com.example.administrator.myek3.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

/**
 * Created by Darth Vader on 02.03.2017
 * Einkaufsliste implementiert Serializable und kann somit gespeichert werden.
 * Mit der Klasse Einkaufsliste erstellen wir Einkaufslisten-Objekte. Als Attribut hat sie
 * den Listen Namen, eine fortlaufende Listennummer, eine ArrayListe mit den Artikel-Objekten, den Betrag den der Benutzer
 * ausgegeben hat und eine Status Variable.
 * Darüber hinaus hat sie noch Getter() und Setter
 */

public class ShoppingList implements Serializable {
    // Attribute
    private String shoppingListName;
    private ArrayList<Article> shoppingListArticles;
    private double shoppingListTotalPrice;
    private boolean shoppingListCompleted;
//    private static int listenNumber = 0;

    // Konstruktor
    public ShoppingList() {
        //this.shoppingListName = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()).toString();
        this.shoppingListName = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
    }
    public ShoppingList(String shoppingListName) {
        this.shoppingListName = shoppingListName;
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
    }
    public ShoppingList(String shoppingListName, ArrayList<Article> shoppingListArticles) {
        this.shoppingListName = shoppingListName;
        this.shoppingListArticles = shoppingListArticles;
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
    }
    public ShoppingList(String shoppingListName, ArrayList<Article> shoppingListArticles, double shoppingListTotalPrice) {
        this.shoppingListName = shoppingListName;
        this.shoppingListArticles = shoppingListArticles;
        this.shoppingListTotalPrice = shoppingListTotalPrice;
        this.shoppingListCompleted = false;
    }

    // Setter
    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }
    public void setShoppingListArticles(ArrayList<Article> shoppingListArticles) {
        this.shoppingListArticles = shoppingListArticles;
    }
    public void setShoppingListTotalPrice(double shoppingListTotalPrice) {
        this.shoppingListTotalPrice = shoppingListTotalPrice;
    }
    public void setShoppingListCompleted(boolean shoppingListCompleted) {
        this.shoppingListCompleted = shoppingListCompleted;
    }

    // Getter
    public String getShoppingListName() {
        return shoppingListName;
    }
    public ArrayList<Article> getShoppingListArticles() {
        return shoppingListArticles;
    }
    public Article getShoppingListArticleById(int position) {
        return this.shoppingListArticles.get(position);
    }
    public int getShoppingListArticleCount() {
        return shoppingListArticles.size();
    }
    public double getShoppingListTotalPrice() {
        return shoppingListTotalPrice;
    }
    public boolean isShoppingListCompleted() {
        return shoppingListCompleted;
    }
}
