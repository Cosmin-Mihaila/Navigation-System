import java.util.Hashtable;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa ce continte implementarea grafului si al algoritmilor
 */
public class Graf {
    private final int nrStreets;
    private final int nrNodes;
    private Strada[] streets;

    /**
     * Folosim dist pentru a salva distantele fata de nodul sursa
     * Folosim path pentru a salva drumurile cele mai scurte
     * fata de nodul sursa
     */
    private Hashtable<String, Integer> dist = new Hashtable<>();
    private Hashtable<String, String> path = new Hashtable<>();

    /**
     * Initializam graful
     * Acesta este implementat folosind lista de arce
     */
    Graf(int streetsCount, int nodesCount) {
        nrStreets = streetsCount;
        nrNodes = nodesCount;
        streets = new Strada[streetsCount];
    }

    /**
     * Functie pentru adaugarea unei strazii in lista de strazi
     *
     * @param start Nodul de start
     * @param end   Nodul de sfarsit
     * @param cost  Costul strazii
     * @param size  Gabaritul maximum al strazii
     * @param n     Numarul strazii
     */
    public void addStreet(String start, String end, int cost, int size, int n) {
        streets[n] = new Strada(start, end, cost, size);
        this.dist.put(end, Integer.MAX_VALUE);
    }


    /**
     * Functie de adaugarea unei restrictii pe o strada specificata
     *
     * @param type  Tipul restrictiei
     * @param start Punctul de plecare al strazii
     * @param end   Punctul de sfarsit al strazii
     * @param cost  Costul aditional al strazii
     */
    public void addRestriction(String type, String start, String end, int cost) {
        Ambuteiaj amb = new Ambuteiaj(type, start, end, cost);
        for (int i = 0; i < this.nrStreets; i++) {
            if (this.streets[i] == null) {
                continue;
            }
            if (this.streets[i].getStart().equals(start) && this.streets[i].getEnd().equals(end)) {
                this.streets[i].addAmb(amb);
            }
        }
    }

    /**
     * Functie ce implementeaza algoritmul Dijkstra
     *
     * @param v     Tipul vehiculului
     * @param start Punctul de start
     * @param end   Punctul de sfarsit
     */

    public void drive(Vehicul v, String start, String end) throws IOException {

        FileWriter myWriter = new FileWriter("map.out", true);
        PriorityQueue queue = new PriorityQueue();

        /**
         * Initializam toate distantele cu maximum
         * Punem in toate caile punctul de start
         */
        for (int i = 0; i < this.nrStreets; i++) {
            this.path.put(streets[i].getStart(), start);
            this.path.put(streets[i].getEnd(), start);
            this.dist.put(streets[i].getEnd(), Integer.MAX_VALUE);
        }


        queue.insert(0, start);
        this.dist.put(start, 0);
        boolean found = false;

        while (!queue.isEmpty()) {
            String currentNodeName = queue.remove().name;

            for (int i = 0; i < nrStreets; i++) {

                /** Verificam daca putem merge pe strada curenta
                 * Verificand gabaritul si lista de adiacenta
                 */
                if (streets[i].getStart().equals(currentNodeName) && streets[i].getSize() >= v.getGabarit()) {

                    String startStr = streets[i].getStart();
                    String endStr = streets[i].getEnd();

                    int totalCost = streets[i].costTotal(v);

                    // Verificam daca noua cale gasita este mai scurta decat ceea anterioara
                    if (this.dist.get(endStr) > this.dist.get(startStr) + totalCost) {
                        this.dist.put(endStr, this.dist.get(startStr) + totalCost);
                        String auxStr = this.path.get(startStr) + " " + endStr;

                        // Verificam daca am gasit o cale catre punctul final
                        if (endStr.equals(end)) {
                            found = true;
                        }

                        // Actualizam calea catre nodul curent
                        this.path.put(endStr, auxStr);
                        queue.insert(this.dist.get(endStr), endStr);
                    }
                }
            }
        }

        if (!found) {
            myWriter.write(start + " " + end + " null\n");

        } else {
            myWriter.write(this.path.get(end) + " " + this.dist.get(end) + "\n");
        }
        myWriter.close();
    }
}
