package os_gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imageViewer {

    private static final String viewerIcon = "imageViewerIcon.png";
    private static final String viewerName = "IMAGE STUDIO";

    public static final int viewerX = 50;
    public static final int viewerY = 50;
    static public JLabel background;

    public static void newViewer(String imge) {
        int viewerWidth = 300;
        int viewerHight = 300;
        BufferedImage img;
        try {
            img = ImageIO.read(new File(imge));
            viewerWidth = img.getWidth() + 50;
            viewerHight = img.getHeight() +50 ;
            if(viewerWidth > 800 || viewerHight > 800)
            {
            viewerWidth /= 2;
            viewerHight /= 2;
            }
            

        } catch (IOException ex) {}

            JFrame imageViewer = GUI_Ruler.addFrm(true, false, viewerX, viewerY, viewerWidth, viewerHight,
                    viewerName, imge, viewerIcon, false, false, false);

       

    }
}
