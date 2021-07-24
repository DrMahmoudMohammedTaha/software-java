package tea;

import java.util.ArrayList;

public class TEA {

    public static String message = "000100100011010001010110011110001001101010111100110111101111";
    public static String message2 = "Four score and seven years ago "
            + "our fathers brought forth on this continent, "
            + "a new nation, conceived in Liberty, "
            + "and dedicated to the proposition that all men are created equal";
    public static String IV = "1111111111111111110000000000000000111111111111111111000000000000";
    public static String key = "10100101011010111010101111001101000000000000000000000000000000001111111111111111111111111111111110101011110011011110111100000001";
    public final static long K0 = Long.parseLong(key.substring(0, 32), 2);
    public final static long K1 = Long.parseLong(key.substring(32, 64), 2);
    public final static long K2 = Long.parseLong(key.substring(64, 96), 2);
    public final static long K3 = Long.parseLong(key.substring(96, 128), 2);

    public static String meg = "01000001";

    public static void main(String[] args) {

        String tp = filling(encrypt(XOR(filling(meg, 64), IV)), 64);
        System.out.println(tp.length());
        System.out.println("message: " + filling(meg, 64) + "\nencrypted: " + tp + "\ndecrypted: " + XOR(decrypt(tp), IV));
        System.out.println("");
        System.out.println("");

        String temp = encrypt(filling(message, 64));
        System.out.println("message: " + message + "\nencrypted: " + temp + "\ndecrypted: " + decrypt(temp));
        System.out.println("");
        System.out.println("");

        String tmp[] = ECB_e(message2);

        System.out.println("message2:ECB " + message2 + "\nencrypted ECB: " + oneString(tmp) + "\ndecrypted: " + ECB_d(tmp));
        System.out.println("");
        System.out.println("");

        tmp = CBC_e(message2);
        System.out.println("message2:CBC " + message2 + "\nencrypted CBC: " + oneString(tmp) + "\ndecrypted: " + CBC_d(tmp));
        System.out.println("");
        System.out.println("");

        tmp = CTR_e(message2);
        System.out.println("message2:CTR " + message2 + "\nencrypted CTR: " + oneString(tmp) + "\ndecrypted: " + CTR_d(tmp));
        System.out.println("");
        System.out.println("");

        
        // encrypting the two images black and white and the colored one
        // we notice bw ecryption gives hint about the original image
        //but colored one doesn't give hint because small changes in degree of color will change the cihper of it
        imageWork.ecrypt_image("BW.bmp","Bw_.jpg");
        imageWork.ecrypt_image("color.png","color_.jpg");
        
    }

    public static String oneString(String tt[]) {
        String t = "";
        for (int i = 0; i < tt.length; i++) {
            t += tt[i];
        }
        return t;
    }

    private static String encrypt(String m) {

        long L = Long.parseLong(m.substring(0, 32), 2);
        long R = Long.parseLong(m.substring(32, 64), 2);

        long delta = 0x9e3779b9;
        long sum = 0;
        //int l = L+"".length()/2;
        for (int i = 0; i < 32; i++) {
            sum += delta;
            L += pure(pure(R << 4) + K0) ^ pure(R + sum) ^ pure(pure(R >> 5) + K1);
            L = pure(L);
            R += pure(pure(L << 4) + K2) ^ pure(L + sum) ^ pure(pure(L >> 5) + K3);
            R = pure(R);

        }
        return filling(Long.toBinaryString(Long.parseLong(L + "")), 32) + filling(Long.toBinaryString(Long.parseLong(R + "")), 32);

    }

    public static long pure(long x) {
        String temp = Long.toBinaryString(Long.parseLong(x + ""));
        if (temp.length() > 32) {
            temp = temp.substring(temp.length() - 32, temp.length());
        }
        return Long.parseLong(temp, 2);
    }

    private static String decrypt(String m) {

        long L = Long.parseLong(m.substring(0, 32), 2);
        long R = Long.parseLong(m.substring(32, 64), 2);
        long delta = 0x9e3779b9;
        long sum = delta << 5;
        for (int i = 0; i < 32; i++) {

            R -= pure(pure(L << 4) + K2) ^ pure(L + sum) ^ pure(pure(L >> 5) + K3);
            R = pure(R);
            L -= pure(pure(R << 4) + K0) ^ pure(R + sum) ^ pure(pure(R >> 5) + K1);
            L = pure(L);
            sum -= delta;
        }
        String LL = Long.toBinaryString(Long.parseLong(L + ""));
        String RR = Long.toBinaryString(Long.parseLong(R + ""));
        LL = filling(LL, 32);
        RR = filling(RR, 32);
        return LL + RR;
    }

