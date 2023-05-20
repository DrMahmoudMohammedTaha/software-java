
package system.tray;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
 
public class Main {
 
 public static void main(String[] args) throws AWTException {
 PopupMenu popMenu= new PopupMenu();
 MenuItem item1 = new MenuItem("Exit");
 item1.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent ae) {
  
     System.exit(0);
     
     }
 }); //adding action listener to item1
 popMenu.add(item1);
 MenuItem item2 = new MenuItem("Show");
 item2.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent ae) {
  
 JFrame x = new JFrame();
 x.setVisible(true);
     }
 }); //adding action listener to item1
 
 popMenu.add(item2);
 MenuItem item3 = new MenuItem("open");
 popMenu.add(item3);
 
 
 
 
 Image img = Toolkit.getDefaultToolkit().getImage("1.jpg");
 TrayIcon trayIcon = new TrayIcon(img, "Application Name", popMenu);
 SystemTray.getSystemTray().add(trayIcon);
 
 
 
 }
}