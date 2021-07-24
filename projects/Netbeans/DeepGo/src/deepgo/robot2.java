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
public class robot2 implements actionable {

    @Override
    public void doTurn() {

        ArrayList<ArrayList<point>> temp = grouping.getGroups(white);
        if (temp.isEmpty()) {
            ArrayList<point> vacants = getVacants();
            point p = vacants.get(new Random().nextInt(vacants.size()));
            setPoint(p, black);

        } else {
            try {
                treeBuilder.smartTreeBuilder(temp.get( new Random().nextInt(temp.size()) ), black);
            } catch (Exception e) {
                treeBuilder.smartTreeBuilder(temp.get(temp.size() - 1), black);
            }

        }

        try {
            TimeUnit.MILLISECONDS.sleep(servent.SECONDS);
        } catch (InterruptedException ex) {
       }

    }

}
