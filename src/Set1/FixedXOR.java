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
public class FixedXOR {
    public static void main(String[] args) throws DecoderException{
        Scanner scan = new Scanner(System.in);
        System.out.println("First Hex to XOR:");
        char[] hexOne = scan.nextLine().toCharArray();
        System.out.println("Second Hex to XOR:");
        char[] hexTwo = scan.nextLine().toCharArray();
        byte[] first = Hex.decodeHex(hexOne);
        byte[] second = Hex.decodeHex(hexTwo);
        byte[] result = new byte[first.length];
        int i = 0;
        for(byte b: first){
            result[i] = (byte) (b ^ second[i++]);
        }
        String output = Hex.encodeHexString(result);
        System.out.println("Result:\n" + output);
    }
}
