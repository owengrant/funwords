/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.funwords.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author owen
 */
public class WordBank {
    private static List<Word> words = new ArrayList<>();
    
    public static void loadBank(String bankFolder){
        new Thread(() -> {
            var folder = new File(bankFolder);
            Stream.of(folder.listFiles())
                    .forEach(wordFolder -> {
                        var word = new Word();
                        Stream.of(wordFolder.listFiles()).forEach(wordFile -> {
                            if(wordFile.getName().endsWith(".png") || wordFile.getName().endsWith(".jpg") || wordFile.getName().endsWith(".jpeg")) {
                                word.setWord(wordFile.getName());
                                word.setImage(wordFile);
                                words.add(word);
                            }
                        });
                    });
            
        }).start();
    }
    
    public static List<Word> words() {
        return words;
    }
}
