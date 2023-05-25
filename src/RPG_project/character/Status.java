package RPG_project.character;

public class Status {


    void showBattleStat(Hero hero, Gangster enemy, Gangster nightGang) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",enemy.getName(), enemy.getGangCnt(), enemy.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t%s | HP [%d / %d] MP [%d / %d]\n\n",
                nightGang.getName(), nightGang.getGangCnt(), nightGang.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp(),hero.getJobNow().getMp(), hero.getJobNow().getFullMp());
    }
    void showBattleStatTest(Hero hero, Enemy e1, Enemy e2) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",e1.getName(), e1.getGangCnt(), e1.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t\t%s | HP [%d / %d]\n\n",
                e2.getName(), e2.getGangCnt(), e2.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp());
    }
}
