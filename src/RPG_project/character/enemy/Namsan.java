package RPG_project.character.enemy;

import java.util.Random;
import java.util.Scanner;

public class Namsan extends Enemy implements BossEnemy{

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    public Namsan() {
        super("남산", 700, 550); //이름, 조직원수, 공격력, 방어력
        this.credReward = 180;
        this.moneyReward = 999_999_999;
    }
    @Override
    public int enemySkill() {
        System.out.print("남산 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch (enemySkillNum) {
            case 0:
                System.out.println("[남산타워의 자물쇠 뜯어 던지기 시전]");
                damage = 180;
                break;
            case 1:
                System.out.println("[남산 케이블카 떨어뜨리기 시전]");
                damage = 220;
                break;
            case 2:
                System.out.println("[남산 '필살기' 시전]");
                damage = 170;
                break;
        }
        return damage;
    }

    public void finalBefore() {
        System.out.println("남산의 두목: 정말 여기까지 올라올 줄은 몰랐습니다.");
        input.nextLine();
        System.out.println("남산의 두목: 그러지말고 저희 밑으로 들어오시죠?");
        input.nextLine();
        System.out.println("역시 거절할 줄 알았습니다.");
        input.nextLine();
        System.out.println("최선을 다 해 싸우도록 하겠습니다...");
        input.nextLine();
        System.out.println("∧__∧\r\n"
                + "( ｀Д´ ）\r\n"
                + "(っ▄︻▇〓┳═☆\r\n"
                + "/　　 )\r\n"
                + "( /￣∪\r\n"
                + "");
    }
    public void finalAfter() {
        System.out.println("깡패 인생 최고의 싸움이었습니다...");
        input.nextLine();
        System.out.println("비록 졌지만... 마지막 싸움이 당신이어서...");
        input.nextLine();
        System.out.println("정말 다행이네요...");
        input.nextLine();
        System.out.println("부디 지금처럼만 깡패생활을 이어가시길... 약속해주세요...");
        System.out.println(".　　　 ／￣￣＼\r\n"
                + "　　 ／／￣(＿/＼\r\n"
                + "　　/　　イ(＿_／)\r\n"
                + "　 /　  　 / (＿_／\r\n"
                + "　/　　／　　 ￣￣￣)\r\n"
                + "／　　　＿／￣￣￣￣\r\n"
                + "　　　／\r\n"
                + "　　／\r\n"
                + "");
    }
}
