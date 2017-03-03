package app.com.example.administrator.myek3.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Darth Vader on 28.02.2017.
 * ArtikelListAdapter
 */

public class ArtikelListAdapter extends BaseAdapter{

    // Attribute
    private final List<Article> artikelList;
    private final LayoutInflater inflater;
    private Article artikel;

    // Konstruktoren
    public ArtikelListAdapter(List<Article> artikelList, Context context){
        this.artikelList = artikelList;
        inflater = LayoutInflater.from(context);
    }

    // Getter()/Setter()
    @Override
    public int getCount() {
        return this.artikelList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.artikelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ArtikelListAdapter.ViewHolder holder;

       if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_eklise, parent, false);
            holder = new ArtikelListAdapter.ViewHolder();
            holder.artikel_view = (TextView) convertView.findViewById(R.id.list_item_ekliste_textview);
//            holder.anzahl = (EditText)convertView.findViewById(R.id.input_anzahl);
//            holder.einheit = (EditText)convertView.findViewById(R.id.input_einheit);
//            holder.preis = (EditText)convertView.findViewById(R.id.input_preis);
//            holder.kommentar = (EditText)convertView.findViewById(R.id.input_kommentar);
            convertView.setTag(holder);
        }else{
            holder = (ArtikelListAdapter.ViewHolder)convertView.getTag();
        }
        artikel = (Article)getItem(position);
        holder.artikel_view.setText("Name " + artikel.getArticleName() + "    Anzahl " + artikel.getArticleAmount());
//        holder.anzahl.setText(artikel.getAnzahl());
        return convertView;
    }

    // Innere Klasse
    static class ViewHolder{
        TextView artikel_view;
 //       EditText anzahl;
 //       EditText einheit;
 //       EditText preis;
 //       EditText kommentar;
    }
}
