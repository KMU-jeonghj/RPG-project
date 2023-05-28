package RPG_project.test;

import RPG_project.Game;
import RPG_project.Game;
import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.Text;
import RPG_project.item.Inventory;

public class GameTest {
    public static void main(String[] args) {
        Game game = new Game();
        Hero hero = new Hero("hero");
        Salary salary = new Salary();
        hero.setJobNow(salary);
        NightGang nightGang = new NightGang("nightGang", 100, 100, 100);
        Status status = new Status();
        Inventory inventory = new Inventory();
        Stage stage = new Stage();

        game.actChoice(hero, nightGang, status, stage, inventory);
        //game.toggleNight();
        //game.actChoice(hero, nightGang, status, stage, inventory);

    }
}
