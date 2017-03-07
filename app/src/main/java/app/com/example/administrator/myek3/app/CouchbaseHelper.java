package app.com.example.administrator.myek3.app;

import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CouchbaseHelper {

    Manager manager = null;
    Database database = null;
    android.content.Context ctx = null;

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Default constructor. Generates an instance of the database manager within the context of
     * our application. This manager will handle all queries to the database and needs to be setup
     * first.
     * @param ctx
     */
    public CouchbaseHelper(android.content.Context ctx) {
        Log.d(TAG, "Database constructor called.");
        try {
            manager = new Manager(new AndroidContext(ctx), Manager.DEFAULT_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createCouchbaseDatabase();
    }

    /**
     * Creating a database if it does not exist yet.
     */
    private void createCouchbaseDatabase() {

        String databaseName = "shoppinglist";

        Log.d(TAG, "Create database method called.");
        // Create or open the database named app.
        try {
            database = manager.getDatabase(databaseName);
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is an example of how to insert a single document. Probably we will be inserting
     * complete shopping lists instead of articles so this needs to be adjusted.
     */
    public void createArticle() {
        Log.d(TAG, "Create article method called.");
        // The properties that will be saved on the document
        Map<String, Object> properties = new HashMap<>();
        properties.put("title", "Couchbase Mobile");
        properties.put("sdk", "Java");
        // Create a new document
        Document document = database.createDocument();
        // Save the document to the database.
        try {
            document.putProperties(properties);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG, "Error while putting properties.");
            e.printStackTrace();
        }
        // Log the document ID (generated by the database).
        Log.d(TAG, String.format("Document ID: %s", document.getId()));
    }

    public void addShoppingList(ShoppingList shoppingList) {
        Log.d(TAG, "addShoppingList method called.");
        // The properties that will be saved on the document.
        Map<String, Object> properties = new HashMap<>();
        properties.put(shoppingList.getShoppingListName(), shoppingList);
        // Create a new document.
        Document document = database.createDocument();
        // Save the document to the database.
        try {
            document.putProperties(properties);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG, "Error while putting properties.");
            e.printStackTrace();
        }
        // Log the document ID (generated by the database).
        Log.d(TAG, String.format("Document ID: %s", document.getId()));
    }

    /**
     * This is an example on how to work on all existing documents which might be interesting
     * when working operations on the whole collection.
     */
    public void getAllDocuments() {
        // Let's find all documents and print them to the console.
        Query query = database.createAllDocumentsQuery();
        query.setAllDocsMode(Query.AllDocsMode.ALL_DOCS);
        QueryEnumerator result = null;
        try {
            result = query.run();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
        for (Iterator<QueryRow> it = result; it.hasNext(); ) {
            QueryRow row = it.next();
            Log.d(TAG, String.format("%s. document: %s", row.getSequenceNumber(), row.getDocumentId()));

            if(row.getDocumentId() != null) {
                Document doc = database.getDocument(row.getDocumentId());
                // We can directly access properties from the document object.
                Log.d(TAG, "Print object by property: " + doc.getProperty("BananaList001"));

                Map<String, Object> testObject = (Map<String, Object>) doc.getProperty("BananaList001");
                Iterator iterator = testObject.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry)iterator.next();
                    Log.d(TAG, "Print key = value: " + pair.getKey() + " = " + pair.getValue());
                    iterator.remove(); // avoids a ConcurrentModificationException
                    if (pair.getKey() == "listenArtikel") {
                        Log.d(TAG, "Found articleList: " + pair.getValue());
                        Log.d(TAG, "Found articleList: " + pair.getValue().getClass());

//                        List<Object> articleList = (ArrayList) pair.getValue();
                        for (Object temp : (ArrayList)pair.getValue()) {
                            Log.d(TAG, "Article: " + temp);
                            Log.d(TAG, "Article toString(): " + temp.toString());
                            Log.d(TAG, "Article getClass(): " + temp.getClass());
                        }
                    }
                }
            }
        }
    }
}
