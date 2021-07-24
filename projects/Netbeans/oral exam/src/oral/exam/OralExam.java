/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oral.exam;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

/**
 *
 * @author Aboahmed
 */
public class OralExam {

    public static void main(String[] args) {
    JFrame y = GUI_Ruler.addFrm(true, true, 20, 20, 200, 200, null, null, true);
        JTextArea x = GUI_Ruler.addtxt(10, 10, 50, 50, "work", y);
  
        x.setSelectedTextColor(Color.yellow);
        x.setSelectionColor(Color.BLUE);
        x.setName("xtra");
        
      
        
        x.selectAll();
        
        x.setAutoscrolls(true);
        
        
        
        
        
        
        
        JPopupMenu popMenu = new JPopupMenu();
        PopupMenu popMen1 = new PopupMenu();
       MenuItem item1 = new MenuItem("الرئيسية");
     MenuItem item2 = new MenuItem("الرئيسية");
    popMen1.add(item1);
    popMen1.add(item2);
    
        
        
        popMenu.add(popMen1);
        
        
                x.setComponentPopupMenu(popMenu);
        
        
    }
    
}
