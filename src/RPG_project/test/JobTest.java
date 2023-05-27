package RPG_project.test;

import RPG_project.character.*;
import java.util.Scanner;
public class JobTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hero hero = new Hero("hero");
        Salary salary = new Salary();
        hero.setJobNow(salary);


        hero.workDay();
    }
}
