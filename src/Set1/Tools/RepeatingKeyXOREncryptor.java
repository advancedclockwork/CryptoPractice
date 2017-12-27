/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set1.Tools;

/**
 *
 * @author Owen
 */
public class RepeatingKeyXOREncryptor {
    private final String key;
    public RepeatingKeyXOREncryptor(String key){
        this.key = key;
    }
    
    public String encrypt(String message){
        String encrypted = "";
        for(int i = 0; i < message.length(); i++){
            char currentKeyBit = key.charAt(i%key.length());
            encrypted +=(char)(message.charAt(i) ^ currentKeyBit);
        }
        return encrypted;
    }
}
