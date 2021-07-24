package tomasulo;

import static tomasulo.Tomasulo.addressModel;
import static tomasulo.Tomasulo.storeModel;

public class storeUnit {

    static int busy = 0;
    static int time = 0;
    static final int rule = 10;

    static void execute() {
        if(storeModel.isEmpty())
            return;
        time++;
        if (time >= rule ) {
            time = 0;
            storeModel.removeElementAt(0);
            addressModel.removeElementAt(0);
        }
    }

}
