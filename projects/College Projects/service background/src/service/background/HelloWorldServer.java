package service.background;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HelloWorldServer
        implements Runnable {

    private final Socket m_socket;
    private final int m_num;

    public static void stop() {

        JOptionPane.showMessageDialog(null, "End of service");

    }

    HelloWorldServer(Socket socket, int num) {
        m_socket = socket;
        m_num = num;

        Thread handler = new Thread(this, "handler-" + m_num);
        handler.start();
    }

    public void run() {
        try {
            try {
                System.out.println(m_num + " Connected.");
                BufferedReader in = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
                OutputStreamWriter out = new OutputStreamWriter(m_socket.getOutputStream());
                out.write("Welcome connection #" + m_num + "\n\r");
                out.flush();

                while (true) {
                    String line = in.readLine();
                    if (line == null) {
                        System.out.println(m_num + " Closed.");
                        return;
                    } else {
                        System.out.println(m_num + " Read: " + line);
                        if (line.equals("exit")) {
                            System.out.println(m_num + " Closing Connection.");
                            System.exit(0);

                            return;
                        } //else if ( line.equals( "crash" ) )
                        //{
                        //    System.out.println( m_num + " Simulating a crash of the Server..." );
                        //    Runtime.getRuntime().halt(0);
                        //}
                        else {
                            System.out.println(m_num + " Write: echo " + line);
                            out.write("echo " + line + "\n\r");
                            out.flush();
                        }
                    }
                }
            } finally {
                m_socket.close();
            }
        } catch (IOException e) {
            System.out.println(m_num + " Error: " + e.toString());
        }
    }

    public static void main(String[] args)
            throws Exception {
        int port = 9000;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Accepting connections on port: " + port);
        int nextNum = 1;
        ServerSocket serverSocket = new ServerSocket(port);
        JFrame x = new JFrame();
        x.setBounds(100, 100, 100, 100);
        x.setVisible(true);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //running anther program
        final String cmd = "";
        final String arg1 = "-l";
        final ProcessBuilder pb = new ProcessBuilder("mp3.exe");
            final Process p;
           p = pb.start();
  /*          
           try {
        p = pb.start();
        } catch (final IOException ex) {
            System.err.println("IO error: " + ex.getLocalizedMessage());
        }
*/
//end of multi-threading

        while (true) {
            
            System.out.println(p.waitFor());
            if(p.waitFor()==0)
                System.exit(0);
         
            Socket socket = serverSocket.accept();
            HelloWorldServer hw = new HelloWorldServer(socket, nextNum++);

        }
    }
}
