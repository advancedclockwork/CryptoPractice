/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private final List<Character> charData;
    
    public DataFileReader(String fileLocation) throws IOException{
        File file = new File(fileLocation);
        charData = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp;
            while((temp = br.readLine()) != null){
                String[] strings = temp.split(" ");
                //System.out.println("char: " + strings[0] + " rate: " + strings[1]);
                Character current = new Character(strings[0], Double.parseDouble(strings[1]));
                charData.add(current);
            }
        }
        charData.sort(Comparator.comparing(Character::getRate));
    }
    
    public List<String> getData(){
        List<String> toReturn = new ArrayList<>();
        for(int i = 0; i < charData.size(); i++){
            toReturn.add(charData.get(i).getCharacter());
        }
        return toReturn;
    }
    
    private class Character{
        private String character = null;
        private Double rate = null;
        public Character(String character, Double rate){
            this.character = character;
            this.rate = rate;
        }
        
        public String getCharacter(){
            return character;
        }
        
        public Double getRate(){
            return rate;
        }
    }
}
