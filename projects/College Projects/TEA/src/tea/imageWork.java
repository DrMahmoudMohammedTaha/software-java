/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tea;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static tea.TEA.ECB_e2;

/**
 *
 * @author DELL
 */
public class imageWork {

    public static String nameBW = "BW.bmp";
    public static String nameColor = "color.png";

    public static void ecrypt_image(String s, String t) {
        File imageFile = new File(s);
        BufferedImage bi;

        try {
            bi = ImageIO.read(imageFile);

            String data = convertImage(bi);
            System.out.println("data " + data);
            BufferedImage bfi = copyImage(bi);
            String[] temp = ECB_e2(data);
            System.out.println("temp " + temp.length);
            createImage(temp, bfi, t);

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static String convertImage(BufferedImage bi) {

       // int ww = 148;
        Image im = bi.getScaledInstance(170, 80, BufferedImage.TYPE_3BYTE_BGR);
        bi = new BufferedImage(170, 80, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(im, 0, 0, null);
        String temp = "";
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                temp += Integer.toBinaryString(bi.getRGB(i, j));
            }
        }
        System.out.println("there");
        return temp;
    }

    public static void saveImage(BufferedImage bi, String name) throws IOException {
        File outputfile = new File(name);
        ImageIO.write(bi, "jpg", outputfile);

    }

    private static BufferedImage copyImage(BufferedImage bi) {
        return new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    }

    private static void createImage(String[] temp, BufferedImage bfi, String name) {
        int index = 0;
        for (int i = 0; i < temp.length; i++) {

            int x = 0b10001101010111101000111001111001  ;
                     int clr =(int)  Long.parseLong(temp[i].substring(0, 32), 2);
            bfi.setRGB(index / bfi.getWidth(), index % bfi.getHeight(), clr);
            index++;

            clr = (int)  Long.parseLong(temp[i].substring(32, 63), 2);
            bfi.setRGB(index / bfi.getWidth(), index % bfi.getHeight(), clr);
            index++;
        }
        try {
            saveImage(bfi, name);
        } catch (IOException ex) {
            Logger.getLogger(imageWork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
