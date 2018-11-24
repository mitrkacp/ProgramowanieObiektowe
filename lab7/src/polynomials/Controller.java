package polynomials;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class Controller{

    private float params[];
    @FXML private TextField input;
    @FXML private TextField from;
    @FXML private TextField to;
    @FXML private TextField probe;
    @FXML private LineChart<?,?> chart;
    XYChart.Series series;


    @FXML public void draw(){
        chart.getData().clear();
        series = new XYChart.Series();
        int probe_ = Integer.parseInt(probe.getText());

        String expression = input.getText();
        String[] splitted = expression.split(";");
        params = new float[splitted.length];
        for(int i = 0 ; i < splitted.length; i++){
            params[i] = (Float.parseFloat(splitted[i]));
        }

        for (int x = Integer.parseInt(from.getText()); x <= Integer.parseInt(to.getText()); x = x + probe_) {
            series.getData().add(new XYChart.Data(x, function(x)));
        }
        chart.getData().add(series);
    }

    private float function(int x){
        float result = params[0];
        for(int i=1;i<params.length;i++){
            result = result * x + params[i];
        }
        return result;
    }
}
