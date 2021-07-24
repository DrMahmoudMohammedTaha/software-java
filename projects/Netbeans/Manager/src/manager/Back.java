
package manager;

import java.util.ArrayList;


public abstract  class Back {

    
    public static String editedText ;
    public static int profileno , missionno ,profilenocopy , profilenoPast ;
    public static  ArrayList <String > lastData  = new ArrayList();
    public static boolean valid = false ;
    public static String action ;
    static ArrayList< ArrayList<String>> folderSafe = new ArrayList();
    public static ArrayList< ArrayList<String> > colonize(ArrayList< ArrayList<String> > first)
    {
    ArrayList< ArrayList<String>> safe = new ArrayList();
    
        for (int i = 0; i < first.size(); i++) {
            safe.add(new ArrayList<>());
            for (int j = 0; j < first.get(i).size(); j++) {
            safe.get(i).add(first.get(i).get(j));
            }
        }
        return safe;
    }
    public static void reset ()
    {
    editedText = "" ;
    profileno = missionno = profilenoPast = profilenocopy = 0;
    lastData.clear();
    valid = false ;
    action = "";
    folderSafe.clear();
    }
}
