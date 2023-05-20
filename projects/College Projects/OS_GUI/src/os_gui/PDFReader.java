/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package os_gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;


public class PDFReader {

   
    public static void startPDF(String name) {
         OpenPDF.run(name);
    }
}
class MasterVolume {
    
    
  public void setMasterVolume(float value) {
    String command = "set volume " + value;
    try {
      ProcessBuilder pb = new ProcessBuilder("osascript", "-e", command);
      pb.directory(new File("/usr/bin"));
      System.out.println(command);
      StringBuffer output = new StringBuffer();
      Process p = pb.start();
      p.waitFor();

      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
      System.out.println(output);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class MixerVolume {
  public MixerVolume() {
    Mixer.Info[] mixers = AudioSystem.getMixerInfo();
    System.out.println("There are " + mixers.length + " mixer info objects");
    for (Mixer.Info mixerInfo : mixers)

    {
      System.out.println("mixer name: " + mixerInfo.getName());
      Mixer mixer = AudioSystem.getMixer(mixerInfo);
      Line.Info[] lineInfos = mixer.getTargetLineInfo(); // target, not source
      for (Line.Info lineInfo : lineInfos) {
        System.out.println("  Line.Info: " + lineInfo);
        Line line = null;
        boolean opened = true;
        try {
          line = mixer.getLine(lineInfo);
          opened = line.isOpen() || line instanceof Clip;
          if (!opened) {
            line.open();
          }
          FloatControl volCtrl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
          System.out.println("    volCtrl.getValue() = " + volCtrl.getValue());
        } catch (LineUnavailableException e) {
          e.printStackTrace();
        } catch (IllegalArgumentException iaEx) {
          System.out.println("    " + iaEx);
        } finally {
          if (line != null && !opened) {
            line.close();
          }
        }
      }
    }
  }
}

class OpenPDF {
  public static void run(String filePath) {
    // build a component controller
    SwingController controller = new SwingController();

    SwingViewBuilder factory = new SwingViewBuilder(controller);

    JPanel viewerComponentPanel = factory.buildViewerPanel();

    // add interactive mouse link annotation support via callback
    controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                    controller.getDocumentViewController()));

    JFrame applicationFrame = GUI_Ruler.addSimpleFrm("PDF READER");
    applicationFrame.getContentPane().add(viewerComponentPanel);

    // Now that the GUI is all in place, we can try openning a PDF
    controller.openDocument(filePath);

    // show the component
    applicationFrame.pack();
    applicationFrame.setVisible(true);
  }
}
