/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Internet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL ur = new URL("http://www.hdith.com");
        URLConnection conn = ur.openConnection();
        InputStream is = conn.getInputStream();
        String foo = new Scanner(is).useDelimiter("\\A").next();
        System.out.println(foo);

    }

}
