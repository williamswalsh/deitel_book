package media;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class AudioPanel extends JFrame {
    public AudioPanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Williams Sound Player");
        this.setSize(300, 200);
        this.setVisible(true);

        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Boards-of-Canada-Dayvan-Cowboy-_High-Quality_.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new AudioPanel();
    }
}
