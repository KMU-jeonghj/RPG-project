package RPG_project.character;

import java.util.Scanner;



public class Stage {
    Scanner input = new Scanner(System.in);

    private Enemy enemyNow; //현재 싸우고 있는 적 패거리

    private Enemy[] EnemyArr;

    private int stageCnt;

    public void setEnemyNow(Enemy enemyNow) {
        this.enemyNow = enemyNow;
    }

    public void setStageCnt(int stageCnt) {
        this.stageCnt = stageCnt;
    }

    public Enemy getEnemyNow() {
        return enemyNow;
    }

    public int getStageCnt() {
        return stageCnt;
    }
    //Enemy 객체 생성해서 여기에 배열로 저장
    //스테이지 카운트 변수
    //전투 메소드

    public void battle(Hero hero, Gangster g1, Gangster g2, Status stat) {
        while(true) {
            System.out.println("input");
            if (input.next() == "-1") break;
            stat.showBattleStat(hero, g1, g2);

            System.out.println("Hero 공격");
            g1.attacked(g2, hero);
            stat.showBattleStat(hero, g1, g2);
            if (g1.isZeroGang()) break;

            System.out.println("Enemy 공격");
            g2.attacked(g1, hero);
            stat.showBattleStat(hero, g1, g2);
            if (g2.isZeroGang()) break;
        }
    }
}
