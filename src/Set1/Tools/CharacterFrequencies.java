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
    
    private final List<character> characters = new ArrayList<>();
    private final String message;
    
    public CharacterFrequencies(String message){
        this.message = message;
        createList();
    }
    
    private void createList(){
        for(int i = 0; i < message.length(); i++){
            String current = "" + message.charAt(i);
            System.out.println("current: " + current);
            /*boolean newEntry = true;
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
*/
        }
        //characters.sort(Comparator.comparing(character::getFrequency));
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
