/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Owen
 */
public class CharacterFrequencies {
    
    private final List<character> characters = new ArrayList<>();
    private final String message;
    
    public CharacterFrequencies(String message) throws DecoderException{
        this.message = message;
        createList();
    }
    
    private void createList() throws DecoderException{
        for(int i = 0; i < message.length(); i += 2){
            byte[] temp = Hex.decodeHex("" + message.charAt( i) + message.charAt(i+1));
            String current = new String(temp);
            boolean newEntry = true;
            if(characters.isEmpty()){
                character entry = new character(current);
                characters.add(entry);
            }
            else{
                for(int j = 0; j < characters.size(); j++){
                    if(characters.get(j).getCharacter().equals(current)){
                        characters.get(j).increaseFrequency();
                        newEntry = false;
                        break;
                    }
                }
                if(newEntry){
                    character entry = new character(current);
                    characters.add(entry);
                }
            }

        }
        characters.sort(Comparator.comparing(character::getFrequency));
        //for(int i = 0; i < characters.size(); i++ ){
        //    System.out.println("character: " + characters.get(i).getCharacter() + " frequency: " + characters.get(i).getFrequency());
        //}
    }
    
    public String getMostFrequent(){
        return characters.get(0).getCharacter();
    }
    
    public List<String> getAllFrequencies(){
        List<String> toReturn = new ArrayList<>();
        for(int i = 0; i < characters.size(); i++){
            toReturn.add(characters.get(i).getCharacter());
        }
        return toReturn;
    }
    
    public class character{
        private String character = "";
        private int frequency;
        
        public character(String character){
            this.character = character;
            frequency = 1;
        }
        
        public void increaseFrequency(){
            frequency++;
        }
        
        public int getFrequency(){
            return frequency;
        }
        
        public String getCharacter(){
            return character;
        }
    }
}
