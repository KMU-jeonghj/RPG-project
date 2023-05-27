package RPG_project.test;


import RPG_project.character.*;
import RPG_project.character.enemy.*;
import RPG_project.event.*;
import RPG_project.item.*;
import RPG_project.*;
import java.util.Random;
import java.util.Scanner;

public class SimpleTest {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
            System.out.println(rand.nextInt(10));

        Sebalnakji sebal = new Sebalnakji();
        System.out.println(sebal.getName());
    }

}
