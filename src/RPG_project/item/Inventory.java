package RPG_project.item;

import RPG_project.Game;
import RPG_project.character.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    Scanner input = new Scanner(System.in);
    //동적 배열에 저장, 번호로 정렬해서 출력
    private ArrayList<Item> itemList = new ArrayList<>();
    private boolean[] having = {false, false, false, false, false, false}; //아이템 소유 여부

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        item.gainCnt(1);//수량 증가
        if (!itemList.contains(item)) {//첫 추가 일시
            having[item.getNo()] = true; //체크
            itemList.add(item);
        }
    }

    public void sortList() { //아이템 번호로 정렬
        Collections.sort(itemList, new ItemNoComparator());
    }



    public void printInventory() { //인벤토리 출력
        for (Item i : itemList) {
            System.out.printf("no. %d\n %s | %d 개\n", i.getNo(), i.getName(), i.getCnt());
        }
    }

    public void goShop(Game game, Shop shop) {

    }

    public void useItem(Hero hero, NightGang nightGang) {
        printInventory();
        System.out.println("===================");
        System.out.println("사용할 아이템 번호를 입력 하세요");
        if (input.hasNextInt()) { //정수 일시
            int no = input.nextInt();
           if (having[no]) {
               Item i = itemList.get(no-1);
               applyItem(i, hero, nightGang); //아이템 효과 적용
                i.loseCnt(1); //수량 감소
            }

            else {
                System.out.println("올바른 범위의 숫자를 입력하세요\n");
                useItem(hero, nightGang);
            }
        }
        else { //정수가 아닐 시
            System.out.println("숫자를 입력하세요\n");
            input.nextLine();
            useItem(hero, nightGang);
        }
    }

    public void applyItem(Item i, Hero hero, NightGang nightGang) { //hp, mp, gang
        if (i.isHp()) {
            if (i.getHp() == -1) {
                System.out.println("hp가 전부 회복되었습니다.");
                System.out.printf("hp : %d(+%d) / %d\n", hero.getHp(), (hero.getFullHp() - hero.getHp()), hero.getFullHp());
                hero.fillHp();
            }
            else {
                System.out.printf("hp : %d(+%d) / %d\n", hero.getHp(), i.getHp(), hero.getFullHp());
                hero.gainHp(i.getHp());
            }
        }
        if (i.isMp()) {
            Job job = hero.getJobNow();
            if (i.getMp() == -1) {
                System.out.println("mp가 전부 회복되었습니다.");
                System.out.printf("mp : %d(+%d) / %d\n", job.getMp(), (job.getFullMp() - job.getMp()), job.getFullMp());
                job.fillMp();
            }
            else {
                System.out.printf("mp : %d(+%d) / %d\n", job.getMp(), i.getMp(), job.getFullMp());
                hero.getJobNow().gainMp(i.getMp());
            }
        }
        if (i.isGang()) {
            System.out.println("다음 턴에 조직원 회복수가 증가합니다.");
            nightGang.setRecoverey(i.getGang());
        }
    }


}

class ItemNoComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) { //아이템 번호를 비교하는 comparator
        return Integer.compare(i1.getNo(), i2.getNo());
    }
}
