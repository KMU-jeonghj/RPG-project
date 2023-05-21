package RPG_project.character;

import java.util.Scanner;

public abstract class Job {
    protected Scanner input = new Scanner(System.in);
    protected String jobName;//자식 클래스가 접근 가능하도록 protected 지정
    //protected int jobYear; //특정 직업을 선택한 턴만큼 늘어나는 변수, 고유능력 상승시 가중치로 사용될 수도 있을 것 같아 적어봤습니다.
    protected int mp; //mp로 변경

    public abstract void work(Hero hero);

    public abstract int skill();

    public int normalAttack() {
        int mul = 1;
        return mul * mp;
    }
    //mp 등의 제한 필요
    //->기초 공격을 없애고 mp 늘리는 걸로 가야할듯



}
