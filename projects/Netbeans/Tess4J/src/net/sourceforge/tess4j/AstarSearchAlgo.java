package net.sourceforge.tess4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JOptionPane;

public class AstarSearchAlgo {

    public static ArrayList<Node> classes = new ArrayList<Node>();
    public static String source;
    public static boolean valid = false;

    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    source = ocr.test_sample();
                    valid = true;
                   
                } catch (IOException ex) {
                    System.err.println("cannot read image!");
                }
            }
        }).start();
        String goal = "";

        while (true) {
            goal = JOptionPane.showInputDialog(null, "Enter your destinaion!");
            
            if (goal.matches("SB\\d-\\d{2}") || goal.matches("SB\\d-\\d")) {
                int floor = Integer.parseInt(goal.substring(2).split("-")[0]);
                int num = Integer.parseInt(goal.split("-")[1]);
                if (num < 10 && num > 0 && goal.matches("SB\\d-\\d")) {
                    goal = goal.substring(0, 4) + "0" + num;
                }
                if (floor >= 0 && floor <= 9 && num >= 1 && num <= 35) {
                    break;
                }
            }
        }

        while (!valid);
        if ((!source.equals("no"))) {
            add_classes(goal);
            if (get_node(goal) != null) {
                add_adjacent();

                AstarSearch(get_node(source), get_node(goal));

                List<Node> path = printPath(get_node(goal));
                String route = path.toString();
                route = route.substring(1, route.length() - 1);

                System.out.println("Path: " + route);
                System.out.println(get_instructions(route));
            } else {
                System.out.println("try to take image again!");
            }

        } else {

            System.out.println("Enter a valid destinaion!");

        }

    }

    public static String get_instructions(String route) throws IOException {
        String inst = "";
        String steps[] = route.split(",");
        ImageFactory.drawOnMap(steps);
        for (int i = 0; i < steps.length - 1; i++) {
            int c = getCost(steps[i].trim(), steps[i + 1].trim());
            int floor_s = Integer.parseInt(steps[i].trim().substring(2).split("-")[0]);
            int floor_d = Integer.parseInt(steps[i + 1].trim().substring(2).split("-")[0]);
            int num_s = Integer.parseInt(steps[i].trim().split("-")[1]);
            int num_d = Integer.parseInt(steps[i + 1].trim().split("-")[1]);

            if (c == 4) {
                if (floor_d > floor_s) {
                    inst += "- go upstairs\n";
                } else if (floor_d < floor_s) {
                    inst += "- go downstairs\n";
                } else {
                    if ( num_s == 11 ) {
                        inst += "- go upstairs\n";
                    } else {
                        inst += "- go downstairs\n";
                    }
                }
            } else if (c == 2) {
                inst += "- move to the other side\n";
            } else if (c == 1) {
                inst += "- move 4m ";
                if (num_d == 1 || num_s == 1) {
                    inst += "backwards ";
                } else if (num_d >= 14 || num_d <= 21) {
                    if (num_d > num_s) {
                        inst += "left to class door";
                    } else {
                        inst += "right to class door";
                    }
                } else if (num_d >= 3 || num_d <= 10) {
                    if (num_d > num_s) {
                        inst += "left to class door";
                    } else {
                        inst += "right to class door";
                    }
                }
                inst += "\n";
            }
        }
        return inst;
    }

    public static void add_classes(String des) {
        int limit = 21;
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                limit = 36;
            }
            for (int j = 0; j < limit; j++) {
                String name = "SB" + i + "-" + ((j < 10) ? ("0" + j) : j);
                classes.add(new Node(name, collage_model.get_heuristic(name, des)));
            }

        }
    }

    public static Node get_node(String t) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).value.equals(t)) {
                return classes.get(i);
            }
        }
        return null;
    }

    public static void add_relation(int i, int num, int i2, int num2, int cost) {
        String n = (num > 9) ? "" + num : "0" + num;
        String n2 = (num2 > 9) ? "" + num2 : "0" + num2;
        get_node("SB" + i + "-" + n).add_link(new Edge(get_node("SB" + i2 + "-" + n2), cost));
        get_node("SB" + i2 + "-" + n2).add_link(new Edge(get_node("SB" + i + "-" + n), cost));
    }

    private static void add_adjacent() {

        //11,13,  14,10  18,6
        for (int i = 1; i < 10; i++) {

            add_relation(i, 6, i - 1, 6, 4);

            add_relation(i, 18, i - 1, 18, 4);

      
            add_relation(i, 14, i, 13, 4);

            add_relation(i, 10, i, 11, 4);

      
            add_relation(i, 13, i, 11, 2);

            add_relation(i, 1, i, 2, 0);
            add_relation(i, 1, i, 20, 2);
            add_relation(i, 1, i, 4, 1);

            for (int j = 15; j < 22; j++) {
                add_relation(i, j, i, j - 1, 1);
                int tmp = 10 - j + 15;
                add_relation(i, j - 1, i, tmp, 2);
            }

            for (int j = 4; j < 11; j++) {
                add_relation(i, j, i, j - 1, 1);
            }

            if (i != 9) {
                add_relation(i, 14, i + 1, 11, 4);
                add_relation(i, 14, i + 1, 13, 4);

                add_relation(i, 10, i + 1, 11, 4);
                add_relation(i, 10, i + 1, 13, 4);
            }

        }

        return;
    }

    public static List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();

        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void AstarSearch(Node source, Node goal) {

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {
                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.f_scores > j.f_scores) {
                            return 1;
                        } else if (i.f_scores < j.f_scores) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }

                }
        );

        //cost from start
        source.g_scores = 0;

        queue.add(source);

        boolean found = false;

        while ((!queue.isEmpty()) && (!found)) {

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if (current.value.equals(goal.value)) {
                found = true;
            }

            //check every child of current node
            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;


                /*if child node has been evaluated and 
                 the newer f_score is higher, skip*/
                if ((explored.contains(child))
                        && (temp_f_scores >= child.f_scores)) {
                    continue;
                } /*else if child node is not in queue or 
                 newer f_score is lower*/ else if ((!queue.contains(child))
                        || (temp_f_scores < child.f_scores)) {

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    if (queue.contains(child)) {
                        queue.remove(child);
                    }

                    queue.add(child);

                }

            }

        }

    }

    public static int getCost(String s1, String s2) {

        return (int) get_node(s1).get_cost(get_node(s2));
    }

}

class Node {

    public final String value;
    public double g_scores;
    public double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val) {
        value = val;
    }

    public Node(String val, double hVal) {
        value = val;
        h_scores = hVal;
    }

    public void seth_scores(double g_scores) {
        this.h_scores = g_scores;
    }

    public String toString() {
        return value;
    }

    public double get_cost(Node n) {
        for (int i = 0; i < adjacencies.length; i++) {
            if (adjacencies[i].target == n) {
                return adjacencies[i].cost;
            }
        }
        return -1;
    }

    public void add_link(Edge e) {

        int size = 0;
        if (adjacencies == null) {
            size = 1;
        } else {
            size = adjacencies.length + 1;
        }
        Edge[] temp = new Edge[size];
        for (int i = 0; i < size - 1; i++) {
            temp[i] = adjacencies[i];
        }
        temp[size - 1] = e;
        adjacencies = temp;
    }

}

class Edge {

    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        target = targetNode;
        cost = costVal;
    }
}
