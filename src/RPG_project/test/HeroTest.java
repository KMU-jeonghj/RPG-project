package RPG_project.test;

import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.Text;
import RPG_project.item.Inventory;

public class HeroTest {
    public static void main(String[] args) {
        Hero hero = new Hero("hero");
        NightGang nightGang = new NightGang("nightGang", 30, 30, 30);
        Enemy e1 = new Enemy("enemy1", 100, 40, 10);
        Enemy e2 = new Enemy("enemy2", 100, 30, 10);
        Enemy e3  = new Enemy("e3", 500, 20, 20);
        Status stat = new Status();
        Inventory inven = new Inventory();
        Stage stage = new Stage();
        Text text = new Text();
        nightGang.nightChoice(stage, hero, e1, e2, stat, inven, text);

    }
}
