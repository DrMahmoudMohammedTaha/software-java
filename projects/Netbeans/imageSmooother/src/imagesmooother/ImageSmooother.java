/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesmooother;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class ImageSmooother {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        preProcess("work.jpg");
    }

    public static void preProcess(String name) throws IOException {
        File imageFile = new File(name);
        BufferedImage bi = ImageIO.read(imageFile);
        BufferedImage bi2 = ImageIO.read(imageFile);
        smooth(bi,bi2);
        saveImage(bi2, name);
    }

    
    public static void smooth(BufferedImage bi,BufferedImage bi2)
    {
    
        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 1; j < bi.getWidth(); j++) {
                 int clr = bi.getRGB(j, i);
                int redN = (clr & 0x00ff0000) >> 16;
                int greenN = (clr & 0x0000ff00) >> 8;
                int blueN = clr & 0x000000ff;
                clr = bi.getRGB(j-1, i);
                int redO = (clr & 0x00ff0000) >> 16;
                int greenO = (clr & 0x0000ff00) >> 8;
                int blueO = clr & 0x000000ff;
                
                if (Math.abs(redN - redO) < 2 && Math.abs(greenN - greenO) < 2 &&Math.abs(blueN - blueO) < 3 ) {
                 bi2.setRGB(j, i, bi.getRGB(j-1, i));
                }else{
                bi2.setRGB(j, i, bi.getRGB(j, i));
                }
            }
        }
    }
    public static void saveImage(BufferedImage bi, String name) throws IOException {
        File outputfile = new File(name);
        ImageIO.write(bi, "jpg", outputfile);

    }

}
