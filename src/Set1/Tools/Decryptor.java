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
    private static final String DATAFILEPATH = "C:\\Users\\Owen\\Documents\\GitHub\\CryptoPractice\\data";
    private static final String LETTERFREQUENCYFILEPATH =  DATAFILEPATH + "\\letter_frequency_basic.txt";
    private static final String DICTIONARYFILEPATH = DATAFILEPATH + "\\words.txt";
    List<possibleString> possibilities = new ArrayList<>();
    public Decryptor(String encrypted) throws DecoderException{
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
        
        for(int i = 0; i < mostFrequentExpected.size() || i < 10; i++){
            byte[] result = new byte[hex.length];
            char compareTo = mostFrequentRead.get(i).charAt(0);
            char original = mostFrequentExpected.get(i).charAt(0);
            int difference = original - compareTo;
            for(int j = 0; j<hex.length; j++){
                result[j] = (byte) (compareTo ^ hex[j]);
            }
            String decrypted = Arrays.toString(result);
            String[] possibleWords = decrypted.split(" ");
            CommonWordConfirmer checker = new CommonWordConfirmer();
            int words = 0;
            for(int j = 0; j<possibleWords.length; j++){
                if (CommonWordConfirmer.check_for_word(possibleWords[i],DICTIONARYFILEPATH))
                    words++;
            }
            possibilities.add(new possibleString(decrypted, words));
        }
        possibilities.sort(Comparator.comparing(possibleString::getNumberOfWords));
    }
    
    public String getMostPossible(){
        return possibilities.get(0).getPossible();
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
