package app.com.example.administrator.myek3.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Darth Vader on 08.03.2017.
 */

public class Saver {



    public Saver(){

    }
    public void saveShoppingliste(ShoppingList shoppingList){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:/NeuerOrdner/test2.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject("shoppingList hallololo");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) try { oos.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }
    }

    public ShoppingList loadShoppingliste(){
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        ShoppingList shop = null;
        try {
            fis = new FileInputStream("C:/NeuerOrdner/test2.txt");
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof ShoppingList) {
                shop = (ShoppingList)obj;

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
        return shop;
    }
}
