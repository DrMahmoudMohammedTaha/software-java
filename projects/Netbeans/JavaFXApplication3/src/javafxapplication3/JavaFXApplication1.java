/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

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
public class JavaFXApplication1 extends Application {

    static Stage s1;
    static Scene se1;
    static BarChart<String, Number> bc1;
    public static String studentWork[];

    public static void shower() {

        
        bc1.getData().clear();
        XYChart.Series chartSeries = new XYChart.Series();
        for (int i = 0; i < studentWork.length; i++) {
            chartSeries.getData().add(new XYChart.Data(studentWork[i].split(" ")[0], studentWork[i].split(" ").length - 2));
        }

        bc1.getData().addAll(chartSeries);
        s1.show();
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Student work chart"); // set window name
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc
                = new BarChart<String, Number>(xAxis, yAxis);
        xAxis.setLabel("Student");        // set x-axis name
        yAxis.setLabel("Value");         // set y-axis name

        Scene scene = new Scene(bc, 400, 300);

        stage.setScene(scene);

        s1 = stage;

        bc1 = bc;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
