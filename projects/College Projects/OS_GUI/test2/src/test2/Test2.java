package test2;

import java.util.*;

class node {

    List<String> file = new ArrayList<String>();            // Contain files in this folder
    List<node> folder = new ArrayList<node>();             // Contain folders in this folder
    node parent;                                        // Parent folder 

    node() {
        
    }

    node(String file) {
        this(file, null);
    }

    node(node folder) {
        this("", folder);
    }

    node(String file, node folder) {
        this.file.add(file);
        this.folder.add(folder);
    }
    public void addFile(String s){
        this.file.add(s);
    }
}

class myFiles {

    node root;
    node current;                           // current folder I'm openning 
    int height;
    Scanner s = new Scanner(System.in);

    myFiles() {
        root = new node();
        current=root;
        height=0;
    }

    public void newFolder() {
        node nf = new node();                      // nf -> new folder
        current.folder.add(nf);
        nf.parent = current;
    }

    public void newFile(String file) {
        current.addFile(file);
    }

    // Return to the previous folder
    public void up() {
        if (current == root) {
            return;
        } else {
            current = current.parent;
            display();
        }
    }

    // Enter a sub folder or open a file
    public void enter(String f) {
        if (f.charAt(0) >= 'f' && (f.charAt(1) >= '0' && f.charAt(1) <= '9')) {
            //f.replace("f", "");
            String ss=f.substring(1);
            int i = Integer.parseInt(ss);
            current = current.folder.get(i-1);
            display();
        } else {
            System.out.println("Running : " + f);
        }
    }

    // Display folders and files in the specified folder
    public void display() {
        for (int i = 0; i < current.folder.size(); i++) {
            System.out.print("f" + (i + 1) + " ");
        }
        for (int i = 0; i < current.file.size(); i++) {
            System.out.print(current.file.get(i) + " ");
        }
    }
}

public class Test2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        myFiles f = new myFiles();
        String x = "",in="";
        System.out.println("Press : 1->New Folder 2->New File 3->return 4->Display\n or Enter th file or folder you wanna open ");
        while (!"0".equals(x)) {
            x = s.nextLine();
            switch (x) {
                case "1": 
                    f.newFolder();
                    break;
                case "2": 
                    System.out.print("Enter : ");
                    in=s.nextLine();
                    f.newFile(in);
                    break;
                case "3": 
                    f.up();
                    break;
                case "4":
                    f.display();
                    break;
                default: 
                    f.enter(x);
                    break;
                
            }
        }
    }
}
