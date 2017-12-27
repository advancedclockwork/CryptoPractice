/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1;

import Set1.Tools.Decryptor;
import Set1.Tools.EncryptedSingleCharXORFileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.codec.DecoderException;

/**
 *
 * @author Owen
 */
public class DetectSingleCharacterXOR {
    

    public static void main(String[] args)throws IOException, DecoderException {
        EncryptedSingleCharXORFileReader reader = new EncryptedSingleCharXORFileReader("C:\\Users\\Owen\\Documents\\GitHub\\CryptoPractice\\data\\encryptedLines.txt");
        List<String> encrypted = reader.getEncryptedLines();
        String mostPossible = "";
        int greatestWords = 0;
        int lineNumber = 0;
        for(int i = 0; i < encrypted.size(); i++){
            Decryptor decryptor = new Decryptor(encrypted.get(i));
            String tempString = decryptor.getMostPossible();
            int tempNum = decryptor.getMostPossibleNumOfWords();
            if (tempNum > greatestWords){
                greatestWords = tempNum;
                mostPossible = tempString;
                lineNumber = i+1;
            }
        }
        System.out.println("line: " + lineNumber);
        System.out.println("decrypted: " + mostPossible);
        System.out.println("number of words: " + greatestWords);
    }
}
