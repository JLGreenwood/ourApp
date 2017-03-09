package app.com.example.administrator.myek3.app;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import static app.com.example.administrator.myek3.app.R.color.colorPrimary;


public class GraphV extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GraphView graph = (GraphView) findViewById(R.id.action_graph);
        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 41),
                new DataPoint(1, 33),
                new DataPoint(2, 89),
                new DataPoint(3, 90),
                new DataPoint(4, 80),
                new DataPoint(5, 34),
                new DataPoint(6, 62),
                new DataPoint(7, 92),

                // Datapoint einträge
        });
        graph.addSeries(series2);
        series2.setShape(PointsGraphSeries.Shape.POINT);
        series2.setColor(colorPrimary);


        GraphView graphview = (GraphView) findViewById(R.id.action_graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDatapoint());
        graphview.addSeries(series);

        graphview.setTitle("EK-Listen");
        graphview.setTitleTextSize(40);
        graphview.getLegendRenderer().setVisible(false);
        graphview.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.MIDDLE);
        GridLabelRenderer gridLabel = graphview.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Listen Nummer");
        // custom label formatter to show currency "EUR"
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + " €";
                }
            }
        });

        graph.getViewport().setMinY(1);
        graph.getViewport().setMaxY(100);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        // customize a little bit viewport
        // activate horizontal zooming and scrolling
        graphview.getViewport().setScalable(true);

        // activate horizontal scrolling
        graphview.getViewport().setScrollable(true);

        // activate horizontal and vertical zooming and scrolling
        graphview.getViewport().setScalableY(true);

        // activate vertical scrolling
        graphview.getViewport().setScrollableY(true);


        // set manual X bounds
        graphview.getViewport().setXAxisBoundsManual(true);
        graphview.getViewport().setMinX(0);

        // set manual Y bounds
        graphview.getViewport().setYAxisBoundsManual(true);
        graphview.getViewport().setMinY(0);


    }

    private DataPoint[] getDatapoint() {


        DataPoint[] dp = new DataPoint[]{
                new DataPoint(0, 41),
                new DataPoint(1, 33),
                new DataPoint(2, 89),
                new DataPoint(3, 90),
                new DataPoint(4, 80),
                new DataPoint(5, 34),
                new DataPoint(6, 62),
                new DataPoint(7, 92),
        };
        return (dp);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ekl) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_liste) {
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_statistik) {
            Intent intent = new Intent (this, GraphV.class );
            startActivity(intent);
        } else if (id == R.id.nav_tut) {
            Session mysession = new Session(this);
            mysession.setFirstTimeLaunch(true);
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        // } else if (id == R.id.nav_imp) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}






