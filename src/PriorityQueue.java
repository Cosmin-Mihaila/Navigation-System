/**
 * Coada cu prioritate, unde prioritatea este data de
 * distanta cea mai scurta de nodul sursa
 */
public class PriorityQueue {

    private Node varf =  null;
    private Node coada = null;

    PriorityQueue () {
    }

    public boolean isEmpty(){
        return (this.varf == null);
    }

    /**
     * Metoda ce implementeaza inserarea in coada in locul
     * potrivit prioritatii
     * @param dist Distanta fata de sursa
     * @param name Numele nodului
     */
    public void insert(int dist, String name) {
        Node newNode;
        newNode = new Node(dist, name);

        if (this.varf == null) {
            this.varf = newNode;
            this.coada = newNode;
        }
        else if(this.varf.dist >= newNode.dist) {
            newNode.urm = this.varf;
            this.varf = newNode;

        }
        else if (this.coada.dist < newNode.dist) {
            this.coada.urm = newNode;
            this.coada = newNode;
        }
        else {
            Node aux = this.varf.urm;
            Node parrent = this.varf;
            while(aux.urm != null) {
                if (aux.dist > newNode.dist) break;
                parrent = aux;
                aux = aux.urm;
            }

            parrent.urm = newNode;
            newNode.urm = aux;
        }
    }



    public Node remove() {
        Node aux = this.varf;
        this.varf = this.varf.urm;
        return aux;
    }


}

