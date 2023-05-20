/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batterylevel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 *
 * @author DELL
 */
public class BatteryLevel {

  public static void main(String[] args) throws Exception {
    LinkedList<String> res = null;
    if (isMac()) {
      res = execToString("pmset -g batt");
      String[] ad = {
              res.get(1).split("\\s+")[2].replace(";", ""),
              res.get(1).split("\\s+")[4]
      };
      System.out.println(ad[0] + " " + ad[1]);
    } else if (isWindows()) {
      res = execToString("wmic path win32_battery get estimatedchargeremaining");
      String perc = res.getLast().trim();
      res = execToString("wmic path win32_battery get estimatedruntime");
      int minutes = Integer.parseInt(res.getLast().trim());
      System.out.println(perc + "%  " + (minutes / 60) + ":" + (minutes % 60));
    }
  }

  public static LinkedList<String> execToString(String command) throws Exception {
    Runtime rt = Runtime.getRuntime();

    Process proc = rt.exec(command);

    InputStream stdin = proc.getInputStream();
    InputStreamReader isr = new InputStreamReader(stdin);
    BufferedReader br = new BufferedReader(isr);

    LinkedList<String> ad = new LinkedList();

    do {
      String line = br.readLine();
      if (!line.isEmpty())
        ad.add(line);
    } while (br.ready());

    return ad;
  }

  public static boolean isWindows() {
    return System.getProperty("os.name").startsWith("Windows");
  }

  public static boolean isMac() {
    return System.getProperty("os.name").startsWith("Mac");
  }
}
