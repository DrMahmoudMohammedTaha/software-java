package javaapplication7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class sub {
int x ;
    
sub()
{

    System.out.println("not argument"+this);
}

    @Override
    protected void finalize() throws Throwable {
    
            System.out.println("finialize sub"+this);
            super.finalize(); //To change body of generated methods, choose Tools | Templates.

    
    }

public void tera ()
{}
}
