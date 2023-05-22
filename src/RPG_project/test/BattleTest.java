package RPG_project.test;

import RPG_project.character.*;
import RPG_project.item.Inventory;

import java.util.Scanner;

public class BattleTest {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Stage stage = new Stage();
        Hero hero = new Hero("hero");
        Enemy e1 = new Enemy("enemy1", 100, 40, 10);
        Enemy e2 = new Enemy("enemy2", 100, 30, 10);
        Enemy e3  = new Enemy("e3", 500, 20, 20);
        //황밸 == 체력 동일, power + def 값 동일
        //gangCnt는 서로 비슷하게
        //위 조건일시 선제 공격 객체가 중후반부터 압도
        Salary salary = new Salary();
        NightGang ng = new NightGang("nightGang", 50, 30, 30);
        Status stat = new Status();
        Inventory inven = new Inventory();

        hero.setJobNow(salary);
        //salary.setMp(25);

        stage.battle(hero, e1, ng, stat, inven);

        //salary.work(hero);
        //salary.skill();

    }
}
