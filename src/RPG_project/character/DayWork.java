package RPG_project.character;

public class DayWork {

    public void working(Hero hero) {
        int workCnt = 0;
        while (workCnt != 2) {
            hero.getJobNow().work(hero);
            workCnt++;
        }
    }
}
