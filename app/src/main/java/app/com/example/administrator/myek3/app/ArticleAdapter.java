package app.com.example.administrator.myek3.app;

import android.content.Context;
import android.graphics.Paint;
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

public class ArticleAdapter extends BaseAdapter{

    // Attribute
    private Article article;
    private final List<Article> articleList;
    private final LayoutInflater inflater;

    // Konstruktoren
    public ArticleAdapter(List<Article> articleList, Context context){
        this.articleList = articleList;
        inflater = LayoutInflater.from(context);

    }

    // Getter()/Setter()
    @Override
    public int getCount() {
        return this.articleList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.articleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ArticleAdapter.ViewHolder holder;

       if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_eklise, parent, false);
            holder = new ArticleAdapter.ViewHolder();
            holder.articleView = (TextView) convertView.findViewById(R.id.list_item_ekliste_textview);
            convertView.setTag(holder);
        } else {
            holder = (ArticleAdapter.ViewHolder)convertView.getTag();
        }
        article = (Article)getItem(position);

        holder.articleView.setText("" + article.getArticleName() + " (" + article.getArticleAmount() + ")");
        holder.a = article.isArticleChecked();

        if (this.articleList.get(position).isArticleChecked()) {
            holder.articleView.setPaintFlags(holder.articleView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else {
            holder.articleView.setPaintFlags(0);

        }


        holder.articleView.setText(" " + article.getArticleAmount() + " " + "" + article.getArticleName() );
        return convertView;

    }

    // Innere Klasse.
    static class ViewHolder{
        TextView articleView;
        boolean a ;

    }
}
