package RPG_project.test;

import RPG_project.character.Hero;
import RPG_project.character.NightGang;
import RPG_project.item.*;

public class ItemTest {
    public static void main(String[] args) {
        Hero hero = new Hero("hero");
        NightGang nightGang = new NightGang("nightGang", 100, 100, 100);
        Shop shop = new Shop();
        Inventory inventory = new Inventory();
//        int n = shop.inputInt();
//        System.out.println(n);
        //Item i = shop.sellItem(hero);

        inventory.addItem(shop.getHutgae());
        inventory.addItem(shop.getHutgae());
        inventory.addItem(shop.getBacchus());
        inventory.printInventory();
        System.out.println();
        inventory.sortList();
        inventory.printInventory();
        System.out.println();
        System.out.println(shop.getHutgae().getNo());
        System.out.println(inventory.getItemList().get(1).getName());
        Item tmp = inventory.getItemList().get(1);
        tmp.setCnt(100);
        System.out.println(shop.getHutgae().getCnt());
        inventory.printInventory();
        inventory.useItem(hero, nightGang);
        inventory.printInventory();




    }
}
