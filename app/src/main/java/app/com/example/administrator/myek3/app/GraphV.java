package app.com.example.administrator.myek3.app;

/**
 * Created by Khan on 07.03.2017.
 */

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import static app.com.example.administrator.myek3.app.R.color.colorPrimary;


public class GraphV extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grap_view);


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
}






