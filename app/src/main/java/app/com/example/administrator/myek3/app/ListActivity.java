package app.com.example.administrator.myek3.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static app.com.example.administrator.myek3.app.R.id.fab;

public class ListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    FloatingActionButton fab;
    ListView listView;

    List<ShoppingList> shoppingListList;
    ShoppingListAdapter shoppingListAdapter;
    Map<String, String> superSecretList;

    Context ctx = null;
    private static final String TAG = ListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setTitle("Vorhandene Listen");

        ctx = getApplication();

        fab = (FloatingActionButton) findViewById(R.id.fab_list);
        listView = (ListView) findViewById(R.id.listlist);

        switchListViewToShoppingLists();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: Maybe do something on click?
                // Position equals indexes linke in an array.
                String uid = null;
                Log.d(TAG, "TEST: " + position);
                for (Map.Entry<String, String> entry : superSecretList.entrySet()) {
                    Log.d(TAG, "Key : " + entry.getKey() + " Value : " + entry.getValue());
                    if(Integer.toString(position) == entry.getKey()) {
                        uid = entry.getValue();
                    }
                }
                Log.d(TAG, "Uid: " + uid);
                Intent iActivity2 = new Intent(ctx, MainActivity.class);
                iActivity2.putExtra("uid", uid);
                startActivity(iActivity2);
            }
        });

        // Disabled because of unclear NullPointerException. Fix needed!!
        // registerForContextMenu(listView);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_list);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.list_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_list);
        navigationView.setNavigationItemSelectedListener(this);

            fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ctx, MainActivity.class );
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.list_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ekl_list) {
//            Intent i = new Intent(this, MainActivity.class);
//            startActivity(i);
            finish();
        } else if (id == R.id.nav_liste_list) {

        } else if (id == R.id.nav_stat_list) {
                 Intent intent = new Intent (this, GraphV.class );
                 startActivity(intent);
        } else if (id == R.id.nav_tut_list) {
            Session mysession = new Session(this);
            mysession.setFirstTimeLaunch(true);
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
//        } else if (id == R.id.nav_imp_list) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.list_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchListViewToShoppingLists() {
        Log.d(TAG, "Calling switchListViewToShoppingLists()");
        shoppingListList = new ArrayList<ShoppingList>();
        shoppingListAdapter = new ShoppingListAdapter(shoppingListList, this);
        listView.setAdapter(shoppingListAdapter);

        CouchbaseHelper cbh = new CouchbaseHelper(this);
        ArrayList<String> docIds = cbh.getAllDocumentIds();
        superSecretList = new HashMap<String, String>();

        for(int i = 0; i < docIds.size(); i++) {
            Log.d(TAG, "docId: " + docIds.get(i));
            shoppingListList.add(cbh.getShoppingListById(docIds.get(i)));
            Log.d(TAG, "shoppingListList.get(0): " + shoppingListList.get(0).getShoppingListId());
            superSecretList.put(Integer.toString(i), docIds.get(i));
        }
        shoppingListAdapter.notifyDataSetChanged();
    }

}
