

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */

public class collage_model {

    static int[] pos_s = new int[3];

    static int[] pos_t = new int[3];

    public static void get_pos_s(String p) {
        pos_s[2] = Integer.parseInt(p.substring(2).split("-")[0]);
        int num = Integer.parseInt(p.split("-")[1]);
        if (num == 1 || num == 2 || num == 35 || num == 34 || num == 33) {
            pos_s[0] = 0;
            pos_s[1] = 0;
        }
        else if(num < 12)
        {
            pos_s[0] = 1;
            pos_s[1] = num - 3;
        }
        else if(num > 12)
        {
            pos_s[0] = -1;
            pos_s[1] = 21 - num ;
        }
    }

    public static void get_pos_t(String dest) {
        pos_t[2] = Integer.parseInt(dest.substring(2).split("-")[0]);
        int num = Integer.parseInt(dest.split("-")[1]);
        if (num == 1 || num == 2 || num == 35 || num == 34 || num == 33) {
            pos_t[0] = 0;
            pos_t[1] = 0;
        }
         else if(num < 12)
        {
            pos_t[0] = 1;
            pos_t[1] = num - 3;
        }
        else if(num > 12)
        {
            pos_t[0] = -1;
            pos_t[1] = 21 - num ;
        }
    }

    public static int get_eclidean() {
        return (int) Math.sqrt(Math.pow(pos_s[0] - pos_t[0], 2) + Math.pow(pos_s[1] - pos_t[1], 2) + Math.pow(pos_s[2]- pos_t[2], 2)) * 10;
    }

    public static int get_heuristic(String p, String dest) {
        get_pos_s(p);
        get_pos_t(dest);
         return get_eclidean();
    }

}
