package app.com.example.administrator.myek3.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemLongClickListener{

    DatabaseHelper myDB;
    EditText articleName;
    EditText articleAmount;
    ListView artikel_liste_view;
    List<Article> articleList;
    ArtikelListAdapter adapter;
    FloatingActionButton fab;

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
        articleName = (EditText) findViewById(R.id.input_artikel);
        articleAmount = (EditText) findViewById(R.id.input_anzahl);

        articleList = new ArrayList<Article>();
        adapter = new ArtikelListAdapter(articleList, this);
        artikel_liste_view = (ListView) findViewById(R.id.eklist);
        artikel_liste_view.setAdapter(adapter);
        artikel_liste_view.setOnItemLongClickListener(this);

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
                    if(amount.equals("") || amount.equals("0")){
                       amount = "1";
                    }
                    articleList.add(new Article(articleName.getText().toString(), amount , false));

                    adapter.notifyDataSetChanged();
                    Snackbar.make(view, "Replace with your own action!! " + amount, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                articleName.setText("");
                articleAmount.setText("");
                articleName.requestFocus();
            }
        });

        /**
         * Initialize an instance of our databaseHelper class and call our methods.
         */
        CouchbaseHelper couchbaseHelper = new CouchbaseHelper(this);
        couchbaseHelper.createArticle();
        couchbaseHelper.getAllDocuments();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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



    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = (int) info.id;

        switch (item.getItemId()) {

            case R.id.context_delete:
                this.articleList.remove(position);
                this.adapter.notifyDataSetChanged();
                break;
            case R.id.context_edit:

                createEditDialog(articleList.get(position));
                break;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        view.getContext();
        registerForContextMenu(artikel_liste_view);

        Toast.makeText(MainActivity.this, articleList.get(position).getArticleName(),Toast.LENGTH_SHORT).show();
        //createEditDialog(articleList.get(position));
        return false;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    public void createEditDialog(final Article arti) {

        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View dialogView = li.inflate(R.layout.edit_dialog_layout, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setView(dialogView);

        final EditText inputText1 = (EditText) dialogView.findViewById(R.id.edit_name_input);
        final EditText inputText2 = (EditText) dialogView.findViewById(R.id.edit_amount_input);
        final EditText inputText3 = (EditText) dialogView.findViewById(R.id.edit_price_input);
        final EditText inputText4 = (EditText) dialogView.findViewById(R.id.edit_unit_input);
        final EditText inputText5 = (EditText) dialogView.findViewById(R.id.edit_comment_input);
        final CheckBox isSelected = (CheckBox) dialogView.findViewById(R.id.cancel_action);
        inputText1.setText(arti.getArticleName());
        inputText2.setText(arti.getArticleAmount());
        inputText3.setText(CheckData.checkNumberIsEmpty(""+arti.getArticlePrice()));
        inputText4.setText(arti.getArticleUnit());
        inputText5.setText(arti.getArticleComment());
        isSelected.setActivated(arti.isArticleChecked());


        final TextView dialogMessage = (TextView) dialogView.findViewById(R.id.edit_dialog_message);

        alertDialogBuilder
                .setCancelable(true)
                .setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                arti.setArticleName(inputText1.getText().toString());
                                arti.setArticleAmount(inputText2.getText().toString());
                                if(inputText3.getText().toString().equals("")){
                                    arti.setArticlePrice(0);
                                }else{
                                    arti.setArticlePrice(CheckData.formatData(Double.parseDouble(inputText3.getText().toString())));
                                }

                                arti.setArticleUnit(inputText4.getText().toString());
                                arti.setArticleComment(inputText4.getText().toString());
                                arti.setArticleChecked(isSelected.isChecked());
                                adapter.notifyDataSetChanged();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        final AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
