package app.com.example.administrator.myek3.app;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by Darth Vader on 08.03.2017.
 * CheckData ist eine behilfs Klasse. Sie stellt die Methoden:
 *  - formatData(String data) - die Strings in  in Währungsformat darstellt,
 *  - String checkNumberIsEmpty - die leere Nummern Eingabefelder einen
 *    Standardwert vergibt,
 * zur Verfügung.
 */

public class CheckData {

    public static String checkNumberIsEmpty(String data){
        if(data.equals("")){
            data ="1";
        }
        return data;
    }
    public static String formatData(String data){
        if(!data.contains("€")) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            return nf.format(Double.parseDouble(data));
        }
        return data;
    }
    public static List<Article> articleListSort(List<Article> articleList){
        Collections.sort(articleList,new Comparator<Article>(){

            @Override
            public int compare(Article o1, Article o2) {
                if (o1.getArticleName().compareTo(o2.getArticleName()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return articleList;
    }
    public static ArrayList<Article> articleListSort(ArrayList<Article> articleList){
        Collections.sort(articleList,new Comparator<Article>(){

            @Override
            public int compare(Article o1, Article o2) {
                if (o1.getArticleName().compareTo(o2.getArticleName()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return articleList;
    }
}
