
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AstarSearchAlgo {

    public static ArrayList<Node> classes = new ArrayList<Node>();

    public static void main(String[] args) {
        String goal = "SB9-09";
        String source = "SB1-16";
        
        add_classes(goal);

        add_adjacent();

        AstarSearch(get_node(source), get_node(goal));

        List<Node> path = printPath(get_node(goal));

        System.out.println("Path: " + path);

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

            add_relation(i, 11, i - 1, 11, 4);

            add_relation(i, 13, i - 1, 13, 4);

            add_relation(i, 18, i - 1, 18, 4);

            add_relation(i, 14, i, 11, 4);

            add_relation(i, 14, i, 13, 4);

            add_relation(i, 10, i, 11, 4);

            add_relation(i, 10, i, 13, 4);

            add_relation(i, 13, i, 11, 2);

            add_relation(i, 1, i, 2, 0);
            add_relation(i, 1, i, 21, 1);
            add_relation(i, 1, i, 3, 1);

            for (int j = 15; j < 22; j++) {
                add_relation(i, j, i, j - 1, 1);
                int tmp = 10 - j + 15;
                add_relation(i, j-1, i, tmp , 2);
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
