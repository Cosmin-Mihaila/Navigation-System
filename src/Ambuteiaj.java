/**
 * Clasa ce reprezinta un ambuteiaj aparut pe o strada
 */

public class Ambuteiaj {
    private String tip;
    private String start;
    private String end;
    private int cost;


    Ambuteiaj(String tip, String start, String end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.tip = tip;
    }

    public int getCost(){
        return cost;
    }
}