    public static String[] ECB_e(String m) {
       
        ArrayList<String> temp = new ArrayList();
        
        m = converter(m);
      

        for (int i = 0; i < m.length(); i += 64) {
            temp.add(encrypt(filling(m.substring(i, (i + 64 <= m.length()) ? (i + 64) : (m.length())), 64)));
        
        }

        return temp.toArray(new String[temp.size()]);
    }

    public static String[] ECB_e2(String m) {
        ArrayList<String> temp = new ArrayList();
       
        for (int i = 0; i < m.length(); i += 64) {
            temp.add(encrypt(filling(m.substring(i, (i + 64 <= m.length()) ? (i + 64) : (m.length())), 64)));
            System.out.println(temp.get(temp.size()-1));
        }

        return temp.toArray(new String[temp.size()]);
    }

    public static String ECB_d(String[] m) {
        String temp = "";
        String tmp;
        for (int i = 0; i < m.length; i++) {
            tmp = decrypt(m[i]);

            temp += filling(tmp, 64);
        }
        temp = reconvert(temp);
        return temp;
    }

    private static String[] CBC_e(String m) {
        ArrayList<String> temp = new ArrayList();
        m = converter(m);

        for (int i = 0; i < m.length(); i += 64) {
            if (i == 0) {
                temp.add(encrypt(XOR(
                        filling(m.substring(i, (i + 64 <= m.length()) ? (i + 64) : (m.length())), 64), IV
                )));

            } else {
                temp.add(encrypt(XOR(
                        filling(m.substring(i, (i + 64 <= m.length()) ? (i + 64) : (m.length())), 64), temp.get(temp.size() - 1)
                )));
            }

        }

        return temp.toArray(new String[temp.size()]);
    }

    public static String XOR(String x, String y) {
        long t1 = Long.parseLong(x.substring(0, 32), 2);
        long tt1 = Long.parseLong(x.substring(32, 64), 2);

        long t2 = Long.parseLong(y.substring(0, 32), 2);
        long tt2 = Long.parseLong(y.substring(32, 64), 2);
        return filling(Long.toBinaryString(t1 ^ t2), 32) + filling(Long.toBinaryString(tt1 ^ tt2), 32);
    }

    private static String CBC_d(String[] m) {
        String temp = "";
        String tmp;
        for (int i = 0; i < m.length; i++) {
            if (i == 0) {
                tmp = XOR(decrypt(m[i]), IV);
            } else {
                tmp = XOR(decrypt(m[i]), m[i - 1]);
            }

            temp += filling(tmp, 64);
        }

        temp = reconvert(temp);
        return temp;
    }

    private static String[] CTR_e(String m) {
        ArrayList<String> temp = new ArrayList();
        m = converter(m);

        for (int i = 0; i < m.length(); i += 64) {
            temp.add(XOR(filling(m.substring(i, (i + 64 <= m.length()) ? (i + 64) : (m.length())), 64), encrypt(IV + i)));
        }

        return temp.toArray(new String[temp.size()]);
    }

    private static String CTR_d(String[] m) {
        String temp = "";
        String tmp;
        for (int i = 0; i < m.length; i++) {
           tmp  = (XOR(m[i], encrypt(IV + i)));
        
            temp += filling(tmp, 64);
        }

        temp = reconvert(temp);
        return temp;
    }

    private static String converter(String temp) {
        String tmp = "";
        String t;
        for (int i = 0; i < temp.length(); i++) {
            t = Integer.toBinaryString((int) temp.charAt(i));

            t = filling(t, 8);
            tmp += t;
        }
        return tmp;
    }

    public static String filling(String t, int n) {
        int count = n - t.length();
        for (int j = 0; j < count; j++) {
            t = "0" + t;
        }

        return t;
    }

    private static String reconvert(String temp) {
        String tmp = "";
        for (int i = 0; i < temp.length(); i += 8) {
            tmp += (char) Integer.parseInt(temp.substring(i, (i + 8 <= temp.length()) ? (i + 8) : (temp.length())), 2);
        }
        return tmp;

    }

}
