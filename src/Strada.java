import java.util.Vector;

/**
 * Un obiect de tip Strada reprezinta un arc in Graful nostru
 * Aceasta clasa contine punctul de start, de sfarsit, costul
 * gabaritul maxim si un vector de ambuteiaje ce apar pe parcurs
 */
public class Strada {
    private final String start;
    private final String end;
    private final int cost;
    private final int size;
    private Vector <Ambuteiaj> ambs = new Vector<>();

    /**
     * Functie ce adauga un ambuteiaj la vectorul de ambuteiaje
     * @param amb ambuteiajul adaugat
     */
    public void addAmb(Ambuteiaj amb) {
        this.ambs.add(amb);
    }
    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }

    Strada(String start, String end, int cost, int size){
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.size = size;
    }

    /**
     * Aceasta functie calculeaza costul total luand in calcul
     * tipul vehiculului, costul strazii si costul total al
     * ambuteiajelor
     */
    public int costTotal (Vehicul v){
        int c = v.getCost() * this.cost;
        for (Ambuteiaj amb : ambs) {
            c = c + amb.getCost();
        }
        return c;
    }
}
