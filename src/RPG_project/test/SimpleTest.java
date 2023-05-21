package RPG_project.test;


import RPG_project.character.*;

public class SimpleTest {
    public static void main(String[] args) {
        Enemy e = new Enemy("e", 100, 10 , 10);
        int a = (int)(e.getGangCnt() * 0.3);
        System.out.println(a);
    }

}
