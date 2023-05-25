package RPG_project.character;

import java.util.Random;

public class Sebalnakji extends Enemy{

    Random rand = new Random();

    public Sebalnakji() {
        super("세발낙지",30, 20, 20);
        this.credReward = 45;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("세발낙지 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[연속 3회 날라차기 시전]");
                damage = 7;
            case 1:
                System.out.println("[달라붙기 시전]");
                damage = 5;
            case 2:
                System.out.println("[먹물 대포 시전]");
                damage = 6;
        }
        return damage;
    }

    @Override
    public int getCredReward() { //접근자
        return credReward;
    }


    @Override
    public double attack(Hero hero)
    {
        double damage = (int)(power * getGangRate()) + enemySkill();

        return damage;//데미지 리턴
    }

    @Override
    public void attacked(Gangster gang, Hero hero)
    {
        double damaged;
        double given = hero.attack(hero);
        System.out.printf("보낸 데미지 %.1f", given);
        System.out.println("방어 %.1f\n", def);
        damaged = given - def;

        if(damaged <= 0) {
            damaged = 0;
            System.out.println("MISS!");
        }

        enemy.gangCnt -= damaged;
        if ( emeny.gangCnt < 0) gangCnt = 0;
        gangCnt = (int)gangCnt;
    }
}