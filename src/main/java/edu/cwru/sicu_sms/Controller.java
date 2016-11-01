/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

package edu.cwru.sicu_sms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    
}
