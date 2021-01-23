/**
 * Creem o clasa abstracta Vehicul, urmand sa creem cate o clasa copil
 * pentru fiecare vehicul in parte
 */

public abstract class Vehicul {
    private String tip;
    private int gabarit;
    private int cost;


    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getGabarit() {
        return gabarit;
    }

    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

