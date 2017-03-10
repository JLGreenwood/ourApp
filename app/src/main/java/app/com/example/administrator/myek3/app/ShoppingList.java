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
    //private static final long serialVersionUID = -4783110522368225L;
    // Attribute
    private String shoppingListName;
    private String shoppingListTotalPrice;
    private boolean shoppingListCompleted;
    private String shoppingListId;
    private ArrayList<Article> shoppingListArticles;
//    private static int listenNumber = 0;

    // Konstruktor
    public ShoppingList() {
        this.shoppingListName = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
        this.shoppingListTotalPrice = "0.00";
        this.shoppingListArticles = new ArrayList<Article>();
        this.shoppingListCompleted = false;
        this.shoppingListId = "";
    }
    public ShoppingList(String shoppingListName) {
        this.shoppingListName = shoppingListName;
        this.shoppingListTotalPrice = "0.00";
        this.shoppingListCompleted = false;
        this.shoppingListArticles = new ArrayList<Article>();
    }
    public ShoppingList(String shoppingListName, ArrayList<Article> shoppingListArticles) {
        this.shoppingListName = shoppingListName;
        this.shoppingListArticles = shoppingListArticles;
        this.shoppingListTotalPrice = "0.00";
        this.shoppingListCompleted = false;
        this.shoppingListId = "";
    }
    public ShoppingList(String shoppingListName, ArrayList<Article> shoppingListArticles, String shoppingListTotalPrice) {
        this.shoppingListName = shoppingListName;
        this.shoppingListArticles = shoppingListArticles;
        this.shoppingListTotalPrice = shoppingListTotalPrice;
        this.shoppingListCompleted = false;
    }

    // Setter
    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }
    public void setShoppinglistSingelArtikel(Article article){
        this.shoppingListArticles.add(article);
    }
    public void setShoppingListArticles(ArrayList<Article> shoppingListArticles) {
        this.shoppingListArticles = shoppingListArticles;
    }
    public void setShoppingListTotalPrice(String shoppingListTotalPrice) {
        this.shoppingListTotalPrice = shoppingListTotalPrice;
    }
    public void setShoppingListCompleted(boolean shoppingListCompleted) {
        this.shoppingListCompleted = shoppingListCompleted;
    }
    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
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
    public int getSoppinglistArticlePostition(Article article){
        return this.shoppingListArticles.indexOf(article);
    }
    public int getShoppingListArticleCount() {
        return shoppingListArticles.size();
    }
    public String getShoppingListTotalPrice() {
        return shoppingListTotalPrice;
    }
    public boolean isShoppingListCompleted() {
        return shoppingListCompleted;
    }
    public String getShoppingListId() {
        return shoppingListId;
    }
}
