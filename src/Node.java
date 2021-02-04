/**
 * Clasa folosita la coada de prioritati
 * Ce contine numele nodului si distanta fata de nodul sursa
 * Precum si adresa nodului urmator
 */

public class Node {
    public String name;
    public int  dist;
    public  Node urm;

    Node(int dist, String name) {
        this.name = name;
        this.dist = dist;
        this.urm = null;
    }
}
