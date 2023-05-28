package RPG_project.character;

import RPG_project.character.enemy.*;
import RPG_project.item.*;

import java.util.Scanner;



public class Stage {
    Scanner input = new Scanner(System.in);

    private Enemy enemyNow; //현재 싸우고 있는 적 패거리

    private Enemy[] EnemyArr;

    private int stageNow;

    

    public void setEnemyNow(Enemy enemyNow) {
        this.enemyNow = enemyNow;
    }

    public void setStageNow(int stageNow) {
        this.stageNow = stageNow;
    }

    public Enemy getEnemyNow() {
        return enemyNow;
    }

    public int getStageNow() {
        return stageNow;
    }
    //Enemy 객체 생성해서 여기에 배열로 저장
    //스테이지 카운트 변수
    //전투 메소드

    //-----------------------------------------------------------------------
    public void checkNego(Hero hero, Gangster nightGang, Inventory inventory) {//논쟁 메소드, 회유 이벤트시
        if (isSalary(hero) && isNego()) {
            System.out.printf("%s : 모두 싸움을 멈춰 줘!!!\n\n", hero.getName());
            input.nextLine();
            System.out.println("\n순간, 모두의 이목이 집중된다.\n");
            input.nextLine();
            System.out.printf("\n%s의 두목 : 무슨 말을 하려는거지...?\n\n", enemyNow.getName());
            input.nextLine();
            System.out.printf("%s : 잠시만... 내 말을 들어줘!\n\n", hero.getName());
            input.nextLine();

            ((NegoEnemy) enemyNow).debate(hero, (NightGang) nightGang); //논쟁 시작
        }

        else if (isNego()) {
            System.out.println("영업사원을 선택헸을 때 실행가능합니다.");
            battleActChoice(hero, nightGang, inventory, false);
        }

        else if (isSalary(hero)) {
            System.out.println("회유 가능한 패거리가 아닙니다.");
            battleActChoice(hero, nightGang, inventory, false);
        }

        else {
            System.out.println("영업 사원이 아니고, 회유가능한 패거리가 아닙니다");
            battleActChoice(hero, nightGang, inventory, false);
        }
    }

    public void battle(Hero hero, Gangster enemy, Gangster nightGang, Status stat, Inventory inventory) {

        while(true) {
            boolean esc; //초기화
             esc = battleActChoice(hero, nightGang, inventory, false); // 1. 싸운다 2. 아이템 3. 설득(영입사원일시) 4.도망간다(큰 피해입고 생존, 신뢰도 감소)
            if (esc) break; // 도망치다 선택시 종료
            stat.showBattleStat(hero, enemy, nightGang);

            System.out.printf("%s 공격\n", nightGang.getName());
            enemy.attacked(nightGang, hero);
            stat.showBattleStat(hero, enemy, nightGang);
            if (enemy.isGangZero()) break;

            System.out.printf("%s 공격\n", enemy.getName());
            nightGang.attacked(enemy, hero);
            stat.showBattleStat(hero, enemy, nightGang);
            if (nightGang.isGangZero() || hero.isHpZero()) break;
        }
    }
    
    public boolean isSalary(Hero hero) { //영업사원 인지?
        return (hero.getJobNow() instanceof Salary);
    } //영업사원 인지?
    public boolean isNego() {
        return (enemyNow instanceof NegoEnemy);
    }

    public boolean battleActChoice(Hero hero, Gangster nightGang,Inventory inventory, boolean esc) {
        System.out.println("\n행동을 선택하세요!\n");
        System.out.println("\t1. 싸운다");
        System.out.println("\t2. 인벤토리");
        System.out.println("\t3. 회유 (조건부)");
        System.out.println("\t4. 도망간다 (패거리 수와 주인공 체력에 큰 피해를 입습니다. 신뢰도도 감소합니다.)\n");

        String s = input.nextLine(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (s) {
            case "1" -> esc = false; // 그대로 전투 진행
            case "2" -> {
                inventory.useItem(hero, (NightGang) nightGang);
                battleActChoice(hero, nightGang, inventory, esc);//아이템 사용 후 다시 선택
            }
            case "3" -> checkNego(hero, nightGang, inventory); //회유 조건 체크

            case "4" -> {
                esc = true;
                //피해입는 실행문 추가
                hero.setHp((int)(hero.getHp() * 0.7));//hp 감소
                hero.gainMoney((int) (hero.getMoney() * 0.7));// 돈 감소
                nightGang.setGangCnt((int) (nightGang.getGangCnt() * 0.7));// 조직원 감소

            } 
            default -> { //잘못 입력시
                System.out.println("올바른 값을 입력해 주세요.");
                battleActChoice(hero, nightGang, inventory, esc);//재귀 사용
            }
        }
        return esc;
    }
}
