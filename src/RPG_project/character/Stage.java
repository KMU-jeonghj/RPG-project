package RPG_project.character;

import RPG_project.item.*;

import java.util.Scanner;



public class Stage {
    Scanner input = new Scanner(System.in);

    private Enemy enemyNow; //현재 싸우고 있는 적 패거리

    private Enemy[] EnemyArr;

    private int stageCnt;

    

    public void setEnemyNow(Enemy enemyNow) {
        this.enemyNow = enemyNow;
    }

    public void setStageCnt(int stageCnt) {
        this.stageCnt = stageCnt;
    }

    public Enemy getEnemyNow() {
        return enemyNow;
    }

    public int getStageCnt() {
        return stageCnt;
    }
    //Enemy 객체 생성해서 여기에 배열로 저장
    //스테이지 카운트 변수
    //전투 메소드

    //-----------------------------------------------------------------------
    public void debate() {//논쟁 메소드, 회유 이벤트시

    }

    public void battle(Hero hero, Gangster enemy, Gangster nightGang, Status stat, Inventory inventory) {

        while(true) {
            boolean esc; //초기화
             esc = battleActChoice(hero, inventory, false); // 1. 싸운다 2. 아이템 3. 설득(영입사원일시) 4.도망간다(큰 피해입고 생존, 신뢰도 감소)
            if (esc) break; // 도망치다 선택시 종료
            stat.showBattleStat(hero, enemy, nightGang);

            System.out.println("Hero 공격");
            enemy.attacked(nightGang, hero);
            stat.showBattleStat(hero, enemy, nightGang);
            if (enemy.isZeroGang()) break;

            System.out.println("Enemy 공격");
            nightGang.attacked(enemy, hero);
            stat.showBattleStat(hero, enemy, nightGang);
            if (nightGang.isZeroGang()) break;
        }
    }
    
    public boolean isSalary(Hero hero) { //영업사원 인지?
        return (hero.getJobNow() instanceof Salary);
    } //영업사원 인지?

    public boolean battleActChoice(Hero hero, Inventory inventory, boolean esc) {
        System.out.println("\n행동을 선택하세요!\n");
        System.out.println("\t1. 싸운다");
        System.out.println("\t2. 인벤토리");
        System.out.println("\t3. 회유 (영업사원일시 가능)");
        System.out.println("\t4. 도망간다 (패거리 수와 주인공 체력에 큰 피해를 입습니다. 신뢰도도 감소합니다.)\n");

        String s = input.next(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (s) {
            case "1" -> esc = false; // 그대로 전투 진행
            case "2" -> {
                inventory.useItem(hero);
                battleActChoice(hero, inventory, esc);//아이템 사용 후 다시 선택
            }
            case "3" -> {
                if (!isSalary(hero)) {//영입사원이 아닐시
                    System.out.println("영업사원일 때만 선택할 수 있습니다.");
                    battleActChoice(hero, inventory, esc);
                }
                else {
                    hero.getSalary().persuade();// 임시, 여기다 설전 메소드 만들기
                }
            }
            case "4" -> {
                esc = true;
                //피해입는 실행문 추가
            } 
            default -> { //잘못 입력시
                System.out.println("올바른 값을 입력해 주세요.");
                battleActChoice(hero, inventory, esc);//재귀 사용
            }
        }
        return esc;
    }
}
