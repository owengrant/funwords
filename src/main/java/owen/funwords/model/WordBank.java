/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.funwords.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
                            var name = wordFile.getName();
                            if(name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                                word.setWord(wordFile.getName());
                                word.setImage(wordFile);
                            } else if(name.endsWith(".mp3")) 
                                word.setSpelling(wordFile);
                        });
                        words.add(word);
                    });
            
        }).start();
    }
    
    public static List<Word> words() {
        return words;
    }
}
