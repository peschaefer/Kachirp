//package edu.bsu.cs222;
//
//import javax.sound.sampled.*;
//import java.io.File;
//import java.io.IOException;
//
//public class SoundPlayer {
//    Clip clip;
//    AudioInputStream soundStream;
//
//    //Licensed under Attribution Noncommercial Creative Commons.
//    //Created by Mellau @ https://freesound.org/people/Mellau/
//    String buttonClickSoundPath = "src/main/resources/506054__mellau__button-click-1.wav";
//
//    public void playButtonClick(){
//        try {
//            soundStream = AudioSystem.getAudioInputStream(new File(buttonClickSoundPath).getAbsoluteFile());
//            clip = AudioSystem.getClip();
//            clip.start();
//
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            e.printStackTrace();
//        }
//    }
//}
