/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Owen
 */
public class CharacterFrequencies {
    
    private List<character> characters = new ArrayList<character>();
    private String message;
    public CharacterFrequencies(String message){
        message = this.message;
        createList();
    }
    
    private void createList(){
        for(int i = 0; i < message.length(); i++){
            String current = message.charAt(i) + "";
            boolean newEntry = true;
            for(int j = 0; j < characters.size(); j++){
                if(characters.get(j).getCharacter().equals(current)){
                    characters.get(j).increaseFrequency();
                    newEntry = false;
                    break;
                }
            }
            if(newEntry){
                characters.add(new character(current));
            }
        }
        characters.sort(Comparator.comparing(character::getFrequency));
    }
    
    public String getMostFrequent(){
        return characters.get(0).getCharacter();
    }
    
    public List<String> getAllFrequencies(){
        List<String> toReturn = new ArrayList<String>();
        for(int i = 0; i < characters.size(); i++){
            toReturn.add(characters.get(i).getCharacter());
        }
        return toReturn;
    }
    
    private class character{
        String character;
        int frequency;
        public character(String character){
            character = this.character;
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
