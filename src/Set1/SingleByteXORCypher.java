/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1;

import java.util.Scanner;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author owen
 */
public class SingleByteXORCypher {
    public static void main(String[] args) throws DecoderException{
        System.out.println("please enter your encoded text");
        Scanner scan = new Scanner(System.in);
        char[] message = scan.nextLine().toCharArray();
        byte[] hex = Hex.decodeHex(message);
        for(int i = 0; i <= 255; i++){
            byte[] result = new byte[hex.length];
            byte b = (byte)i;
            for(int j = 0; j<hex.length; j++){
                result[j] = (byte) (b ^ hex[j]);
            }
            String resultString = new String(result);
            if(isSpecialCharacter(resultString)){
                System.out.println("key:" + (char)b + " decrypted message:" + resultString);
            }
        }
    }
    
    public static boolean isSpecialCharacter(String result){
        boolean validChars = true;
        for(int i = 0; i < result.length(); i++){
            Character current = result.charAt(i);
            if(current.toString().matches("[^a-z A-Z0-9]//w")){
                System.out.println(current.toString());
                validChars = false;
            }
        }
        return validChars;
    }
}
