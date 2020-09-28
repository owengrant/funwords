/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.funwords.model;

import java.io.File;

/**
 *
 * @author owen
 */
public class Word {
    private File image;
    private File spelling;
    private String word;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public File getSpelling() {
        return spelling;
    }

    public void setSpelling(File spelling) {
        this.spelling = spelling;
    }

    
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word.substring(0, word.indexOf("."));
    }
    
    
}
