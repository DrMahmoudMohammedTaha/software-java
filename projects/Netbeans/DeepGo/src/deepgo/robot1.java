/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.helper.*;
import static deepgo.point.black;
import static deepgo.point.white;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class robot1 implements actionable {

    @Override
    public void doTurn() {
        int WC = measureConnectivity(white);
        System.out.println("white connectivity: " + WC);

        int BC = measureConnectivity(black);
        System.out.println("black connectivity: " + BC);
        System.out.println(WC <= BC);
        if (WC <= BC) {
            ArrayList<ArrayList<point>> temp = grouping.getGroups(white);
            if (temp.isEmpty()) {
                ArrayList<point> vacants = getVacants();
                point p = vacants.get(new Random().nextInt(vacants.size()));
                setPoint(p, white);
            } else {
                    treeBuilder.smartTreeBuilder(temp.get(0), white);
            
           }
        } else {
            ArrayList<ArrayList<point>> temp = grouping.getGroups(black);
            if (temp.isEmpty()) {
                ArrayList<point> vacants = getVacants();
                point p = vacants.get(new Random().nextInt(vacants.size()));
                setPoint(p, white);

            } else {
                try {
                    treeBuilder.smartTreeBuilder(temp.get(temp.size() - new Random().nextInt(3) ), white);    
                } catch (Exception e) {
                    treeBuilder.smartTreeBuilder(temp.get(temp.size() - 1), white);
                }
            
            }

        }
        try {
            TimeUnit.MILLISECONDS.sleep(servent.SECONDS);
        } catch (InterruptedException ex) {
          }
    }

}
