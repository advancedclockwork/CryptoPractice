/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Owen
 */
public class Decryptor {
    private static int threshold = 5;
    private static final String DATAFILEPATH = "C:\\Users\\Owen\\Documents\\GitHub\\CryptoPractice\\data";
    private static final String LETTERFREQUENCYFILEPATH =  DATAFILEPATH + "\\letter_frequency_basic.txt";
    private static final String DICTIONARYFILEPATH = DATAFILEPATH + "\\words.txt";
    List<possibleString> possibilities;
    public Decryptor(String encrypted) throws DecoderException{
        possibilities = new ArrayList<>();
        CharacterFrequencies frequencies = new CharacterFrequencies(encrypted);
        DataFileReader reader = null;
        try {
            reader = new DataFileReader(LETTERFREQUENCYFILEPATH);
        } catch (IOException ex) {
            Logger.getLogger(Decryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> mostFrequentRead = frequencies.getAllFrequencies();
        List<String> mostFrequentExpected = reader.getData();
        char[] message = encrypted.toCharArray();
        byte[] hex = Hex.decodeHex(message);
        for(int i = 0; i < mostFrequentExpected.size() && i < threshold; i++){
            for (int k = 0; k < mostFrequentRead.size() && k < threshold; k++){
                byte[] result = new byte[hex.length];
                char compareTo = mostFrequentRead.get(mostFrequentRead.size() - 1 - k).charAt(0);
                char original = mostFrequentExpected.get(mostFrequentExpected.size() - 1 - i).charAt(0);
                int difference = original ^ compareTo;
                System.out.println("char to compare: " + compareTo + " original char: " + original + " difference: " + (char)difference);
                for(int j = 0; j<hex.length; j++){
                    result[j] = (byte) (difference ^ hex[j]);
                }
                String decrypted = new String(result);
                String[] possibleWords = decrypted.split(" ");
                int words = 0;
                for(int j = 0; j < possibleWords.length; j++){
                    if (CommonWordConfirmer.check_for_word(possibleWords[j],DICTIONARYFILEPATH))
                        words++;
                }
                possibleString newString = new possibleString(decrypted, words);
                possibilities.add(newString);
            }
        }
        possibilities.sort(Comparator.comparing(possibleString::getNumberOfWords));
    }
    
    public String getMostPossible(){
        return possibilities.get(possibilities.size()-1).getPossible();
    }
    
    public int getMostPossibleNumOfWords(){
        return possibilities.get(possibilities.size()-1).getNumberOfWords();
    }
    
    private class possibleString{
        String possible;
        int numberOfWords;
        private possibleString(String possible, int numberOfWords){
            this.possible = possible;
            this.numberOfWords = numberOfWords;
        }
        
        public String getPossible(){
            return possible;
        }
        
        public int getNumberOfWords(){
            return numberOfWords;
        }
    }
}
