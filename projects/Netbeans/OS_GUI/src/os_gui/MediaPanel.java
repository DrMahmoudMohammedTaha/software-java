package os_gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MediaPanel extends JPanel {
public Player mediaPlayer ;
    public MediaPanel(URL mediaURL) {
        
        setLayout(new BorderLayout()); // use a BorderLayout
        Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
        try {
            mediaPlayer = Manager.createRealizedPlayer(mediaURL);
            // get the components for the video and the playback controls
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();
            if (video != null) {
                add(video, BorderLayout.CENTER);// add video component
            }
            if (controls != null) {
                add(controls, BorderLayout.SOUTH); // add controls
            }
            mediaPlayer.start(); // start playing the media clip
        } // end try
        catch (NoPlayerException noPlayerException) {
            JOptionPane.showMessageDialog(null, "No media player found");
        } // end catch
        catch (CannotRealizeException cannotRealizeException) {
            JOptionPane.showMessageDialog(null,"Could not realize media player");
        } // end catch
        catch (IOException iOException) {
            JOptionPane.showMessageDialog(null,"Error reading from the source");
        } // end catch
    } // end MediaPanel constructor
}// end class MediaPane    
