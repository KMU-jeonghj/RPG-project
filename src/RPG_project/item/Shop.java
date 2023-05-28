package RPG_project.item;

import RPG_project.character.*;

import java.util.InputMismatchException;
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

        System.out.println("구매할 아이템 번호를 입력하세요 (상점 나가기: -1)"); //나가면 메인 선택창 메소드 호출
        if (input.hasNextInt()) {
            int no = input.nextInt();
            if (no == -1) {
                return null; //상점에서 나간다
            }
            else if (1 <= no && no <= 5) //valid num
                picked = items[no];
            else {
                System.out.println("올바른 범위의 숫자를 입력하세요\n");
                return sellItem(hero); //재귀
            }
        }
        else { //정수가 아닐 시
            System.out.println("숫자를 입력하세요\n");
            input.nextLine();
            return sellItem(hero);
        }


        if (isEnoughMoney(hero)) {
            System.out.printf("%s를 구매했습니다.\n돈 : %d(-%d)\n", picked.getName(), hero.getMoney(), picked.getPrice());
            hero.loseMoney(picked.getPrice());//돈 차감
            return picked; //아이템 전달
        }
        else {
            System.out.println("돈이 부족합니다\n");
            return sellItem(hero); //재귀, 그럼 상점을 아예 나갈려면?
        }
    }

    public int inputInt() {
        try {
            if (input.hasNextInt()) {
                int number = input.nextInt();
                return number;

            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            return 0;
        }
    }



}
