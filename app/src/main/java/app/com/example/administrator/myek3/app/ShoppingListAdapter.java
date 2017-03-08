package app.com.example.administrator.myek3.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jabba the Hutt on 06.03.2017.
 */

public class ShoppingListAdapter extends BaseAdapter{

    // Attribute
    private ShoppingList shoppingList;
    private final List<ShoppingList> shoppingListList;
    private final LayoutInflater inflater;

    // Konstruktoren
    public ShoppingListAdapter(List<ShoppingList> shoppingListList, Context context){
        this.shoppingListList = shoppingListList;
        inflater = LayoutInflater.from(context);
    }

    // Getter()/Setter()
    @Override
    public int getCount() {
        return this.shoppingListList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.shoppingListList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ShoppingListAdapter.ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_eklise, parent, false);
            holder = new ShoppingListAdapter.ViewHolder();
            holder.shoppingListView = (TextView) convertView.findViewById(R.id.list_item_ekliste_textview);
            convertView.setTag(holder);
        }else{
            holder = (ShoppingListAdapter.ViewHolder)convertView.getTag();
        }
        shoppingList = (ShoppingList)getItem(position);
//        holder.shoppingListView.setText(shoppingList.getShoppingListName() + shoppingList.getShoppingListArticleCount());
        holder.shoppingListView.setText(shoppingList.getShoppingListName());
        return convertView;
    }

    // Innere Klasse.
    static class ViewHolder{
        TextView shoppingListView;
    }
}
