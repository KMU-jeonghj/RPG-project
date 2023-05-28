package RPG_project.item;

import RPG_project.*;
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
        if (itemList.isEmpty())
            System.out.println("인벤토리가 비었습니다");
        else {
            for (Item i : itemList)
                System.out.printf("no. %d\n %s | %d 개\n", i.getNo(), i.getName(), i.getCnt());
        }
    }

    public void goShop(Shop shop, Hero hero) {
        while (true){
            Item item = shop.sellItem(hero);
            if (item == null) break; //상점 종료
            addItem(item); //아이템 추가
        }
    }

    public void useItem(Hero hero, NightGang nightGang) {
        while(true) {
            printInventory();
            System.out.println("===================");
            System.out.println("사용할 아이템 번호를 입력 하세요\n뒤로가기(-1)");
            if (input.hasNextInt()) { //정수 일시
                int no = input.nextInt();
                if (no == -1) //뒤로가기
                    break;
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

    public void itemChoice(Shop shop, Hero hero, NightGang nightGang, Status status, Stage stage, Game game) {
        System.out.println("\n무엇을 하시겠습니까?\n");
        System.out.println("\t1. 종합쇼핑몰 방문");
        System.out.println("\t2. 인벤토리 보기");
        System.out.println("\t3. 뒤로가기");

        String s = input.nextLine();

        switch(s) {
            case "1" -> {
                goShop(shop, hero);
                itemChoice(shop, hero, nightGang, status, stage, game);
            }
            case "2" -> {
                useItem(hero, nightGang);
                itemChoice(shop, hero, nightGang, status, stage, game);
            }
            case "3" -> game.actChoice(hero, nightGang, status, stage, this); //뒤로가기
            default ->  {
                System.out.println("올바른 값을 입력해 주세요");
                itemChoice(shop, hero, nightGang, status, stage, game);
            }
        }
    }


}

class ItemNoComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) { //아이템 번호를 비교하는 comparator
        return Integer.compare(i1.getNo(), i2.getNo());
    }
}
