package RPG_project.character;

import RPG_project.Game;
import RPG_project.character.enemy.*;
import RPG_project.item.*;
import java.util.Scanner;

public class Status {
    Scanner input = new Scanner(System.in);

    public void showBattleStat(Hero hero, Gangster enemy, Gangster nightGang) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",enemy.getName(), enemy.getGangCnt(), enemy.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t%s | HP [%d / %d] MP [%d / %d]\n\n",
                nightGang.getName(), nightGang.getGangCnt(), nightGang.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp(),hero.getJobNow().getMp(), hero.getJobNow().getFullMp());
    }
    public void showBattleStatTest(Hero hero, Enemy e1, Enemy e2) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",e1.getName(), e1.getGangCnt(), e1.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t\t%s | HP [%d / %d]\n\n",
                e2.getName(), e2.getGangCnt(), e2.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp());
    }

    public void showNowStatus(Stage stage, Hero hero, NightGang gang, Inventory inventory, Game game) {
        System.out.println("·· ───── ·· ───── ··");
        System.out.println("올해: ["+ game.getYear() +"년]\n"); //Game 클래스의 yearCnt
        System.out.println("계급: [" + gang.getGangRank() +"]");
        System.out.println("신뢰도: [" + gang.getCredibility() +"]");
        System.out.println("자산: [" + hero.getMoney() + "]");
        System.out.println("직업: [" + hero.getJobNow().getJobName()+"]");
        System.out.println("HP: [" + hero.getHp() + "/" + hero.getFullHp() +"]");
        System.out.println("MP: [" + hero.getJobNow().getMp() + "/" + hero.getJobNow().getFullMp() +"]");
        System.out.println("\n[직업별 능력치]");
        System.out.println("영업사원:\t\t[서류가방의 무게: " + hero.getSalary().getCasePower()
                + "\t\t 영업능력: " + hero.getSalary().getSalesPower()+"]");
        System.out.println("정육점 사장:\t[칼날의 날카로움: " + hero.getButcher().getknifePower()
                + "\t\t 고기분신 유사도 " + hero.getButcher().getmeatPower()+"]");
        System.out.println("연기파 배우:\t[스턴트맨의 공격력: " + hero.getActor().getStuntPower()
                + "\t 연기력: " + hero.getActor().getActiingPower()+"]\n");
        System.out.println("[패거리 상태]");
        System.out.printf("조직원 수: [%d / %d]\n", gang.getGangCnt(), gang.getFullGangCnt());
        System.out.printf("현재 스테이지 : [%s]\n", stage.getStageName());
        System.out.printf("적대 페거리 : [%s]\n",stage.getEnemyNowName());
        System.out.println("\n뒤로가기 (-1)");
        String s = input.nextLine();
        if (s.equals("-1"))
            game.actChoice(hero, gang, this, stage, inventory);
        else
            showNowStatus(stage, hero, gang, inventory, game);


    }

}
