/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Owen
 */
public class DataFileReader{

    File file;
    private final List<character> charData;
    
    public DataFileReader(String fileLocation) throws IOException{
        File file = new File(fileLocation);
        charData = new ArrayList<character>();
        
        DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        while(stream.available()>0){
            String temp = "";
            charData.add(new character(temp + stream.readChar(),stream.readDouble()));
        }
        stream.close();
        charData.sort(Comparator.comparing(character::getRate));
    }
    
    public List<String> getData(){
        List<String> toReturn = new ArrayList<String>();
        for(int i = 0; i < charData.size(); i++){
            toReturn.add(charData.get(i).getCharacter());
        }
        return toReturn;
    }
    
    private class character{
        private final String character = null;
        private final Double rate = null;
        public character(String character, Double rate){
            character = this.character;
            rate = this.rate;
        }
        
        public String getCharacter(){
            return character;
        }
        
        public Double getRate(){
            return rate;
        }
    }
}
