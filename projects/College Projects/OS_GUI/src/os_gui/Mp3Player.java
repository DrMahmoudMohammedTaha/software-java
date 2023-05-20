package os_gui;

import javazoom.jl.player.*;
import javazoom.jl.decoder.*;
import java.io.*;

public class Mp3Player {

    long pauseLocation;
    long audioTotalLength;
    String fileLocation;
    FileInputStream FIS;
    BufferedInputStream BIS;
    public Player player;
    int c = 0;
    boolean seekFlag = false;
    double st = 0;

    public void stop() {
        pauseLocation = 0;
        audioTotalLength = 0;
        c = 0;
        if (player != null) {
            player.close();

            player = null;

        }
    }

    public void play(String path) {
        if (player == null) {
            try {
                c++;
                FIS = new FileInputStream(path);
                BIS = new BufferedInputStream(FIS);
                player = new Player(BIS);
                audioTotalLength = FIS.available();
                if (c == 1) {
                    pauseLocation = audioTotalLength;
                }

                if (!seekFlag) {
                    FIS.skip(audioTotalLength - pauseLocation);
                }

                fileLocation = path + "";

            } catch (FileNotFoundException | JavaLayerException ex) {
            } catch (IOException ex) {
            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();

                    } catch (JavaLayerException ex) {
                    }
                }
            }.start();
        }
    }

    public void pause() {
        if (player != null) {
            try {
                pauseLocation = FIS.available();
                player.close();
                player = null;
            } catch (IOException ex) {
            }
        }
    }

    public double seekInfo() {
        try {
            return ((double) audioTotalLength - FIS.available()) * 100 / (double) audioTotalLength;
        } catch (IOException ex) {
        }
        return -1;
    }

    public void seek(double seekTime) {
        //stop();
        seekFlag = true;
        try {
            st = ((double) audioTotalLength - FIS.available()) * 100 / (double) audioTotalLength;
            FIS.skip((long) ((seekTime - st) * audioTotalLength / 100));

        } catch (IOException ex) {
            System.out.println("no");
        }
        //play(fileLocation);
        seekFlag = false;
        //st=seekTime;
    }

}
