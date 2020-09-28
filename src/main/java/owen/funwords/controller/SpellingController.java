/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.funwords.controller;

import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import owen.funwords.App;
import owen.funwords.model.Word;
import owen.funwords.model.WordBank;

/**
 *
 * @author owen
 */
public class SpellingController implements Initializable{
    
    
    private int wordIndex = -1;
    
    @FXML
    private JFXButton showWordButton;

    @FXML
    private JFXButton nextWordButton;

    @FXML
    private JFXButton previousWordButton;

    @FXML
    private ImageView picture;

    @FXML
    private Text word;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        changeWord();
    }
    

    @FXML
    private void nextWord(MouseEvent event) throws FileNotFoundException {
        wordIndex++;
        changeWord();
    }

    @FXML
    private void previousWord(MouseEvent event) throws FileNotFoundException {
        wordIndex--;
        changeWord();
    }

    @FXML
    private void showWord(MouseEvent event) {
        var task = getTask();
        word.setText(task.getWord().toUpperCase());
        word.setVisible(true);
    }
    
    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("landing");
    }
    
    private void changeWord() {
        var task = getTask();
        try {
            picture.setImage(new Image(new FileInputStream(task.getImage())));
            word.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpellingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Word getTask() {
        var words = WordBank.words();
        if(wordIndex == words.size()) 
            wordIndex = words.size() - 1;
        else if(wordIndex < 0)
            wordIndex = 0;
        return words.get(wordIndex);
    }
    
}
