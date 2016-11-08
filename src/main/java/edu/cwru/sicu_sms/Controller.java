/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

package edu.cwru.sicu_sms;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * The controller for the front-end program.
 *
 * @since October 13, 2016
 * @author Ted Frohlich <ttf10@case.edu>
 * @author Abby Walker <amw138@case.edu>
 */
public class Controller {
    
    @FXML private ToggleButton recordButton;
    
    private boolean isRecording;
    
    public Controller() {
        isRecording = false;
    }
    
    @FXML
    private void confirmExit() throws Exception {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("dialog/exit_dialog.fxml")
        )));
        dialog.show();
    }
    
    @FXML
    private void onMouseEnteredRecordButton() {
        recordButton.setOnMouseEntered(event ->
                recordButton.setText((isRecording ? "Stop" : "Start") + " Recording")
        );
    }
    
    @FXML
    private void onMouseExitedRecordButton() {
        recordButton.setOnMouseExited(event ->
                recordButton.setText("Record" + (isRecording ? "ing..." : ""))
        );
    }
    
    @FXML
    private void record() {
        if (isRecording) {  // stop recording...
            //TODO
            isRecording = false;
            recordButton.setText("Start Recording");
        }
        else {  // start recording...
            //TODO
            isRecording = true;
            recordButton.setText("Stop Recording");
        }
    }
    
    
    /**
     * A controller for the EEG tab.
     */
    private class EEGController {
    
        @FXML private LineChart<String, Number>
                leftRostralChart, rightRostralChart,
                leftCaudalChart,  rightCaudalChart;
    
        private CategoryAxis xAxis;
        private NumberAxis yAxis;
        private ObservableList<String> xAxisCategories;
        
        private LineChart.Series<String, Number>[] electrodes;
        
        private ObservableList<LineChart.Data<String, Number>>
                leftRostralList, rightRostralList,
                leftCaudalList,  rightCaudalList;
    
        private int lastObservedChangelistSize, changesBeforeUpdate = 10;
        private Task<Date> chartUpdateTask;
    
        private EEGController() {
            initObservableLists();
            getObservableLists().forEach(list ->
                    list.addListener(dataListChangeListener()));
            
            initAxes();
            xAxis.setCategories(xAxisCategories);
//            xAxis.setAutoRanging(false);
            
            //TODO: instantiate and add data series
            
            initChartUpdateTask();
            Executors.newSingleThreadExecutor().submit(chartUpdateTask);
        }
        
        private void initAxes() {
            xAxis = new CategoryAxis();     yAxis = new NumberAxis();
            xAxis.setLabel("Time (sec)");   yAxis.setLabel("Relative Amplitude");
        }
        
        private void initChartUpdateTask() {
            chartUpdateTask = new Task<Date>() {
                @Override
                protected Date call() throws Exception {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                            Thread.currentThread().interrupt();
                        }
                        if (isCancelled()) break;
                        updateValue(new Date());
                    }
                    return new Date();
                }
            };
            chartUpdateTask.valueProperty().addListener(new ChangeListener<Date>() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  //TODO: eventually just want seconds
                Random random = new Random();
                @Override
                public void changed(ObservableValue<? extends Date> observableDate, Date oldDate, Date newDate) {
                    String strDate = dateFormat.format(newDate);
                    xAxisCategories.add(strDate);
                    getObservableLists().forEach(list ->
                            list.add(new LineChart.Data(strDate, newDate.getMinutes() + random.nextInt(100500))));
                }
            });
        }
        
        private void initObservableLists() {
            leftRostralList = rightRostralList = leftCaudalList = rightCaudalList
                    = FXCollections.observableArrayList();
            xAxisCategories
                    = FXCollections.observableArrayList();
        }
        
        private List<LineChart<String, Number>> getCharts() {
            List<LineChart<String, Number>> charts = Collections.emptyList();
            charts.add(leftRostralChart);   charts.add(rightRostralChart);
            charts.add(leftCaudalChart);    charts.add(rightCaudalChart);
            return charts;
        }
    
        private List<ObservableList<LineChart.Data<String, Number>>> getObservableLists() {
            List<ObservableList<LineChart.Data<String, Number>>> lists = Collections.emptyList();
            lists.add(leftRostralList);   lists.add(rightRostralList);
            lists.add(leftCaudalList);    lists.add(rightCaudalList);
            return lists;
        }
        
        private ListChangeListener<LineChart.Data<String, Number>> dataListChangeListener() {
            return change -> {
                if (change.getList().size() - lastObservedChangelistSize > changesBeforeUpdate) {
                    lastObservedChangelistSize += changesBeforeUpdate;
                    xAxis.getCategories().remove(0, changesBeforeUpdate);
                }
            };
        }
        
    }
    
    
    /**
     * A controller for the EKG tab.
     */
    private class EKGController {
        
        //TODO:
        
    }
    
}
