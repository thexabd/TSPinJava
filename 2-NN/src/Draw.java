
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Draw {
    public Draw(ArrayList<Point2D> result){
        int i;
        double[] xData = new double[result.size()+1];
        double[] yData = new double[result.size()+1];


        for ( i = 0; i < result.size(); i++) {
            xData[i] = result.get(i).getX();
            yData[i] = result.get(i).getY();
        }
        xData[i] = result.get(0).getX();
        yData[i] = result.get(0).getY();


        // Create line chart using XChart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("2-opt for TSP").xAxisTitle("X").yAxisTitle("Y").build();
        XYSeries series = chart.addSeries("Coordinates", xData, yData);
        series.setMarker(SeriesMarkers.CIRCLE);
        series.setMarkerColor(Color.RED);
        series.setLineColor(Color.BLACK);
        series.setLineWidth(3);
        chart.getStyler().setMarkerSize(10);


        // Show the chart
        new SwingWrapper<>(chart).displayChart();

    }
}
