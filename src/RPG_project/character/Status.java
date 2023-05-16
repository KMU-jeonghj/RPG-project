package RPG_project.character;

public class Status {


    void showBattleStat(Hero hero, Enemy enemy, NightGang nightGang) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",enemy.getName(), enemy.getGangCnt(), enemy.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t\t%s | HP [%d / %d]\n\n",
                nightGang.getName(), nightGang.getGangCnt(), nightGang.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp());
    }
}
