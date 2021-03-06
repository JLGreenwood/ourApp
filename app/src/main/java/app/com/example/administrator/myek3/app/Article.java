package app.com.example.administrator.myek3.app;

import android.util.Log;

/**
 * Created by Darth Vader on 28.02.2017.
 * Die Klasse Artikel erstellt Produkt Objekte für die Einkaufslite her.
 * Über Getter und Setter gibt sie ihre Attribute preis / bzw. kann man
 * ihre Attribute ändern
 */

public class Article {

// Attribute
    private String articleName;
    private String articleAmount;
    private String articleUnit;
    private double articlePrice;
    private String articleComment;
    private boolean articleChecked;

// Konstruktoren
    public Article(String articleName){
        this.articleName = articleName;
        this.articleAmount = "1";
        this.articleUnit = "";
        this.articlePrice = 0;
        this.articleComment = "";
        this.articleChecked = false;

    }
    public Article(String articleName, String articleAmount){
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleUnit = "";
        this.articlePrice = 0;
        this.articleComment = "";
        this.articleChecked = false;
    }
    public Article(String articleName, String articleAmount, boolean articleChecked){
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleUnit = "";
        this.articlePrice = 0;
        this.articleComment = "";
        this.articleChecked = articleChecked;
    }
    public Article(String articleName, String articleAmount, String articleUnit){
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleUnit = articleUnit;
        this.articlePrice = 0;
        this.articleComment = "";
        this.articleChecked = false;
    }
    public Article(String articleName, String articleAmount, String articleUnit, double articlePrice, String articleComment){
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleUnit = articleUnit;
        this.articlePrice = articlePrice;
        this.articleComment = articleComment;
        this.articleChecked = false;
    }

    // Setter()
    public void setArticleName(String articleName){
        this.articleName = articleName;
    }
    public void setArticleAmount(String articleAmount) {
        this.articleAmount = articleAmount;
    }
    public void setArticleUnit(String articleUnit){
        this.articleUnit = articleUnit;
    }
    public void setArticlePrice(double articlePrice){this.articlePrice = articlePrice;}
    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }
    public void setArticleChecked(boolean articleChecked) {
        this.articleChecked = articleChecked;
    }

// Getter()
    public String getArticleName() {
        return articleName;
    }
    public String getArticleAmount() {
        return articleAmount;
    }
    public String getArticleUnit() {
        return articleUnit;
    }
    public double getArticlePrice() {return articlePrice;}
    public String getArticleComment() {
        return articleComment;
    }
    public boolean isArticleChecked() {
        return articleChecked;
    }
}
