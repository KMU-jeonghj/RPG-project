package RPG_project.character.enemy;

import RPG_project.character.*;


import java.util.Scanner;
import java.util.Random;

public class Jangeogui extends Enemy implements NegoEnemy, BossEnemy{

    Scanner input= new Scanner(System.in);
    Random rand = new Random();



    public Jangeogui() {
        super("장어구이", 70 , 65);
        this.credReward = 100;
        this.moneyReward = 18000;
        this.resist = 100;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("장어구이 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[장어 꼬리로 후려치기 시전]");
                damage = 20;
                break;
            case 1:
                System.out.println("[단단한 장어 가시로 찌르기 시전]");
                damage = 25;
                break;
            case 2:
                System.out.println("[장어 먹고 튼튼해진 몸으로 기본 공격 시전]");
                damage = 19;
                break;
        }
        return damage;
    }


    @Override
    public void debate(Hero hero, NightGang nightGang) {
        String eName = this.name;
        String hName = hero.getName();
        Salary salary = (Salary) hero.getJobNow();

        //첫번째 선택
        System.out.printf("\n%s의 회유 거절 확률 : %d%%\n", this.name, this.resist);
        System.out.println("1. 구워먹기 전에 우리 패거리로 들어오게나."
                + "\n2. 장어가 어항 속에서 만족하면 쓰나. 우리와 함께 바다로 가게.");

        int line = input.nextInt();
        if (line == 2) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(-%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(+%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }

        //두번째 선택
        System.out.printf("\n%s의 두목 : 우리는 현재 호남 최고의 패거리다!\n", this.name);
        input.nextLine();
        System.out.printf("\n%s : 하지만..\n", hero.getName());
        input.nextLine();

        System.out.printf("\n%s의 회유 거절 확률 : %d%%\n", this.name, this.resist);
        System.out.println("1. 우리는 호남 말고 전국 최고의 패거리가 될 거다."
                + "\n2. 아니다! 우리가 최고다!\n");

        line = input.nextInt();
        if (line == 1) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(-%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(+%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }

        //세번째 선택
        System.out.printf("\n%s의 두목 : 정말인가...\n", this.name);
        input.nextLine();

        System.out.printf("\n%s의 회유 거절 확률 : %d%%\n", this.name, this.resist);
        System.out.println("1. 동향 사람끼리 잘 해보고 싶군."
                + "\n2. 자네들은 우리 없인 힘들 거야..!\n");

        line = input.nextInt();
        if (line == 1) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(-%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("\n%s의 회유 거절 확률 : %d%%(+%d%%)\n", this.name, this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }

        double rate = (double) (this.resist / 100); //거절 확률
        double randNum = rand.nextDouble(); // 랜덤 생성

        if (randNum > rate)  {
            System.out.printf("%s의 두목: ...좋아 합류하지!\n", this.name);
            input.nextLine();
            System.out.println("회유에 성공했다!");
            input.nextLine();
            zeroGangCnt();
            giveReward(nightGang, hero); //경험치 지급
        }
        else {
            System.out.printf("%s의 두목: 그만하게. 더는 이야기하지 않겠어\n", this.name);
            input.nextLine();
            System.out.println("회유에 실패했습니다...");
            input.nextLine();
            //계속 전투 진행
        }
    }
}
