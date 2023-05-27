package RPG_project.test;

import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.*;

import javax.sound.sampled.LineUnavailableException;

public class EventTest {
    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        Salary salary = new Salary();
        Hero hero = new Hero("hero");
        hero.setJobNow(salary);
        NightGang nightGang = new NightGang("nightGang", 100, 100, 100);
        Event event = new Event();
        Beep beep = new Beep();
        Text text = new Text();
        GyeonggiNorth gn = new GyeonggiNorth();
        Gangneung gangneung = new Gangneung();
        Jangeogui jangeogui = new Jangeogui();




//        beep.playSong();

        //event.eventSong(hero);

//        text.printTextRand(text.getChatScript(), text.getSpeaker1());

        //event.eventWar(hero, nightGang);

        gn.debate(hero, nightGang);
        gangneung.debate(hero, nightGang);
        jangeogui.debate(hero, nightGang);



    }
}
