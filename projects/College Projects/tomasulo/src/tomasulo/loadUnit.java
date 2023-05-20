package tomasulo;

import java.util.Random;
import static tomasulo.Tomasulo.hint;
import static tomasulo.Tomasulo.loadModel;

public class loadUnit {

    static int busy = 0;
    static int time = 0;
    static final int rule = 10;

    static void execute() {
        if (loadModel.isEmpty()) {
            return;
        }
        time++;
        if (time >= rule) {
            time = 0;
            loadModel.removeElementAt(0);
            int t = operation.removeRedundancy(new Random().nextInt(100), "Load");
            hint.setText("F" + t + " is on the CDB");
            
        
        }
    }

}
