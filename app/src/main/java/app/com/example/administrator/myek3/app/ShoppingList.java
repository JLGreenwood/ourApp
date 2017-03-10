package app.com.example.administrator.myek3.app;

import android.util.Log;

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
    private String shoppingListId;

    // Konstruktor
    public ShoppingList() {
        this.shoppingListName = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
        this.shoppingListArticles = new ArrayList<>();
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
        this.shoppingListId = "";
    }
    public ShoppingList(String shoppingListName, String shoppingListId) {
        this.shoppingListName = shoppingListName;
        this.shoppingListId = shoppingListId;
        this.shoppingListArticles = new ArrayList<>();
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
    }
    public ShoppingList(String shoppingListName, ArrayList<Article> shoppingListArticles) {
        this.shoppingListName = shoppingListName;
        this.shoppingListArticles = shoppingListArticles;
        this.shoppingListTotalPrice = 0.0;
        this.shoppingListCompleted = false;
        this.shoppingListId = "";
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
    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
    }
    public void setShoppingListSingleArticle(Article article) {
        this.shoppingListArticles.add(article);
    }
    public void setArticleAtPosition(int position, Article article){
        Log.d("TEST", "TEST::::::: " + position + " - " + article.getArticleName() + " =>>> " + this.shoppingListArticles.get(position).getArticleName());
        this.shoppingListArticles.set(position, article);
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
    public int getArticlePositionByShoppingListArticle (Article article) {
        return this.shoppingListArticles.indexOf(article);
    }
    public int getShoppingListArticleCount() {
        return shoppingListArticles.size();
    }
    public boolean ShoppingListContainsArticle(Article article){
        if (this.shoppingListArticles.equals(article)){
            return true;
        }
        return false;
    }
    public double getShoppingListTotalPrice() {
        return shoppingListTotalPrice;
    }
    public boolean isShoppingListCompleted() {
        return shoppingListCompleted;
    }
    public String getShoppingListId() {
        return shoppingListId;
    }
}
