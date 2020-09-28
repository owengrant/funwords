/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.funwords.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import owen.funwords.App;

/**
 *
 * @author owen
 */
public class LandingController {
    
    
    @FXML
    private void toStudentView(MouseEvent event) throws IOException {
       App.setRoot("spelling");
    }

    @FXML
    private void toTeaherView(MouseEvent event) throws IOException {
        App.setRoot("teacher");
    }
    
}
