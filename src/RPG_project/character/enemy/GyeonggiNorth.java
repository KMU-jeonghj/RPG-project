package RPG_project.character.enemy;

import java.util.Random;

public class GyeonggiNorth extends Enemy {
    Random rand = new Random();

    private int resist; //설득도 변수 설명과 다르게 0이되면 설득

    public GyeonggiNorth() {
        super("경기도 북부 연합", 450, 400, 420);
        this.credReward = 400;
        this.moneyReward = 500;
        this.resist = 100;
    }

    @Override
    public int enemySkill() {
        System.out.print("경기도 북부 연합 : ");
        int enemySkillNum = rand.nextInt(5);


        int damage = 0;
        switch (enemySkillNum) {
            case 0:
                System.out.println("[고양시 고양이 패거리의 할퀴기 시전]");
                damage = 90;
            case 1:
                System.out.println("[가평군 빠지 패거리의 수중 공격 시전]");
                damage = 100;
            case 2:
                System.out.println("[의정부시 부대찌개 패거리의 햄 던지기 시전]");
                damage = 115;
            case 3:
                System.out.println("[구리시 구리선으로 목 조르기 시전]");
                damage = 125;
            case 4:
                System.out.println("[포천시 빨간버스 패거리의 질주 시전]");
                damage = 130;

        }
        return damage;
    }
}
