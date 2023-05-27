package RPG_project.test;

import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.*;

import javax.sound.sampled.LineUnavailableException;

public class EventTest {
    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        Beep beep = new Beep();
//        beep.playSong();
        Event event = new Event();
//        event.eventSong();
        Text text = new Text();
//        text.printTextRand(text.getChatScript(), text.getSpeaker1());
        Salary salary = new Salary();
        Hero hero = new Hero("hero");
        hero.setJobNow(salary);
        NightGang nightGang = new NightGang("nightGang", 100, 100, 100);
        event.eventWar(hero, nightGang);
        GyeonggiNorth gn = new GyeonggiNorth();
        //gn.debate(hero, nightGang);



    }
}
