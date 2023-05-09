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
        fullHp = hp = 100;
        money = 0;
    }

    void buyItem() {

    }






    //스킬, 직장업무, 이벤트는 상속에서 처리

}
