/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owen
 */
public class Decryptor {
    private static final String DataFilePath = "C:\\Users\\Owen\\Documents\\GitHub\\CryptoPractice\\data" + "\\letter_frequency_basic.txt";
    
    public List<String> SingleByteDecryptor(String encrypted){
        List<String> possibilities = new ArrayList<>();
        CharacterFrequencies frequencies = new CharacterFrequencies(encrypted);
        DataFileReader reader;
        try {
            reader = new DataFileReader(DataFilePath);
        } catch (IOException ex) {
            Logger.getLogger(Decryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return possibilities;
        
    }
}
