package RPG_project.character;

public class NightGang extends Gangster{

    //필드멤버
    //-----------------------------------------------------------------
    private String gangRank;
    private String[] rankArr = {"막내", "행동대장", "간부", "부두목", "두목"};

    private Enemy[] enemyArr;//싸울 적을 저장할 배열, 조건을 만족하면 다음 적과 싸울 수 있다.

    private int credibility;
    //------------------------------------------------------------------

    //생성자
    public NightGang(String name) {
        super(name);
        this.gangCnt = this.fullGangCnt = 30;
        this.power = 50;
        this.def = 50;
    }
    //------------------------------------------------------------

    //설정자
    //---------------------------------------------------------

    public void setGangRank(String gangRank) {
        this.gangRank = gangRank;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }
    //----------------------------------------------------------

    //접근자
    //----------------------------------------------------------

    public String getGangRank() {
        return gangRank;
    }

    public int getCredibility() {
        return credibility;
    }

    public String[] getRankArr() {
        return rankArr;
    }

    public Enemy[] getEnemyArr() {
        return enemyArr;
    }

    //-----------------------------------------------------------

    public int getSkill(Hero hero) {
        int skillSum = hero.getJobType().skill();
        return skillSum;
    }

}
