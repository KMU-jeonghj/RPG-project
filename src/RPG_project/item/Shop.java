package RPG_project.item;

import RPG_project.character.*;

import java.util.Scanner;

public class Shop {
    Scanner input = new Scanner(System.in);

    private Item bacchus = new Item("박카스", 20, 0, 0, 1000, 1,
            "피로회복에는 역시\n[박카스!]\n\nhp 회복 : 20\n-----------------\n가격 : 1000원\n");
    private Item hutgae = new Item("헛개차", 25, 0, 0, 1500, 2,
            "힘찬 하루!\n[헛개차!]\n\nhp 회복 : 25\n-----------------\n가격 : 1500원\n");
    private Item bokbunja = new Item("복분자주", 0 , 30, 0, 3000, 3,
            "최강활력!\n[복분자!]\n\nmp 회복 : 30\n-----------------\n가격 : 3000원\n");
    private Item shinshin = new Item("신신핫파스 스프레이", 0 , 0, 1.2, 5000, 4,
            "뜨겁고 빠른 회복,\n[신신 핫! 파스]\n\n조직원 회복수가 증가합니다.\n--------------------------\n가격 : 5000원\n");
    private Item snakeWine = new Item("특제 뱀술", -1, -1, 0, 12000, 5,
            "힘이 마구마구 솟아난다!\n값어치를 하는 <특제 뱀술>\n\nhp 와 mp를 모두 회복합니다.\n--------------------------\n가격 : 12000원\n");

    private Item picked; //선택한 아이템


    private Item[] items = {null, bacchus, hutgae, bokbunja, shinshin, snakeWine}; //아이템 배열


    public Item getBacchus() {
        return bacchus;
    }

    public Item getHutgae() {
        return hutgae;
    }

    public Item getBokbunja() {
        return bokbunja;
    }

    public Item getShinshin() {
        return shinshin;
    }

    public Item getSnakeWine() {
        return snakeWine;
    }

    public Item[] getItems() {
        return items;
    }


    public boolean isEnoughMoney(Hero hero) {
        return (hero.getMoney() >= picked.getPrice());
    }

    public void showItems() {
        System.out.println("아이템 상점");
        System.out.println("=========================");
        for (int i = 1; i < items.length; i++) {
            System.out.printf("no. %d\n", items[i].getNo());
            System.out.println(items[i].info);
            System.out.println("=========================");
        }
    }


    public Item sellItem(Hero hero) {
        showItems();
        System.out.println("구매할 아이템 번호를 입력하세요:");
        int no = input.nextInt();
        picked = items[no];

        if (isEnoughMoney(hero)) {
            System.out.printf("%s를 구매했습니다.\n", picked.getName());
            return picked;
        }
        else {
            System.out.println("돈이 부족합니다");
            return sellItem(hero); //재귀, 그럼 상점을 아예 나갈려면?
        }
    }



}
