/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secretaudio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SplitAudio {
    private int BUFFER_LENGTH=1024;
    private double startTime;
    private double endTime;
    private File sourceFile;
    
    public static void main(String[] args) throws LineUnavailableException {
        new SplitAudio(new File("wake.mp3"), 0, 10).splitAudio();
        
    }
    public SplitAudio(File sourceFile,int startTime,int endTime) throws LineUnavailableException{
        this.startTime=startTime;
        this.endTime=endTime;
        this.sourceFile = sourceFile;
        AudioInputStream inputAIS = null;
        try {
            inputAIS = AudioSystem.getAudioInputStream(sourceFile);
            Clip clip = AudioSystem.getClip();
            clip.open(inputAIS);
            long totalMicroSecond = clip.getMicrosecondLength();
        } catch (UnsupportedAudioFileException e) {

        } catch (IOException e) {

        } catch (LineUnavailableException e) {

        }
    }
    public void splitAudio(){

        File outputFile = new File("a.wav");
        AudioFileFormat fileFormat = null;
        try {
            fileFormat = AudioSystem.getAudioFileFormat(sourceFile);
            AudioFileFormat.Type targetFileType = fileFormat.getType();
                AudioFormat audioFormat = fileFormat.getFormat();


                AudioInputStream inputAIS = AudioSystem.getAudioInputStream(sourceFile);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int nBufferSize = BUFFER_LENGTH * audioFormat.getFrameSize();
                byte[] abBuffer = new byte[nBufferSize];
                while (true) {

                    int nBytesRead = inputAIS.read(abBuffer);

                    if (nBytesRead == -1) {
                        break;
                    }
                    baos.write(abBuffer, 0, nBytesRead);
                }
                /* Here's the byte array everybody wants.
                 */
                byte[] abAudioData = baos.toByteArray();

               // double baslangic = abBuffer.length * oranBaslangic;
               // double bitis = abBuffer.length * oranSon;

                byte[] splittedAudio = new byte[(int) (endTime - startTime)];
                for (int i = 0; i < (int) (endTime- startTime); i++) {
                    splittedAudio[i] = abAudioData[i + (int) startTime];
                }
                ByteArrayInputStream bais = new ByteArrayInputStream(splittedAudio);
                AudioInputStream outputAIS = new AudioInputStream(bais, audioFormat,
                        splittedAudio.length / audioFormat.getFrameSize());

                AudioSystem.write(outputAIS, targetFileType, outputFile);

        } catch (UnsupportedAudioFileException e) {

        } catch (IOException e) {

        }

    }
}
