/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risenquicktool;

/**
 *
 * @author tguyer
 */
public class HashTool {
    public HashTool() {
        
    }
    
    public String unhash(String hashed) {
        String unhashed1 = "";
        for (int i = 0; i < hashed.length(); i++) {
            unhashed1 = unhashed1 + ((int) hashed.charAt(i) - 1);
        }
        
        String unhashed2 = "";
        for (int i = 0; i < unhashed1.length(); i++) {
            unhashed2 = unhashed2 + (unhashed1.charAt(i) / 13);
        }
        return unhashed2;
    }
    
    public String hash(String unhashed) {
        String hashed1 = "";
        for (int i = 0; i < unhashed.length(); i++) {
            hashed1 = hashed1 + ((int) unhashed.charAt(i) + 1);
        }
        
        String hashed2 = "";
        for (int i = 0; i < hashed1.length(); i++) {
            hashed2 = hashed2 + (hashed1.charAt(i) * 13);
        }
        return hashed2;
    }
}
