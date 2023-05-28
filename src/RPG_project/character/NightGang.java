package RPG_project.character;

import RPG_project.character.enemy.*;
import RPG_project.event.*;
import RPG_project.item.*;

import java.util.Random;
import java.util.Scanner;

public class NightGang extends Gangster{
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    private double heroAttacked = 0.3;
    private double recoverey = 1.0; //조직원 회복률

    public boolean isDefaultRecovery() {
        return (recoverey == 1.0);
    }


    //필드멤버
    //-----------------------------------------------------------------
    private String gangRank;
    private String[] rankArr = {"막내", "행동대장", "간부", "부두목", "두목"};

    private Enemy[] enemyArr;//싸울 적을 저장할 배열, 조건을 만족하면 다음 적과 싸울 수 있다.

    private int credibility;

    private boolean avoid = false; //회피 플래그 변수
    private boolean butcherAvoid = false;
    private boolean actorAvoid = false;
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
    
    public void gainCredibility(int credibility) {
        this.credibility += credibility;
    }
    
    public void loseCredibility(int credibility) {
        this.credibility -= credibility;
        if (this.credibility < 0) this.credibility = 0;
    }

    public void setRecoverey(double recoverey) {
        this.recoverey = recoverey;
    }

    public void initRecovery() {
        this.recoverey = 1.0;
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

    public double getRecoverey() {
        return recoverey;
    }

    //-----------------------------------------------------------

    public int getSkill(Hero hero) {
        int s = hero.getJobNow().skill();
        return s;
    }

    @Override
    public double attack(Hero hero) {
        int skill = hero.getJobNow().skill();
        if (skill == -1) butcherAvoid = true;
        if (skill == -2) actorAvoid = true;
        if (skill < 0) skill = 0;

        double damage = (int)(power * getGangRate()) + skill;
        return damage;

    }

    public void acceptDamage(Gangster gang, Hero hero, double damage) {

        if (damage == 0) System.out.println("MISS!");

        System.out.printf("받은 데미지 %.1f\n" ,damage);
        gangCnt -= damage;
        if (gangCnt < 0) gangCnt = 0;
        gangCnt = (int)gangCnt;

        //일정확률로 hero Hp 차감 damage/fullGangCnt 비율만큼
        double randNum = rand.nextDouble();
        if (randNum < heroAttacked) {
            System.out.printf("%s 가 공격받았다!\n", hero.getName());
            //damage를 hp 감소 비율로 적용시켜야하므로 attack()을 코드채로 붙여넣음
            double heroDamage = ((double)damage/fullGangCnt) * 100;
            hero.loseHp((int)heroDamage);
            System.out.printf("받은 데미지 %.1f\n", heroDamage);

        }
    }

    @Override
    public void attacked(Gangster gang, Hero hero) {//hero Hp 차감위해 오버라이드

        //데미지 계산
        double damage;
        double given = gang.attack(hero);
        System.out.printf("보낸 데미지 %.1f\n", given);
        System.out.printf("방어 %.1f\n", (weight * def * getGangRate()));
        damage = given - (weight * def * getGangRate());

        if (damage <= 0) damage = 0;


        double randNum = rand.nextDouble();
        //일정 확률로 회피
        if (butcherAvoid) {
            double rate = (double) (hero.getButcher().getmeatPower()); //회피 확률

            if (randNum >= rate) { //회피 성공!
                System.out.println("MISS!");
                System.out.println("고기분신이 성공적으로 공격을 방어했습니다.");
             }
            else { //회피 실패
                System.out.println("상대가 고기분신에 속지 않았습니다.");
                acceptDamage(gang, hero, damage);
             }

            butcherAvoid = false;//초기화
        }
        else if (actorAvoid) {
            double rate = hero.getActor().getActiingPower();

            if (randNum >= rate) {
                System.out.println("MISS!");
                System.out.println("상대가 눈물연기에 감동했습니다!");
            }

            else {
                acceptDamage(gang, hero, damage);
                System.out.println("상대를 감동시키기에 연기력이 부족했습니다!");
            }

            actorAvoid = false;
        }
        else {
            acceptDamage(gang, hero, damage);
        }
    }

    public void nightChoice(Stage stage, Hero hero, Gangster g1, Gangster g2, Status stat, Inventory inventory, Text text) {
        System.out.println("\n행동을 선택하세요!\n");
        System.out.println("\t1. 세력확장");
        System.out.println("\t2. 수금");
        System.out.println("\t3. 잡담하기");
        System.out.println("\t4. 잠자기\n");

        String s = input.nextLine();
        switch (s) {
            case "1" -> fight(stage, hero, g1, g2, stat, inventory);
            case "2" -> takeMoney(hero);
            case "3" -> chat(text);
            case "4" -> sleep(hero);
            default -> {
                System.out.println("올바른 값을 입력해 주세요.");
                nightChoice(stage, hero, g1, g2, stat, inventory, text);
            }
        }
    }

    public void fight(Stage stage, Hero hero, Gangster g1, Gangster g2, Status stat, Inventory inventory) { //세력확장
        stage.battle(hero, g1, g2, stat, inventory);
    }

    public void takeMoney(Hero hero) { //수금하기
        int money = (int)(this.gangCnt * 1.5);
        hero.gainMoney(money);
    }

    public void chat(Text text) { //잡담
        text.printTextRand(text.getChatScript(), text.getSpeaker1());
        gainCredibility(10); //신뢰도 증가
    }

    public void sleep(Hero hero) {
        hero.gainMoney(50);
    } //잠자기
}
