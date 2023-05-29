package RPG_project;

import RPG_project.character.*;
import RPG_project.item.*;
import RPG_project.event.*;

import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    //객체생성
    private Hero hero;
    private NightGang nightGang;
    private Stage stage = new Stage();
    private Status status = new Status();
    private Shop shop = new Shop();
    private Inventory inventory = new Inventory();
    private Event event = new Event();
    private Text text = new Text();
    //----------------------------------
    //필드 멤버
    private int yearCnt = 0;
    private int year = yearCnt + 1980;

    private boolean isDay = true;
    private boolean isNight = false;

    //-------------------------------

    public void toggleNight() {
        this.isNight = !this.isNight;
    }

    public void isWhen() {
        if (isNight) System.out.println("밤입니다.");
        else System.out.println("낮입니다.");
    }

    public int getYear() {
        return year;
    }

    public void actChoice(Hero hero, NightGang nightGang,  Stage stage, Inventory inventory) {
        if (isNight) System.out.println("[밤]");
        else System.out.println("[낮]");
        System.out.println("\n무엇을 하시겠습니까?\n");
        System.out.println("\t1. 현재상태 출력");
        System.out.println("\t2. 아이템 관련 행동");
        System.out.println("\t3. 출근하기");
        System.out.println("\t4. 조직활동하기");
        System.out.println("\t5. 게임종료하기");

        String s = input.nextLine();
        switch (s) {
            case "1" -> showNowStatus(stage, hero, nightGang, inventory);
            case "2" -> inventory.itemChoice(shop, hero, nightGang, stage, this);
            //출근
            case "3" -> {
                if (isNight) {
                    System.out.println("밤에는 출근할 수 없습니다");
                    actChoice(hero, nightGang,  stage, inventory);
                }
                else {
                    hero.workDay();
                    toggleNight();
                    isWhen();
                    actChoice(hero, nightGang, stage, inventory);
                }
            }
            //조직
            case "4" -> {
                if (!isNight) {
                    System.out.println("낮에는 조직으로 갈 수 없습니다.");
                    actChoice(hero, nightGang,  stage, inventory);
                }
                else {
                    nightGang.nightChoice(stage, hero, null, nightGang,  inventory, text);
                    toggleNight();
                    isWhen();
                    //actChoice() 끝내는 유일한 길
                    //actChoice(hero, nightGang, status,stage, inventory);
                }

            }
            case "5" -> {
                System.out.println("정말 종료하시겠습니까? yes/no");
                s = input.nextLine();
                if (s.equals("yes"))
                    System.exit(0); //게임 종료
                else
                    actChoice(hero, nightGang, stage, inventory);
            }
            default -> {
                System.out.println("올바른 값을 입력해 주세요");
                actChoice(hero, nightGang, stage, inventory);
            }
        }



    }

    public void process() throws LineUnavailableException, InterruptedException {
        text.manual();
        System.out.println("\n");

        //시작 멘트, 주인공 이름, 갱 이름 입력
        System.out.println("주인공의 이름을 입력해 주세요");
        String name = input.nextLine();
        hero = new Hero(name);

        System.out.println("주인공이 속한 패거리의 이름을 입력해 주세요\n");
        name = input.nextLine();
        nightGang = new NightGang(name, 30, 30, 30);

        //턴 시작
        while(this.year <= 2023) {
            System.out.println(this.year + "년\n\n");

            hero.choiceJob(); //직업선택

            event.switchEvent(this.year, hero, nightGang); //이벤트 체크

            //행동 시작
            actChoice(hero, nightGang, stage, inventory);
            //밤 조직활동까지 마치고 탈출

            this.year++;
            nightGang.recoverGang(); //조직원 회복
            nightGang.initRecoveryWeight();//회복 가중치 초기화
        }

    }

    public void showNowStatus(Stage stage, Hero hero, NightGang gang, Inventory inventory) {
        System.out.println("·· ───── ·· ───── ··");
        System.out.println("올해: ["+ this.year +"년]\n"); //Game 클래스의 yearCnt
        System.out.println("계급: [" + gang.getGangRank() +"]");
        System.out.println("신뢰도: [" + gang.getCredibility() +"]");
        System.out.println("자산: [" + hero.getMoney() + "]");
        System.out.println("직업: [" + hero.getJobNow().getJobName()+"]");
        System.out.println("HP: [" + hero.getHp() + "/" + hero.getFullHp() +"]");
        System.out.println("MP: [" + hero.getJobNow().getMp() + "/" + hero.getJobNow().getFullMp() +"]");
        System.out.println("\n[직업별 능력치]");
        System.out.println("영업사원:\t\t[서류가방의 무게: " + hero.getSalary().getCasePower()
                + "\t\t 영업능력: " + hero.getSalary().getSalesPower()+"]");
        System.out.println("정육점 사장:\t[칼날의 날카로움: " + hero.getButcher().getknifePower()
                + "\t\t 고기분신 유사도 " + hero.getButcher().getmeatPower()+"]");
        System.out.println("연기파 배우:\t[스턴트맨의 공격력: " + hero.getActor().getStuntPower()
                + "\t 연기력: " + hero.getActor().getActiingPower()+"]\n");
        System.out.println("[패거리 상태]");
        System.out.printf("조직원 수: [%d / %d]\n", gang.getGangCnt(), gang.getFullGangCnt());
        System.out.printf("현재 스테이지 : [%s]\n", stage.getStageNow()[0].getName());
        System.out.printf("적대 페거리 : [%s]\n",stage.getEnemyNow().getName());
        System.out.println("\n뒤로가기 (-1)");
        String s = input.nextLine();
        if (s.equals("-1"))
            actChoice(hero, gang,  stage, inventory);
        else
            showNowStatus(stage, hero, gang, inventory);


    }

}
