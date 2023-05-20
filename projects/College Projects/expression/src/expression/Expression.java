/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pattern pp = Pattern.compile("[1 - 9]\\d{2}");

        Matcher mm = pp.matcher("001");
        while (mm.find()) {
            System.out.println(mm.group());
        }

        Pattern p = Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");

        String s
                = "Jane's Birthday is 05-12-75\n"
                + "Dave's Birthday is 11-04-68\n"
                + "John's Birthday is 04-28-73\n"
                + "Joe's Birthday is 12-17-77";
        //"John's Birthday is 04-28-73\n"

        Matcher m = p.matcher(s);
        while (m.find()) {
            //System.out.println( m.group() );
        }

    }

}
