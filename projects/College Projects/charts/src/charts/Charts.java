/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Aboahmed
 */
public class Charts extends Application{

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
 
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample"); // set window name
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary"); // set upper name
        xAxis.setLabel("Country");        // set x-axis name
        yAxis.setLabel("Value");         // set y-axis name
 
        
        
        XYChart.Series chartSeries = new XYChart.Series();
        chartSeries.setName("2005");  // set the name of the chart
        chartSeries.getData().add(new XYChart.Data(austria, 45000.65));
        chartSeries.getData().add(new XYChart.Data(brazil, 44835.76));
        chartSeries.getData().add(new XYChart.Data(france, 18722.18));
        chartSeries.getData().add(new XYChart.Data(italy, 17557.31));
        chartSeries.getData().add(new XYChart.Data(usa, 92633.68));  
        
        Scene scene  = new Scene(bc,400,300);
        bc.getData().addAll( chartSeries);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
 launch(args);
    }

  
}
