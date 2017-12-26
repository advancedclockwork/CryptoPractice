/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Owen
 */
public class CommonWordConfirmer {
    public static boolean check_for_word(String word, String filePath) {
        // System.out.println(word);
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    filePath));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.contains(word)) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        return false;
    }
}
