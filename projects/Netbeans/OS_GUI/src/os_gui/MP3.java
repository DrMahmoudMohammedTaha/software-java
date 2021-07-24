package os_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MP3 {

    private JSlider soundSlider;// slider to select diameter
    private JFrame MPP = GUI_Ruler.addSimpleFrm("MP3 PLayer");
    private Mp3Player sound = new Mp3Player();
    private Timer clock = new Timer(0, null);
    private JButton play = GUI_Ruler.addBtn(0, 0, 200, 200, null, "play.png", MPP);
    private JButton stop = GUI_Ruler.addBtn(0, 0, 220, 240, null, "pause.png", MPP);
    
    public MP3(String name) {
        // set up JSlider to control diameter value
        soundSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        soundSlider.setMajorTickSpacing(10); // create tick every 10
        soundSlider.setPaintTicks(true); // paint ticks on slider
        // register JSlider event listener
        soundSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                sound.seek(soundSlider.getValue());

            }
        });

        MPP.setSize(220, 270);
        MPP.add(soundSlider, BorderLayout.SOUTH);// add slider to frame
        MPP.setResizable(false);
        MPP.setVisible(true);
        play.setVisible(false);
        sound.play(name);
        startTimer();
        play.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                play.setVisible(false);
                stop.setVisible(true);
                sound.play(name);
                sound.seek(soundSlider.getValue());
                clock.start();
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        stop.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                play.setVisible(true);
                stop.setVisible(false);
                sound.stop();
                clock.stop();

            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });
        BufferedImage img;
        try {
            img = ImageIO.read(new File("sound_ICON.png"));
            MPP.setIconImage(img);
        } catch (IOException ex) {
        }

        MPP.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                sound.stop();
            }
        });

    }

    public void startTimer() {
        clock = new Timer(3000, null);
        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                soundSlider.setValue((int) sound.seekInfo());
            }
        });
          clock.start();
    }
}
