/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
/**
 *
 * @author owen
 */
public class HexToB64 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DecoderException {
        System.out.println("Enter your hex string:");
        Scanner scan = new Scanner(System.in);
        String original = scan.nextLine();
        char[] chars = original.toCharArray();
        byte[] hex = Hex.decodeHex(chars);
        String bSixFour = Base64.encodeBase64String(hex);
        System.out.println("translation to base64:\n" + bSixFour);
        // TODO code application logic here
    }
    
}
