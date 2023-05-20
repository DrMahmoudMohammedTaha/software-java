
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc4;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RC4 {

    // Key Scheduling Algorithm 
// Input: state - the state used to generate the keystream
//        key - Key to use to initialize the state 
//        len - length of key in bytes  
    public static void ksa(char state[], char key[], int len) {
        int i, j = 0, t;

        for (i = 0; i < 256; ++i) {
            state[i] = (char) (i % 256);
        }
        for (i = 0; i < 256; ++i) {
            j = (j + state[i] + key[i % len]) % 256;
            t = state[i];
            state[i] = state[j];
            state[j] = (char) (t % 256);
        }
    }

// Pseudo-Random Generator Algorithm 
// Input: state - the state used to generate the keystream 
//        out - Must be of at least "len" length
//        len - number of bytes to generate 
    public static void prga(char state[], char out[], int len) {
        int i = 0, j = 0, x, t;
        char key;

        for (x = 0; x < len; ++x) {
            i = (i + 1) % 256;
            j = (j + state[i]) % 256;
            t = state[i];
            state[i] = state[j];
            state[j] = (char) (t % 256);
            out[x] = state[(state[i] + state[j]) % 256];
        }
    }

    /**
     * @param args the command line arguments
     */
    public static char keys[] = new char[7];
    public static char states[] = new char[256];
    public static char outs[] = new char[100];

    public static void main(String[] args) {

        keys[0] = 0x1A;
        keys[1] = 0x2B;
        keys[2] = 0x3C;
        keys[3] = 0x4D;
        keys[4] = 0x5E;
        keys[5] = 0x6F;
        keys[6] = 0x77;

        for (char i = 0; i < states.length; i++) {
            states[i] = i;
        }
        
        ksa(states, keys, 7);
        prga(states, outs, 7);
        
        for (int i = 0; i < outs.length; i++) {
            System.out.println(outs[i]);
        }
        // TODO code application logic here
    }

}
