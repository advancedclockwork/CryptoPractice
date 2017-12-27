/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1;

import Set1.Tools.Decryptor;
import java.util.Scanner;
import org.apache.commons.codec.DecoderException;

/**
 *
 * @author owen
 */
public class SingleByteXORCypher {
    public static void main(String[] args) throws DecoderException{
        System.out.println("please enter your encoded text");
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        Decryptor decryptor = new Decryptor(message);
        System.out.println(decryptor.getMostPossible());
    }
}
