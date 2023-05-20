/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aboahmed
 */
public class supere extends sub{

    public supere() {
       System.out.println("not argument"+this);

    }

    @Override
    protected void finalize() throws Throwable {
    System.out.println("finialize supere"+this);

        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

  }
