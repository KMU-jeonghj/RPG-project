package RPG_project.event;

import java.util.Scanner; //혼선을 방지하기 위해 필요한 클래스마다 임포트
import RPG_project.character.*; //다른 패키지이므로 import

import javax.sound.sampled.LineUnavailableException;


public class Event {
    Scanner input = new Scanner(System.in); //스캐너 객체 생성
    Beep wedRose = new Beep(); // Beep 객체 생성

    public void switchEvent(int year, Hero hero, Gangster gangster) throws LineUnavailableException, InterruptedException //Game 클래스의 year
    {
        switch(year) {
            case 1985:
                eventSong(); break;
            case 1990:
                eventWar(hero, gangster); break;
            case 1997:
                eventIMF(hero); break;
            case 2002:
                eventWordCup(hero); break;
            case 2008:
                eventchoiceLife(hero, gangster); break;
        }
    }

    public void eventSong() throws LineUnavailableException, InterruptedException {
        wedRose.playSong(); // 만들었는데 전체 코드 고려 안 하고 이름 붙여서 다시 수정해야함
    }

     public void eventWar(Hero hero, Gangster gangster) throws InterruptedException {
        System.out.println("1990년, 정부는 범죄와의 전쟁을 선포하였다.");
        Thread.sleep(200);
        System.out.println("지난 주에는 경쟁 조직 [붉은 손톱]의 두목이 경찰에 끌려갔다.");
        Thread.sleep(200);
        System.out.println("...");
        Thread.sleep(200);
        System.out.println("조직 내 세력이 나뉘었다.");
        Thread.sleep(200);

        System.out.println("[세력1 : 깡패로서 자존심을 굽힐 수 없습니다.]");
        System.out.println("[세력2 : 일단은 굽히고 훗날을 기약해야 합니다.]");
        Thread.sleep(100);

        //입력받기
        System.out.print("1 혹은 2를 입력하세요\n나의 선택은 세력");
        int event90 = input.nextInt();
        int minusMoney;

        if (event90 == 1){
            //설정자 loseGangCnt 와 접근자 getGangCnt 사용
            gangster.loseGangCnt((int)(gangster.getGangCnt() * 0.3));
            System.out.println("무리한 활동으로 인해 조직원의 30%가 수감되었습니다.");
            Thread.sleep(100);
            System.out.println("현재 나의 조직원 수 :" + gangster.getGangCnt() + "명");
            Thread.sleep(100);

            minusMoney = (int)(hero.getMoney() * 0.15);
            hero.loseMoney(minusMoney);
            System.out.println("무리한 활동으로 인해 벌금 " + minusMoney + "이 부과되었습니다.");
            Thread.sleep(100);
            System.out.println("현재 나의 재산 :" + hero.getMoney() + "원");
        } else if(event90 == 2) {
            gangster.loseGangCnt((int)(gangster.getGangCnt()* 0.1));
            System.out.println("당신의 유연한 대처로 조직원의 10%만이 수감되었습니다.");
            Thread.sleep(100);
            System.out.println("현재 나의 조직원 수 :" + gangster.getGangCnt() + "명");
            Thread.sleep(100);

            minusMoney = (int)(hero.getMoney() * 0.07);
            hero.loseMoney(minusMoney);
            System.out.println("무리한 활동으로 인해 벌금 " + minusMoney + "이 부과되었습니다.");
            Thread.sleep(100);
            System.out.println("현재 나의 재산 :" + hero.getMoney() + "원");
        }
    }

    public void eventIMF(Hero hero) throws InterruptedException {
        System.out.println("1997년 국가의 경제가 급격히 기울기 시작했다.");
        Thread.sleep(100);
        System.out.println("모두가 어려운 시기, 아직은 살만한 " + hero.getName() + "은 이자를 걷을지 말지 고민중이다.");
        System.out.println("1. 걷는다 2. 걷지 않는다");
        Thread.sleep(100);

        int choice97 = input.nextInt();

        if(choice97 == 1){
            System.out.println("어려운 시기였지만 "+ hero.getName() +"의 재산은 상승세였다.\n"
                    + "그런 " +hero.getName()+ "를 손가락질하는 이들 또한 생겨났다.");

        } else if (choice97 == 2) {
            hero.loseMoney((int)(hero.getMoney() * 0.1));
            System.out.println(hero.getName() +"의 재산이 10% 감소했다.\n"
                    + "그런 " +hero.getName()+ "를 우러러보는 이들이 생겨났다.");
            System.out.println("현재 나의 재산 :" + hero.getMoney() + "원");
        }

    }

    public void eventWordCup(Hero hero) throws InterruptedException {
        System.out.println("2002년 6월, 한국과 @@@의 경기가 진행 중이다.\n"
                + "(@@@은 2002년 한국과 경기했던 나라 중 랜덤으로 결정됨)");
        Thread.sleep(100);
        System.out.println("한국과 @@@ 중 어느 곳에 재산을 걸 것인가?");
        System.out.print("1. 한국  2. @@@  3. 걸지 않는다: ");
        int choice02 = input.nextInt();

        if(choice02 == 1){
            System.out.println("2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다. ");
            System.out.println(hero.getName() +"의 재산이 30% 증가했다.");

            hero.setMoney((int)(hero.getMoney() * 1.3)); //30% 증가

        } else if (choice02 == 2) {
            System.out.println("2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다. ");
            System.out.println(hero.getName() +"의 재산이 5% 감소했다.");

            hero.loseMoney((int)(hero.getMoney() * 0.05));
        } else if (choice02 == 3) {
            System.out.println("2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다. ");
        }
    }

    public void eventchoiceLife(Hero hero, Gangster gang) throws InterruptedException {
        System.out.println("2008년, " + hero.getName() + "에게 뜻밖의 제안이 들어온다\n"
                + "깡패 인생을 좌우할 선택이니 신중하도록 하자.");
        Thread.sleep(300);
        System.out.println("제1야당 소속 국회의원 김의원 : 자네, 대통령 밑에서 일해볼 생각 없는가?"
                + "\n                                           이번 대선 기간동안 내가 대통령이 되도록 일 좀 처리해주게...");
        Thread.sleep(2000);
        System.out.println("국내 1위 엔터테인먼트 대표 이대표 : 2020년에 k-pop이 빌보드에 진출하기 위해 당신의 도움이 절실해요.");
        Thread.sleep(2000);
        System.out.println(hero.getName() + "이 속한 조직["+gang.getName()+"]의 두목 박제일: "
                + "내 밑에 남아 있거라. 때가 되면 알게 될 것이다.");
        Thread.sleep(5000);
        System.out.println("1. 김의원  2. 이대표  3. 박제일");
        System.out.print("함께할 파트너를 선택하세요 : ");

        int choice08 = input.nextInt();
        System.out.println("2008년 한 해동안 당신은 파트너와 끈끈한 우정을 쌓으며 깡패 커리어를 써나갑니다.");

    }
}
