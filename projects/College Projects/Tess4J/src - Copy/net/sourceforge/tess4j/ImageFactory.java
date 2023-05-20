/*
 * Copyright 2016 DELL.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sourceforge.tess4j;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GrayFilter;
import static net.sourceforge.tess4j.ocr.HEIGHT;
import static net.sourceforge.tess4j.ocr.THRESHOLD;
import static net.sourceforge.tess4j.ocr.WIDTH;

/**
 *
 * @author DELL
 */
public class ImageFactory {

    public static int[][] removeHor(int[][] array) {
        int dist = array.length * 3 / 5;

        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < array[i].length; j++) {
                // if (array[i][j]) 
                {

                }
            }
        }

        return array;
    }

    public static int[][] max(int[][] array, int len) {

        int[][] temp = new int[array.length - 2 * len][array[0].length - 2 * len];
        for (int i = len; i < array.length - len; i++) {
            for (int j = len; j < array[0].length - len; j++) {
                int max = array[i - len][j - len];
                for (int k = 0; k < 2 * len + 1; k++) {
                    for (int l = 0; l < 2 * len + 1; l++) {
                        if (array[i + k - len][j + l - len] > max) {
                            max = array[i + k - len][j + l - len];
                        }
                    }
                }

                temp[i - len][j - len] = max;
            }
        }

        return temp;
    }

    public static int[][] min(int[][] array, int len) {

        int[][] temp = new int[array.length - 2 * len][array[0].length - 2 * len];
        for (int i = len; i < array.length - len; i++) {
            for (int j = len; j < array[0].length - len; j++) {
                int min = array[i - len][j - len];
                for (int k = 0; k < 2 * len + 1; k++) {
                    for (int l = 0; l < 2 * len + 1; l++) {
                        if (array[i + k - len][j + l - len] < min) {
                            min = array[i + k - len][j + l - len];
                        }
                    }
                }

                temp[i - len][j - len] = min;
            }
        }

        return temp;
    }

    public static int[][] smoothen(int[][] array, int len) {

        int[][] temp = new int[array.length - 2 * len][array[0].length - 2 * len];
        for (int i = len; i < array.length - len; i++) {
            for (int j = len; j < array[0].length - len; j++) {
                int sum = 0;
                for (int k = 0; k < 2 * len + 1; k++) {
                    for (int l = 0; l < 2 * len + 1; l++) {
                        sum += array[i + k - len][j + l - len];
                    }
                }

                temp[i - len][j - len] = (int) (sum / Math.pow((2 * len + 1), 2));
            }
        }

        return temp;
    }

    public static String purize(String input) {
        System.out.println();
        int index = input.indexOf("SB");
        if (index >= 0 && input.length() > index + 6) {
            String temp = input.substring(input.indexOf("SB"), index + 6);
            if (temp.matches("SB\\d-\\d{2}")) {
                return temp;
            }

            return "no";
        } else {
            return "no";
        }
    }

    public static void preProcess(String name) throws IOException {
        File imageFile = new File(name);
        BufferedImage bi = ImageIO.read(imageFile);
        int[][] imageMatrix;
        imageMatrix = convertImage(bi);
        imageMatrix = ImageFactory.max(imageMatrix, 1);
        imageMatrix = ImageFactory.smoothen(imageMatrix, 1);
        bi = ImageFactory.ConstructImage(imageMatrix, BufferedImage.TYPE_3BYTE_BGR);
        saveImage(bi, "done.jpg");

    }

    public static String readImgTxt(String name, float bright, float smooth) throws IOException {

        BufferedImage bi = ImageIO.read(new File("done.jpg"));
        bi = rbg2bw(brighten(bi, bright, smooth));

        ITesseract a = new Tesseract();
        String result = "";

        try {
            result = a.doOCR(bi);
            result = result.replace("$", "S")
                    .replace("S8", "SB")
                    .replace("S5", "SB")
                    .replace("S3", "SB")
                    .replace("s8", "SB")
                    .replace("s5", "SB")
                    .replace("s3", "SB")
                    .replace("58", "SB")
                    .replace("53", "SB")
                    .replace("55", "SB")
                    .replace("5B", "SB")
                    .replace("8B", "SB")
                    .replace("88", "SB")
                    .replace("sB", "SB")
                    .replaceAll(" ", "")
                    .replaceAll("o", "0")
                    .replaceAll("O", "0")
                    .replace("~", "-");

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(bright + " , " + smooth + " --> " + result);
        return result;
    }

    public static String reader(String name) throws IOException {
        String out1 = "NO";
        String out2 = "";
        int state = 0;
        preProcess(name);
      
        
        for (int k = 5; k < 100; k += 3) {
            for (float i = 1; i < 4; i+=0.2) {


                String temp = purize(readImgTxt(name, i, k));
                System.out.println(temp);
                if (!temp.equals("no") && state == 0) {
                    out1 = temp;
                    state = 1;
                } else if (!temp.equals("no") && state == 1) {
                    if (temp.equals(out1)) {
                        return out1;
                    }
                    out2 = temp;
                } else if (!temp.equals("no") && state == 2) {
                    if (temp.equals(out1)) {
                        return out1;
                    } else if (temp.equals(out2)) {
                        return out2;
                    } else {
                        return "NO";
                    }
                }
            }
        }

        return out1;

    }

    public static int[] histogram(int[][] arrayA) {  // nested for loop to go through the array.

        int histA[] = new int[265];
        for (int row = 0; row < arrayA.length; row++) {
            for (int col = 0; col < arrayA[row].length; col++) {
                histA[arrayA[row][col]]++;
            }
        }
        return histA;
    }

    public static BufferedImage brighten(BufferedImage f, float p1, float p2) {
        RescaleOp rescaleOp = new RescaleOp(p1, p2, null);
        return rescaleOp.filter(f, f);  // Source and destination are the same.
    }

    public static boolean[][] im2bw(double input[][]) {
        boolean output[][] = new boolean[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                output[i][j] = input[i][j] > THRESHOLD;
            }
        }
        return (output);
    }

    public static void saveImage(BufferedImage bi, String name) throws IOException {
        File outputfile = new File(name);
        ImageIO.write(bi, "jpg", outputfile);

    }

    public static BufferedImage rbg2gray(Image f) {
        ImageFilter filter = new GrayFilter(true, 10);
        ImageProducer producer = new FilteredImageSource(f.getSource(), filter);
        Image mage = Toolkit.getDefaultToolkit().createImage(producer);

        BufferedImage buffered = new BufferedImage(mage.getWidth(null), mage.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

        buffered.getGraphics().drawImage(mage, 0, 0, null);
        return buffered;
    }

    public static BufferedImage rbg2bw(Image f) {

        BufferedImage blackWhite = new BufferedImage(f.getWidth(null), f.getHeight(null), BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g2d = blackWhite.createGraphics();
        g2d.drawImage(f, 0, 0, null);
        g2d.dispose();
        return blackWhite;
    }

    public static int[][] convertImage(BufferedImage bi) {

        int[][] C = new int[bi.getWidth()][bi.getHeight()];
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {

                C[i][j] = (int) (((double) -1 * bi.getRGB(i, j) / 100000000) * 255);

            }

        }

        return C;
    }

    public static BufferedImage ConstructImage(int[][] PixelArray, int type) {

///////create Image from this PixelArray
        BufferedImage bfi = new BufferedImage(PixelArray.length, PixelArray[0].length, type);

        for (int x = 0; x < PixelArray.length; x++) {
            for (int y = 0; y < PixelArray[x].length; y++) {
                int Pixel = PixelArray[x][y] << 16 | PixelArray[x][y] << 8 | PixelArray[x][y];
                bfi.setRGB(x, y, Pixel);
            }

        }

        return bfi;
    }

    public static float getBright(int[] histo) {

        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < histo.length; i++) {

            if (histo[i] > max1) {
                max4 = max3;
                index4 = index3;
                max3 = max2;
                index3 = index2;
                max2 = max1;
                index2 = index1;

                max1 = histo[i];
                index1 = i;

            } else if (histo[i] > max2) {
                max4 = max3;
                index4 = index3;
                max3 = max2;
                index3 = index2;

                max2 = histo[i];
                index2 = i;
            } else if (histo[i] > max3) {
                max4 = max3;
                index4 = index3;
                max3 = histo[i];
                index3 = i;

            } else if (histo[i] > max4) {
                max4 = histo[i];
                index4 = i;
            }
        }

        float bright = 5 * (((index1 + index2 + index3 + index4) / (float) (128)));
        return bright;
    }

}
