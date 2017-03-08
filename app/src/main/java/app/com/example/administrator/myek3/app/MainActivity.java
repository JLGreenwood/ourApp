package app.com.example.administrator.myek3.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.Paint;
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
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    String listViewSwitch = "";

    List<Article> articleList;
    ArticleAdapter articleAdapter;


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
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        articleName.setTypeface(typeface);
        articleAmount = (EditText) findViewById(R.id.input_anzahl);
        articleAmount.setTypeface(typeface);

        switchListViewToArticles();
        registerForContextMenu(listView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (articleName.getText().length() > 0) {
                articleAmount.requestFocus();
                String amount = articleAmount.getText().toString();
                if (amount.equals("") || amount.equals("0")) {
                    amount = "1";
                }
                articleList.add(new Article(articleName.getText().toString(), amount , false));
                articleAdapter.notifyDataSetChanged();
            }
            articleName.setText("");
            articleAmount.setText("");
            articleName.requestFocus();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article art = articleList.get(position);
                if (art.isArticleChecked()) {
                    art.setArticleChecked(false);
                    articleAdapter.notifyDataSetChanged();
                }
                else {
                    art.setArticleChecked(true);
                    articleAdapter.notifyDataSetChanged();
                }
            }
        });

        /**
         * Initialize an instance of our databaseHelper class and call our methods.
         */
        CouchbaseHelper couchbaseHelper = new CouchbaseHelper(this);
//       couchbaseHelper.createArticle();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

//        Article article1 = new Article("Worst", "10");
//        Article article2 = new Article("Brot", "5");
//        Article article3 = new Article("Rose", "1");
//
//        articleList.add(article1);
//        articleList.add(article2);
//        articleList.add(article3);
//
//        shoppingList = new ShoppingList("BananaList001", articleList);

//        couchbaseHelper.addShoppingList(shoppingList);
//        couchbaseHelper.getAllDocuments();
    }


    // LONGP PRESURE GESTURE  // LONGP PRESURE GESTURE  // LONGP PRESURE GESTURE

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.delete_id:
                articleList.remove(info.position);
                articleAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }
 // END LONGP PRESURE GESTURE  // END LONGP PRESURE GESTURE // END LONGP PRESURE GESTURE


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

        if (id == R.id.nav_ekl) {

        } else if (id == R.id.nav_liste) {
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_statistik) {
      //      Intent intent = new Intent (this, GraphView.class );
      //      startActivity(intent);
        } else if (id == R.id.nav_tut) {
            Session mysession = new Session(this);
            mysession.setFirstTimeLaunch(true);
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_imp) {

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

    public void switchListViewToArticles () {
//        if (!articleList.isEmpty()){
//            articleList.clear();
//            articleAdapter.notifyDataSetChanged();
//        }
        articleName.setVisibility(View.VISIBLE);
        articleAmount.setVisibility(View.VISIBLE);
        articleList = new ArrayList<Article>();
        articleAdapter = new ArticleAdapter(articleList, this);
        listView.setAdapter(articleAdapter);
    }
}
