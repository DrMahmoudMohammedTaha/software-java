/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual_crypto;

import static visual_crypto.imageWork.decrypt_image;
import static visual_crypto.imageWork.encrypt_image;

/**
 *
 * @author DELL
 */
public class Visual_crypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String orignial = "original.bmp";
        String part1 = "p1.jpg";
        String part2 = "p2.jpg";
        String newImage = "retrived.bmp";

        encrypt_image(orignial, part1, part2);

        decrypt_image(part1 , part2 , newImage);

    }

}
