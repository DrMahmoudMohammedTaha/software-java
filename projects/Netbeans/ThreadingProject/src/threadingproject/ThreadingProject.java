package threadingproject;

import java.util.ArrayList;

public class ThreadingProject {

    final static ArrayList<String> names = new ArrayList();
    static boolean readed = true;

    public static void main(String[] args) {
        newStringThread NSTH = new newStringThread();
        ShowThread SHTH = new ShowThread();
        NSTH.start();
        SHTH.start();

    }

}
