package RPG_project.test;

import RPG_project.character.*;
import java.util.Scanner;
public class JobTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hero hero = new Hero("hero");
        Salary salary = new Salary();

        while (true) {
            String s = input.next();
            if (s.equals("-1")) break;
            salary.work(hero);
        }
    }
}
