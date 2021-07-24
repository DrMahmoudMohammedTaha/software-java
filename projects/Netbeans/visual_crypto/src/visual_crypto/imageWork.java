/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual_crypto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class imageWork {

   
    public static void decrypt_image(String P1, String P2, String result) {
        File imageFile1 = new File(P1);
        BufferedImage bi1;

        File imageFile2 = new File(P2);
        BufferedImage bi2;
        BufferedImage bi;

        try {
            bi1 = ImageIO.read(imageFile1);
            bi2 = ImageIO.read(imageFile2);
            bi = get_data(bi1, bi2);
            saveImage(bi, result);

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public static void encrypt_image(String original, String p1, String p2) {

        File imageFile = new File(original);
        BufferedImage bi;
        BufferedImage bi1;
        BufferedImage bi2;

        try {

            bi = ImageIO.read(imageFile);
            bi1 = new BufferedImage(bi.getWidth() * 2, bi.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
            bi2 = new BufferedImage(bi.getWidth() * 2, bi.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

            split_encode(bi, bi1, bi2 , p1 , p2);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void split_encode(BufferedImage bi, BufferedImage bi1, BufferedImage bi2 , String p1 , String p2) {

        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                int temp = bi.getRGB(i, j);
                if (temp == -1) {
                    same(bi1, bi2, i, j);
                } else {
                    differ(bi1, bi2, i, j);
                }
            }
        }
        try {
            saveImage(bi1, p1);
        } catch (IOException ex) {
            Logger.getLogger(imageWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            saveImage(bi2, p2);
        } catch (IOException ex) {
            Logger.getLogger(imageWork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveImage(BufferedImage bi, String name) throws IOException {
        File outputfile = new File(name);
        ImageIO.write(bi, "bmp", outputfile);

    }

    private static void same(BufferedImage bi1, BufferedImage bi2, int i, int j) {

        boolean temp = new Random().nextBoolean();
        if (temp) {
            bi1.setRGB(i * 2, j, Color.white.getRGB());
            bi1.setRGB(i * 2 + 1, j, Color.black.getRGB());
            bi2.setRGB(i * 2, j, Color.white.getRGB());
            bi2.setRGB(i * 2 + 1, j, Color.black.getRGB());
        } else {
            bi1.setRGB(i * 2, j, Color.black.getRGB());
            bi1.setRGB(i * 2 + 1, j, Color.white.getRGB());
            bi2.setRGB(i * 2, j, Color.black.getRGB());
            bi2.setRGB(i * 2 + 1, j, Color.white.getRGB());
        }

    }

    private static void differ(BufferedImage bi1, BufferedImage bi2, int i, int j) {

        boolean temp = new Random().nextBoolean();
        if (temp) {
            bi1.setRGB(i * 2, j, Color.white.getRGB());
            bi1.setRGB(i * 2 + 1, j, Color.black.getRGB());
            bi2.setRGB(i * 2, j, Color.black.getRGB());
            bi2.setRGB(i * 2 + 1, j, Color.white.getRGB());

        } else {
            bi1.setRGB(i * 2, j, Color.black.getRGB());
            bi1.setRGB(i * 2 + 1, j, Color.white.getRGB());
            bi2.setRGB(i * 2, j, Color.white.getRGB());
            bi2.setRGB(i * 2 + 1, j, Color.black.getRGB());
        }

    }

    private static BufferedImage get_data(BufferedImage bi1, BufferedImage bi2) {
        BufferedImage bi = new BufferedImage(bi2.getWidth()/2, bi2.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        int index = 0 ;
        for (int i = 0; i < bi1.getWidth(); i += 2) {
            for (int j = 0; j < bi.getHeight(); j++) {
                int temp1 = bi1.getRGB(i, j);
                int temp2 = bi2.getRGB(i, j);
                System.out.print("temp1 "+ temp1 + " temp2 "+ temp2);
                if ( Math.abs(temp1 - temp2) < 10 ) {
                    bi.setRGB(i / 2, j, Color.white.getRGB());
                    System.out.println(" white");
                } else {
                    bi.setRGB(i / 2, j, Color.black.getRGB());
                    System.out.println(" black");
                    index++;
                }
            }
        }
        System.out.println(index);
        return bi;
    }
}
