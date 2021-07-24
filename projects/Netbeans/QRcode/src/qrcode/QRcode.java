/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qrcode;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;

/**
 *
 * @author DELL
 */
public class QRcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    BarCode barcode = new BarCode();

     barcode.setCodeToEncode("123456789");
     barcode.setSymbology(IBarCode.QRCODE);
     barcode.setQrCodeDataMode(IBarCode.QR_MODE_NUMERIC);
     barcode.setQrCodeEcl(IBarCode.QR_ECL_Q);
     barcode.setQrCodeVersion(2);
     try
     {    
         System.out.println(barcode.draw("c://qrcode.gif"));
     
     }
     catch (Exception e) 
     {
     e.printStackTrace();
     }
    }
    
}
