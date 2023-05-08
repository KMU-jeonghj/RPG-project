package RPG_project.hero;
//Hero 부모 클래스
import java.util.Scanner;
import java.util.Random;


public class Hero {
    static Scanner input = new Scanner(System.in); // Scanner 객체 생성
    static Hero jobType;
    static String name, groupName, rank;
    static int hp, fullHp, mp, fullMp, att, def, money, bullyTired, trust;

    static Hero[] jobArray = new Hero[0];//객체 생성할 때 append
    //static Item[] inventory = new Item[0];

    public void showStatus() {
        System.out.println("------------------");
        System.out.println(name + ", " + groupName + " 소속");
        System.out.println("hp: " + hp + "/" + fullHp);
        System.out.println("mp: " + mp + "/" + fullMp);
        System.out.println("계급: " + rank);
        System.out.println("공격력: " + att);
        System.out.println("방어력: " + def);
        System.out.println("돈: " + money);
        System.out.println("신뢰도: " + trust);
        System.out.println("피로도: " + bullyTired);
        System.out.println("------------------");
    }

    public int attack() {
        int damage = 0;
        return damage;
    }

    public void attacked(int damage) {

    }

    public int skill() {
        //자식 클래스에서 오버라이딩
        return 0;
    }
    public void useItem() {

    }

    public void levelUP() {

    }

    public void jobChoice() {
        System.out.print("직업을 선택하세요\n1.정육점사장 2.영업사원 3.삼류배우\n");
        int n = input.nextInt();
        jobType = jobArray[n];
    }

    //스킬, 직장업무, 이벤트는 상속에서 처리

}
