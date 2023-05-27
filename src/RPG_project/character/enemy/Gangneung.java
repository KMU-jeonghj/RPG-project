package RPG_project.character.enemy;

import RPG_project.character.*;


import java.util.Random;
import java.util.Scanner;

public class Gangneung extends Enemy implements NegoEnemy{

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    public Gangneung() {
        super("강릉 바다뷰", 140 , 160, 110);
        this.credReward = 170; this.moneyReward = 220;
        this.resist = 100;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("강릉 바다뷰 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[바닷물 대포 시전]");
                damage = 47;
            case 1:
                System.out.println("[갓잡은 해산물 던지기 시전]");
                damage = 52;
            case 2:
                System.out.println("[강릉 모래 흩뿌리기 시전]");
                damage = 44;
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
        System.out.println("1. 강릉은 역시 뷰가 멋있어... 이곳 패거리와 손잡는 건 오랜 꿈이었어..."
                + "\n2. 강릉? 그런 지역은 처음 듣지만 산하로 받아주지\n");

        int line = input.nextInt();
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

        //두번째 선택
        System.out.printf("\n%s의 두목 : 우리 강릉이 너희 패거리에 들어가면 우리에겐 도움될 게 없다!!\n", this.name);
        input.nextLine();
        System.out.printf("\n%s : 그건.. 그야..\n", hero.getName());
        input.nextLine();

        System.out.printf("\n%s의 회유 거절 확률 : %d%%\n", this.name, this.resist);
        System.out.println("1. 하지만 나에게는 도움이 되지!!"
                + "\n2. 우리 패거리에 들어오면... 전국을 통합할 때 함꼐하게 될 거야\n");

        line = input.nextInt();
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

        //세번째 선택
        System.out.printf("\n%s의 두목 : ...\n", this.name);
        input.nextLine();

        System.out.printf("\n%s의 회유 거절 확률 : %d%%\n", this.name, this.resist);
        System.out.println("1. 여기는 뷰가 참 좋아. 우리 밑에서 번 돈으로 리조트를 지으면 수완이 괜찮겠군..."
                + "\n2. 어차피 합쳐질 패거리, 우리 패거리로 와라!!\n");

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

        if (this.resist == 0)  {
            System.out.printf("%s의 두목: ... 잘 부탁하네...\n", this.name);
            input.nextLine();
            System.out.println("회유에 성공했다!");
            input.nextLine();
            zeroGangCnt();
            giveReward(nightGang, hero); //경험치 지급
        }
        else {
            System.out.printf("%s의 두목: 우리는 강릉의 자존심. 못들은 거로 하겠네\n", this.name);
            input.nextLine();
            System.out.println("회유에 실패했습니다...");
            input.nextLine();
            //계속 전투 진행
        }
    }
}
