/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketing3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TestClient {

    static String IP = "127.0.0.1";

    public static void main(String args[]) throws IOException {

        try {
            Socket socket = new Socket(IP, 1112);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            JOptionPane.showMessageDialog(null, "Messeage have been received and decrypted in the client\n the message is: " + dec(input.readLine()));
            socket.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No messeages found for IP: "+IP);
        }

    }

    public static String dec(String s) {
        s = s.replaceFirst(IP, "");
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp += ((char) (((int) s.charAt(i)) - 10)) + "";
        }
        return temp.replaceFirst("%", "");
    }

}
