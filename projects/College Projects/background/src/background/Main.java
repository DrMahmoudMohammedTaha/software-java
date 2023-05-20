/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package background;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;
 
public class Main implements WrapperListener {
 
public static void main(String[] args) {
WrapperManager.start(new Main(), args);
}
 
public void controlEvent(int event) {
if ((event == WrapperManager.WRAPPER_CTRL_LOGOFF_EVENT )
&& ( WrapperManager.isLaunchedAsService() || WrapperManager.isIgnoreUserLogoffs())) {
//Ignore
}
else {
WrapperManager.stop( 0 );
}
}
 
@SuppressWarnings("resource")
public Integer start(String[] arg0) {
new AnnotationConfigApplicationContext(AppConfiguration.class);
return null;
}
 
public int stop(int arg0) {
return 0;
}
}