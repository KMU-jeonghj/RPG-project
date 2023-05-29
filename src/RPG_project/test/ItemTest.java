package RPG_project.test;

import RPG_project.Game;
import RPG_project.character.Hero;
import RPG_project.character.NightGang;
import RPG_project.character.Salary;
import RPG_project.character.Stage;
import RPG_project.item.*;

public class ItemTest {
    public static void main(String[] args) {
        Hero hero = new Hero("hero");
        NightGang nightGang = new NightGang("nightGang", 100, 100, 100);
        Shop shop = new Shop();
        Inventory inventory = new Inventory();
        Game game = new Game();
        Stage stage = new Stage();
//        int n = shop.inputInt();
//        System.out.println(n);
        //Item i = shop.sellItem(hero);
        Salary salary = new Salary();
        hero.setJobNow(salary);
        hero.setMoney(999999999);
        game.actChoice(hero, nightGang, stage, inventory);







    }
}
