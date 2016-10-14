/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

package edu.cwru.sicu_sms.dialog;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This controller handles dialog-related events.
 *
 * @since October 13, 2016
 * @author Ted Frohlich <ttf10@case.edu>
 * @author Abby Walker <amw138@case.edu>
 */
public class DialogController {
    
    @FXML private Button cancelButton;
    
    @FXML
    private void cancel() {
        Stage dialog = (Stage) cancelButton.getScene().getWindow();
        dialog.close();
    }
    
    @FXML
    private void exit() {
        Platform.exit();
    }
    
}
