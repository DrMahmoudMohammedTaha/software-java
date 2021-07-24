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

import java.awt.Color;
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

    
    public static pixel p[] = {
        new pixel(94, 128, 1),
        new pixel(103, 96, 2),
        new pixel(51, 150, 3),
        new pixel(103, 149, 4),
        new pixel(143, 149, 5),
        new pixel(191, 150, 6),
        new pixel(236, 150, 7),
        new pixel(279, 155, 8),
        new pixel(325, 152, 9),
        new pixel(368, 152, 10),
        new pixel(401, 153, 11),
        new pixel(410, 82, 13),
        new pixel(368, 81, 14),
        new pixel(334, 81, 15),
        new pixel(288, 78, 16),
        new pixel(236, 80, 17),
        new pixel(200, 78, 18),
        new pixel(152, 77, 19),
        new pixel(103, 77, 20),
        new pixel(60, 77, 21)

    };

    /*        new pixel(21),
     new pixel(3),
     new pixel(20),
     new pixel(1),
     new pixel(2),
     new pixel(4),
     new pixel(19),
     new pixel(5),
     new pixel(18),
     new pixel(6),
     new pixel(17),
     new pixel(7),
     new pixel(16),
     new pixel(8),
     new pixel(15),
     new pixel(9),
     new pixel(14),
     new pixel(10),
     new pixel(13),
     new pixel(11),};
     */
    public static void drawOnMap(String[] route) throws IOException {
        File imageFile = new File("map.jpg");
        BufferedImage bi = ImageIO.read(imageFile);

        int ww = 550;
        Image im = bi.getScaledInstance(ww, bi.getHeight() * ww / bi.getWidth(), BufferedImage.TYPE_3BYTE_BGR);
        bi = new BufferedImage(ww, bi.getHeight() * ww / bi.getWidth(), BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(im, 0, 0, null);
        drawRoute(bi, route);
        saveImage(bi, "mapDone.jpg");
    }

    public static void drawLineOnMap(BufferedImage bi, int n1, int n2, int color) {
       
        
        
        
        pixel p1 = pixel.get_target(p, n1);
        pixel p2 = pixel.get_target(p, n2);

        int minx = (p1.x > p2.x) ? p2.x : p1.x;
        int maxx = (minx == p1.x) ? p2.x : p1.x;

        int miny = (p1.y > p2.y) ? p2.y : p1.y;
        int maxy = (miny == p1.y) ? p2.y : p1.y;
        
        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                bi.setRGB(i, j, color);
            }
        }
    }

    public static void drawRoute(BufferedImage bi, String[] steps) {
        int mapColor = Color.red.getRGB();
        for (int i = 0; i < steps.length - 1; i++) {
            int floor_s = Integer.parseInt(steps[i].trim().substring(2).split("-")[0]);
            int floor_d = Integer.parseInt(steps[i + 1].trim().substring(2).split("-")[0]);
            int num_s = Integer.parseInt(steps[i].trim().split("-")[1]);
            int num_d = Integer.parseInt(steps[i + 1].trim().split("-")[1]);
           
            if(floor_s > floor_d)
                mapColor += 500;
            else if(floor_s < floor_d)
                mapColor -= 500;
            else if ((num_s == 11 && num_d == 10) ||(num_s == 13 && num_d == 14))   {
                 mapColor += 500;
            }else if ((num_s == 10 && num_d == 11) ||(num_s == 14 && num_d == 13))   {
                 mapColor += 500;
            }
            
            drawLineOnMap(bi, num_s, num_d, mapColor);
            if (i == 0) {
                drawPoint(bi, num_s, Color.red.getRGB());
            }
            if (i == steps.length - 2) {
                drawPoint(bi, num_d, Color.blue.getRGB());
            }
        }
    }

    public static void drawPoint(BufferedImage bi, int num, int color) {
        pixel p1 = pixel.get_target(p, num);
        for (int i = p1.x - 3; i <= p1.x + 3; i++) {
            for (int j = p1.y - 3; j <= p1.y + 3; j++) {
                  bi.setRGB(i, j, color);
            }
        }

    }

    public static void preProcess(String name) throws IOException {
        File imageFile = new File(name);
        BufferedImage bi = ImageIO.read(imageFile);
        convertImage(bi);
        for (int i = 0; i < size; i++) {
            major(bfi[i]);

        }

    }

    public static void getBoundary(BufferedImage bi) {
        int i_tmp = bi.getWidth() / 4;
        for (int i = 0; i < bi.getHeight(); i++) {
            int temp = 0;
            for (int j = 1; j < bi.getWidth(); j++) {
                if (bi.getRGB(j, i) == Color.black.getRGB() && bi.getRGB(j - 1, i) == Color.black.getRGB()) {
                    temp++;
                    if (temp > i_tmp) {
                        i_tmp = i;

                        for (int k = 0; k < bi.getWidth(); k++) {
                            bi.setRGB(k, i, Color.white.getRGB());
                        }
                        break;
                    }
                } else {
                    temp = 0;
                }
            }

        }

//        bi = bi_tmp;
    }

    public static String readImgTxt(int index) throws IOException {

    
        ITesseract a = new Tesseract();
        String result = "";

        try {
            result = a.doOCR(bfi[index]);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static String reader(String name) throws IOException {

        preProcess(name);

        String temp = "no";
        int index = 0;

        while (temp.equals("no")) {
            temp = readImgTxt(index++);

            if (index == size) {
                break;
            }
        }

        return temp;

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
    public static int size = 11;
    public static BufferedImage bfi[] = new BufferedImage[size];

    public static void major(BufferedImage bi) {
        int black = 0;
        int white = 0;

        for (int i = 1; i < bi.getWidth() - 1; i++) {
            for (int j = 1; j < bi.getHeight() - 1; j++) {

                for (int k = i - 1; k < i + 2; k++) {
                    for (int m = j - 1; m < j + 2; m++) {
                        if (bi.getRGB(k, m) == Color.white.getRGB()) {
                            white++;
                        } else {
                            black++;
                        }
                    }
                }
                if (white > black) {
                    bi.setRGB(i, j, Color.white.getRGB());
                } else {
                    bi.setRGB(i, j, Color.black.getRGB());
                }
                white = 0;
                black = 0;
            }

        }
    }

    public static void convertImage(BufferedImage bi) {

        int ww = 550;
        Image im = bi.getScaledInstance(ww, bi.getHeight() * ww / bi.getWidth(), BufferedImage.TYPE_3BYTE_BGR);
        bi = new BufferedImage(ww, bi.getHeight() * ww / bi.getWidth(), BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(im, 0, 0, null);

        for (int i = 0; i < size; i++) {
            bfi[i] = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        }

        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                int clr = bi.getRGB(i, j);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                for (int k = 0; k < size; k++) {
                    bfi[k].setRGB(i, j, Color.white.getRGB());
                }

                if (red < 115 && green < 115 && blue < 115) {
                    if (red < 5 && green < 5 && blue < 5) {
                        for (int k = 0; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 15 && green < 15 && blue < 15) {
                        for (int k = 1; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 25 && green < 25 && blue < 25) {
                        for (int k = 2; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 35 && green < 35 && blue < 35) {
                        for (int k = 3; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 45 && green < 45 && blue < 45) {
                        for (int k = 4; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }

                    } else if (red < 55 && green < 55 && blue < 55) {
                        for (int k = 5; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }

                    } else if (red < 65 && green < 65 && blue < 65) {
                        for (int k = 6; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 75 && green < 75 && blue < 75) {
                        for (int k = 7; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 85 && green < 85 && blue < 85) {
                        for (int k = 8; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 95 && green < 95 && blue < 95) {
                        for (int k = 9; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 105 && green < 105 && blue < 105) {
                        for (int k = 10; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    } else if (red < 115 && green < 115 && blue < 115) {
                        for (int k = 11; k < size; k++) {
                            bfi[k].setRGB(i, j, Color.black.getRGB());
                        }
                    }

                }
            }

        }

    }
}
