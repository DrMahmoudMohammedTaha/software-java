/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package os_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author Aboahmed
 */
public abstract class shape {
     public Color c = Color.white;
     public boolean filled = false;  

    public abstract void draw(Graphics g);
    public abstract void increase (MouseEvent me);
    public abstract void start (MouseEvent me);
}
