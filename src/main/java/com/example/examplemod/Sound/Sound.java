package com.example.examplemod.Sound;


import com.example.examplemod.ExampleMod;
import com.example.examplemod.chat.Chat;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sound {

    public static double gain = 0.5D; // Volume, number between 0 and 1 (loudest)

    public static void setVolume(double volume) {
        if (volume < 0.0 || volume > 1.0) {
//            Chat.SendMessage("Sorry, Volume can be between 0.0~1.0", "red");
        } else {
//            Chat.SendMessage("Sound volume has set to: " + volume, "red");
            gain = volume;
        }
    }

    public static double getVolume() {
        return gain;
    }

//    public static boolean getState() {
//        return gain;
//    }

    public static void PlayerPlayerHealthSound(int targetHealth_Integer) {
        try {
            String file_name = "";
            if (targetHealth_Integer == 1) file_name = "one.wav";
            else if (targetHealth_Integer == 2) file_name = "two.wav";
            else if (targetHealth_Integer == 3) file_name = "three.wav";
            else if (targetHealth_Integer == 4) file_name = "four.wav";
            else if (targetHealth_Integer == 5) file_name = "five.wav";
            else if (targetHealth_Integer == 6) file_name = "six.wav";
            else if (targetHealth_Integer == 7) file_name = "seven.wav";
            else if (targetHealth_Integer == 8) file_name = "eight.wav";
            else if (targetHealth_Integer == 9) file_name = "nine.wav";
            else if (targetHealth_Integer == 10) file_name = "ten.wav";
            else if (targetHealth_Integer == 11) file_name = "eleven.wav";
            else if (targetHealth_Integer == 12) file_name = "twelve.wav";
            else if (targetHealth_Integer == 13) file_name = "thirteen.wav";
            else if (targetHealth_Integer == 14) file_name = "fourteen.wav";
            else if (targetHealth_Integer == 15) file_name = "fifteen.wav";
            else if (targetHealth_Integer == 16) file_name = "sixteen.wav";
            else if (targetHealth_Integer == 17) file_name = "seventeen.wav";
            else if (targetHealth_Integer == 18) file_name = "eighteen.wav";
            else if (targetHealth_Integer == 19) file_name = "nineteen.wav";
            else if (targetHealth_Integer == 20) file_name = "twenty.wav";

            InputStream bufferedIn = new BufferedInputStream(ExampleMod.class.getResourceAsStream("/assets/sounds/"+file_name));
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(ExampleMod.class.getResourceAsStream("/assets/sounds/"+file_name));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);

            clip.start();
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
    }
}
