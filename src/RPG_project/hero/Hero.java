package RPG_project.hero;
//Hero 부모 클래스
import java.util.Random;

public class Hero {
    static String name, groupName, rank;
    static int hp, fullHp, mp, fullMp, att, def, money, bullyTired, trust;

    //static Item[] inventory = new Item[0];

    public void show_status() {
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

    //스킬, 직장업무, 이벤트는 상속에서 처리

}
