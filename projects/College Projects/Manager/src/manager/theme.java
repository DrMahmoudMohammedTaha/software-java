package manager;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class theme {

    String desktop;
    Color c1, c2;
    Color x = new Color(Color.white.getRGB());

    public theme() {
    }

    public theme(String s, Color c1, Color c2) {
        desktop = s;
        this.c1 = c1;
        this.c2 = c2;

    }

}
