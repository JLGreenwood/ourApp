package app.com.example.administrator.myek3.app;

import java.text.DecimalFormat;

/**
 * Created by Darth Vader on 08.03.2017.
 * CheckData ist eine behilfs Klasse. Sie stellt die Methoden:
 *  - formatData(double data) - die Dezimalzahlen in Währungsformat dar,
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
    public static double formatData(double data){
        DecimalFormat df =   new DecimalFormat( ",##0.00" );
        return Double.parseDouble(df.format(data));
    }
}
