package RPG_project.character;
//Hero 부모 클래스
import java.util.Scanner;


public class Hero {
    public Scanner input = new Scanner(System.in); // Scanner 객체 생성

    private String name;
    private int hp, fullHp, money;

    private Job jobType;
    Job[] jobArr;

    public Hero(String name) {
        this.name = name;
        this.fullHp = this.hp = 100;
        this.money = 0;
    }

    public String getName() {
        return name;
    }

    public int getFullHp() {
        return fullHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public void gainHp(int hp) {
        this.hp += hp;
    }

    public void loseHp(int hp) {
        this.hp -= hp;
    }

    public void gainMoney(int money) {
        this.money += money;
    }

    public void loseMoney(int money) {
        this.money -= money;
    }

    public double getTired() {
        double rate = hp / fullHp;
        if (rate == 0) return -1;
        else return rate;
    }






    //스킬, 직장업무, 이벤트는 상속에서 처리

}
