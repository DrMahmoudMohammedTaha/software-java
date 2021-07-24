/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socketing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TestServer {

public static void main(String args[]) throws IOException {
      
    ServerSocket serverSocket = new ServerSocket(1112);
    
    Socket socket = serverSocket.accept();
    PrintWriter output =  new PrintWriter(socket.getOutputStream(), true);
    output.write(enc( "computer science engineers",socket.getInetAddress().toString()));
    output.flush();
    socket.close();
    serverSocket.close();       
    JOptionPane.showMessageDialog(null, "Messege have been sent from the server program!");
}

public static String enc(String s ,String ip)
{
String temp="";
    for (int i = 0; i < s.length(); i++) {
        temp += ( (char) (((int)s.charAt(i)) +10) ) +"";
    }
    return ip + temp;
}

}
