import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/** Clasa principala a temei
 */
public class Tema {
    public static void main(String[] args) throws IOException {
        File fhandle = new File("map.in");
        Scanner scan = new Scanner(fhandle);

        int nrStreets = scan.nextInt();
        int nrNodes = scan.nextInt();

        Graf gr = new Graf(nrStreets, nrNodes);

        Vehicul a = new Autoturism();
        Vehicul b = new Bicicleta();
        Vehicul c = new Camion();
        Vehicul m = new Motocicleta();

        // Adaugam strazile in graf
        for (int i = 0; i < nrStreets; i++) {
            String auxStr = scan.nextLine();
            if (auxStr.length() < 1) {
                i--;
                continue;
            }

            String[] auxStrList = auxStr.split(" ", -1);
            gr.addStreet(auxStrList[0], auxStrList[1], Integer.parseInt(auxStrList[2]), Integer.parseInt(auxStrList[3]), i);

        }

        // Citim restul comenzilor
        while (scan.hasNextLine()) {
            String auxStr = scan.nextLine();
            String[] auxStrList = auxStr.split(" ", -1);

            if (auxStrList[0].equals("accident") || auxStrList[0].equals("trafic") || auxStrList[0].equals("blocaj")) {
                gr.addRestriction(auxStrList[0], auxStrList[1], auxStrList[2], Integer.parseInt(auxStrList[3]));
            } else if (auxStrList[0].equals("drive")) {

                switch (auxStrList[1]) {
                    case "a" -> gr.drive(a, auxStrList[2], auxStrList[3]);
                    case "b" -> gr.drive(b, auxStrList[2], auxStrList[3]);
                    case "c" -> gr.drive(c, auxStrList[2], auxStrList[3]);
                    default -> gr.drive(m, auxStrList[2], auxStrList[3]);
                }
            }
        }


    }
}
