/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1;

import Set1.Tools.RepeatingKeyXOREncryptor;
import java.util.Scanner;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Owen
 */
public class RepeatingKeyXOR {
    public static void main(String[] args) throws DecoderException{
        System.out.println("please enter your key");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        System.out.println("please enter the message you wish to encrypt");
        String message = scan.nextLine();
        RepeatingKeyXOREncryptor encryptor = new RepeatingKeyXOREncryptor(key);
        System.out.println("encrypted message: " + encryptor.encrypt(message));
        System.out.println("encrytped message in HEX: " + Hex.encodeHexString(encryptor.encrypt(message).getBytes()));
    }
}
