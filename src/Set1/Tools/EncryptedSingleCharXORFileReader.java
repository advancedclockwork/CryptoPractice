/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owen
 */
public class EncryptedSingleCharXORFileReader {
    private final List<String> encryptedLines;
    public EncryptedSingleCharXORFileReader(String filePath) throws FileNotFoundException, IOException{
        File file = new File(filePath);
        encryptedLines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String temp;
            while((temp = br.readLine()) != null){
               encryptedLines.add(temp); 
            }
        }
    }
    
    public List<String> getEncryptedLines(){
        return encryptedLines;
    }
}
