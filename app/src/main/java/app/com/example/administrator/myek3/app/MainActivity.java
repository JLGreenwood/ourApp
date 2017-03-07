package app.com.example.administrator.myek3.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText articleName;
    EditText articleAmount;

    FloatingActionButton fab;
    ListView listView;

    ShoppingList shoppingList;

    //    String listViewSwitch = "articles";
    //    String listViewSwitch = "shoppingLists";
    String listViewSwitch = "articles";

    List<Article> articleList;
    List<ShoppingList> shoppingListList;
    ArticleAdapter articleAdapter;
    ShoppingListAdapter shoppingListAdapter;


    private static final String TAG = MainActivity.class.getSimpleName();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.eklist);

        articleName = (EditText) findViewById(R.id.input_artikel);
        articleAmount = (EditText) findViewById(R.id.input_anzahl);

        switch (listViewSwitch) {
            case "articles":
                articleName.setVisibility(View.VISIBLE);
                articleAmount.setVisibility(View.VISIBLE);
                articleList = new ArrayList<Article>();
                articleAdapter = new ArticleAdapter(articleList, this);
                listView.setAdapter(articleAdapter);
                break;
            case "shoppingLists":
                articleName.setVisibility(View.INVISIBLE);
                articleAmount.setVisibility(View.INVISIBLE);
                shoppingListList = new ArrayList<ShoppingList>();
                shoppingListAdapter = new ShoppingListAdapter(shoppingListList, this);
                listView.setAdapter(shoppingListAdapter);

                ShoppingList unsavedShoppingList1 = new ShoppingList();
                ShoppingList unsavedShoppingList2 = new ShoppingList("Party");
                ShoppingList unsavedShoppingList3 = new ShoppingList("Kuchenrezept");
                ShoppingList unsavedShoppingList4 = new ShoppingList();

                shoppingListList.add(unsavedShoppingList1);
                shoppingListList.add(unsavedShoppingList2);
                shoppingListList.add(unsavedShoppingList3);
                shoppingListList.add(unsavedShoppingList4);

                shoppingListAdapter.notifyDataSetChanged();
                break;
        }
        registerForContextMenu(listView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (listViewSwitch) {
                    case "articles":
                        if (articleName.getText().length() > 0) {
                            articleAmount.requestFocus();
                            String amount = articleAmount.getText().toString();
                            if (amount.equals("") || amount.equals("0")) {
                                amount = "1";
                            }
                            articleList.add(new Article(articleName.getText().toString(), amount , false));

                            articleAdapter.notifyDataSetChanged();
                            Snackbar.make(view, "Replace with your own action!! " + amount, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                        articleName.setText("");
                        articleAmount.setText("");
                        articleName.requestFocus();
                        break;
                    case "shoppingLists":

                        break;
                }
            }
        });

        /**
         * Initialize an instance of our databaseHelper class and call our methods.
         */
        CouchbaseHelper couchbaseHelper = new CouchbaseHelper(this);
//        couchbaseHelper.createArticle();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        articleList = new ArrayList<Article>();

        Article article1 = new Article("Worst", "10");
        Article article2 = new Article("Brot", "5");
        Article article3 = new Article("Rose", "1");

        articleList.add(article1);
        articleList.add(article2);
        articleList.add(article3);

        shoppingList = new ShoppingList("BananaList001", (ArrayList<Article>) articleList);

        couchbaseHelper.addShoppingList(shoppingList);
//        couchbaseHelper.getAllDocuments();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_help) {

            Session mysession = new Session(this);
            mysession.setFirstTimeLaunch(true);
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
