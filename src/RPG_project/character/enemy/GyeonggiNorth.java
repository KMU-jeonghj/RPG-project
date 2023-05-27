package RPG_project.character.enemy;

import RPG_project.character.Hero;
import RPG_project.character.NightGang;
import RPG_project.character.Salary;

import java.util.Random;
import java.util.Scanner;

public class GyeonggiNorth extends Enemy implements NegoEnemy{
    Random rand = new Random();
    Scanner input = new Scanner(System.in);


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


    @Override
    public void debate(Hero hero, NightGang nightGang) {
        String eName = this.name;
        String hName = hero.getName();
        Salary salary = (Salary) hero.getJobNow();

        //첫번째 선택
        System.out.printf("심리적 반발 : %d\n", this.resist);
        System.out.println("1. 다같이 힘을 합쳐 남산 패거리를 물리쳐야 해!\n2. ...순순히 우리 밑으로 들어오라고!!\n");

        int line = input.nextInt();
        if (line == 1) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("심리적 반발 : %d(-%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("심리적 반발 : %d(+%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }

        //두번째 선택
        System.out.printf("\n%s의 두목 : 어째서 그래야 하지?\n", this.name);
        input.nextLine();
        System.out.printf("\n%s : 그건.. 그야..\n", hero.getName());
        input.nextLine();

        System.out.printf("심리적 반발 : %d\n", this.resist);
        System.out.println("1. 이유가 어딨어, 우리가 너네보다 세니까지!!\n2. 1년 전 너의 오른팔 김두팔이 남산패거리에게 살해당했다 들었어\n");

        line = input.nextInt();
        if (line == 2) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("심리적 반발 : %d(-%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("심리적 반발 : %d(+%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }

        //세번째 선택
        System.out.printf("\n%s의 두목 : ...\n", this.name);
        input.nextLine();

        System.out.printf("심리적 반발 : %d\n", this.resist);
        System.out.println("1. 우리와 손을 잡고 남산패거리에게 복수하자!\n2. 할 말 없나 보네 하하하!\n");

        line = input.nextInt();
        if (line == 1) {//정답을 선택하면 심리적 반발이 감소
            System.out.printf("심리적 반발 : %d(-%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            loseResist(salary.getSalesPower());
        }
        else {//오답일시 증가
            System.out.printf("심리적 반발 : %d(+%d)\n",this.resist, salary.getSalesPower());
            input.nextLine();
            gainResist(salary.getSalesPower());
        }


        if (this.resist == 0)  {
            System.out.printf("%s의 두목: ... 좋아, 이번만 손 잡도록 하지...\n", this.name);
            input.nextLine();
            System.out.println("회유에 성공했다!");
            input.nextLine();
            zeroGangCnt();
            giveReward(nightGang, hero); //경험치 지급
        }
        else {
            System.out.printf("%s의 두목: 말도 안되는 소리! 역시 네놈들과 타협은 없다!\n", this.name);
            input.nextLine();
            System.out.println("회유를 실패했습니다...");
            input.nextLine();
            //계속 전투 진행
        }
    }
}
