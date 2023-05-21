package RPG_project.character;

import java.util.Random;

public class NightGang extends Gangster{
    Random rand = new Random();
    private double heroAttacked = 0.3;

    //필드멤버
    //-----------------------------------------------------------------
    private String gangRank;
    private String[] rankArr = {"막내", "행동대장", "간부", "부두목", "두목"};

    private Enemy[] enemyArr;//싸울 적을 저장할 배열, 조건을 만족하면 다음 적과 싸울 수 있다.

    private int credibility;
    //------------------------------------------------------------------

    //생성자
    public NightGang(String name, int gangCnt, int power, int def) {
        super(name);
        this.gangCnt = this.fullGangCnt = gangCnt;
        this.power = power;
        this.def = def;
    }
    //------------------------------------------------------------

    //설정자
    //---------------------------------------------------------

    public void setGangRank(String gangRank) {
        this.gangRank = gangRank;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }
    //----------------------------------------------------------

    //접근자
    //----------------------------------------------------------

    public String getGangRank() {
        return gangRank;
    }

    public int getCredibility() {
        return credibility;
    }

    public String[] getRankArr() {
        return rankArr;
    }

    public Enemy[] getEnemyArr() {
        return enemyArr;
    }

    //-----------------------------------------------------------

    public int getSkill(Hero hero) {
        int s = hero.getJobNow().skill();
        return s;
    }

    @Override
    public double attack(Hero hero) {
        int skill = hero.getJobNow().skill();
        double damage = (int)(power * getGangRate()) + skill;
        return damage;

    }

    @Override
    public void attacked(Gangster gang, Hero hero) {
        double damage;
        double given = gang.attack(hero);
        System.out.printf("보낸 데미지 %.1f\n", given);
        System.out.printf("방어 %.1f\n", (weight * def * getGangRate()));
        damage = given - (weight * def * getGangRate());

        if (damage <= 0)  {
            damage = 0;
            System.out.println("MISS!");
        }

        //debug
        System.out.printf("받은 데미지 %.1f\n" ,damage);
        gangCnt -= damage;
        if (gangCnt < 0) gangCnt = 0;
        gangCnt = (int)gangCnt;

        //일정확률로 hero Hp 차감 damage/fullGangCnt 비율만큼
        double randNum = rand.nextDouble();
        if (randNum < heroAttacked) {
            System.out.printf("%s 가 공격받았다!\n", hero.getName());

            double heroDamage = ((double)damage/fullGangCnt) * 100;
            hero.loseHp((int)heroDamage);
            System.out.printf("받은 데미지 %.1f\n", heroDamage);
        }
    }
}
