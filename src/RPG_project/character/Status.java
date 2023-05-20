package RPG_project.character;

public class Status {


    void showBattleStat(Hero hero, Gangster g1, Gangster g2) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",g1.getName(), g1.getGangCnt(), g1.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t\t%s | HP [%d / %d]\n\n",
                g2.getName(), g2.getGangCnt(), g2.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp());
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
