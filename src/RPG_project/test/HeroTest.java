package RPG_project.test;

import RPG_project.Game;
import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.Text;
import RPG_project.item.Inventory;

public class HeroTest {
    public static void main(String[] args) {
        Hero hero = new Hero("hero");
        Salary salary = new Salary();
        hero.setJobNow(salary);
        NightGang nightGang = new NightGang("nightGang");
        Enemy e1 = new Enemy("enemy1", 100, 25);
        Enemy e2 = new Enemy("enemy2", 100, 20);
        Enemy e3  = new Enemy("e3", 500, 20);
        Status stat = new Status();
        Inventory inven = new Inventory();
        Stage stage = new Stage();
        Text text = new Text();
        Game game = new Game();
        game.showNowStatus(stage, hero, nightGang, inven);
        //nightGang.nightChoice(stage, hero, e1, e2, stat, inven, text);

    }
}
