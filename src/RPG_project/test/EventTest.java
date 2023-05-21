package RPG_project.test;

import RPG_project.event.*;

import javax.sound.sampled.LineUnavailableException;

public class EventTest {
    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        Beep beep = new Beep();
        beep.playSong();
        Event event = new Event();
        event.eventSong();
    }
}
