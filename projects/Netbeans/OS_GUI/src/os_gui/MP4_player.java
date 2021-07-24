package os_gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MP4_player {
    // launch the application

    public static void start_MP4(String url) {
        // create a file chooser

        URL mediaURL = null;

        try {
            // get the file as URL
            File file = new File(url);
            mediaURL = file.toURI().toURL();
            // get the file as URL
        }// end try
        catch (MalformedURLException malformedURLException) {
            JOptionPane.showMessageDialog(null, "Could not create URL for the file");
        }// end catch
        if (mediaURL != null)// only display if there is a valid URL
        {
            JFrame mediaTest = GUI_Ruler.addSimpleFrm("MP4 PLAYER");
            
            MediaPanel mediaPanel = new MediaPanel(mediaURL);
            BufferedImage img;
            try {
                img = ImageIO.read(new File("video.png"));
                mediaTest.setIconImage(img);
            } catch (IOException ex) {
            }
            mediaTest.add(mediaPanel);
            mediaTest.setSize(300, 300);
            mediaTest.setVisible(true);

            mediaTest.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    mediaPanel.mediaPlayer.close();
                }
            });

        } // end outer if
    } // end main
}// end class MediaTes
