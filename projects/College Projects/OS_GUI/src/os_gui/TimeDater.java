

package os_gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;


public class TimeDater {
    private static Timer clock = new Timer(1000, null);
    
     public static void startTime(JLabel time, JLabel day , JLabel date) {

        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //yyyy/MM/dd - 
                day.setText(new SimpleDateFormat("EEEE").format(new Date()));
                time.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
                date.setText(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
                day.setFont(new Font("Jokerman", Font.PLAIN, 20));
                time.setFont(new Font("Jokerman", Font.PLAIN, 20));
                date.setFont(new Font("Jokerman", Font.PLAIN, 20));
                
                }});
        
        
        clock.start();
    }

}
