/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.point.nextTo;
import static deepgo.point.similar;
import static deepgo.servent.BOARD;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class grouping {

    public static ArrayList< ArrayList<point>> groups = new ArrayList<>();
    public static int connections[];

    public static ArrayList< ArrayList<point>> getGroups(int t) {
        groups.clear();
        initiateGroups(t);
        System.out.println("empty groups " + groups.isEmpty());
        unifyGroups();
        orderGroups();
        return groups;
    }

    public static void initiateGroups(int t) {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                if (BOARD[i][j] == t) {
                    groups.add(new ArrayList<>());
                    groups.get(groups.size() - 1).add(new point(i, j));
                }
            }
        }
    }

    public static void unifyGroups() {

        point[] t1, t2;
        for (int i = 0; i < groups.size() - 1; i++) {

            for (int j = 0; j < groups.get(i).size(); j++) {

                for (int k = i + 1; k < groups.size(); k++) {
                
                    if (groups.size() == 1 || groups.size() == 0) {
                        return;
                    }
                    for (int l = 0; l < groups.get(k).size(); l++) {
                        if (nextTo(groups.get(i).get(j), groups.get(k).get(l))) {

                            t1 = groups.get(k).toArray(new point[0]);
                            groups.remove(k);
                            for (int m = 0; m < t1.length; m++) {
                    
                                groups.get(i).add(t1[m]);
                    
                            }
                    
                            k--;
                            break;
                        }
                    
                    }

                }
            }
        }

    }

    public static void purifyGroup(ArrayList<point> g) {
        for (int i = 0; i < g.size(); i++) {
            for (int j = i + 1; j < g.size(); j++) {
                if (similar(g.get(i), g.get(j))) {
                    g.remove(j);
                    j--;
                }

            }
        }
    }

    public static void orderGroups() {

        connections = new int[groups.size()];
        for (int i = 0; i < groups.size(); i++) {
            connections[i] = groupConnectivity(groups.get(i));
        }

        for (int i = 0; i < connections.length; i++) {
            for (int j = i + 1; j < connections.length; j++) {
                if (connections[i] < connections[j]) {
                    int temp = connections[i];
                    connections[i] = connections[j];
                    connections[j] = temp;
                    ArrayList<point> tmp = groups.get(i);
                    groups.set(i, groups.get(j));
                    groups.set(j, tmp);
                }
            }
        }

    }

    public static int groupConnectivity(ArrayList< point> points) {
        int temp = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (nextTo(points.get(i), points.get(j))) {
                    temp++;
                }
            }
        }
        return temp;
    }
}
