package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTurtle extends Turtle {

    public boolean isWinner(String name, String resultsFilename) {
        File subor = new File(resultsFilename);
        int sucetHlasov = 0;
        int hlasyKandidata = 0;

        try (Scanner sc = new Scanner(subor);) {
            while (sc.hasNextLine()) {
                String riadok = sc.nextLine();
                if (!riadok.isEmpty()) {
                    sucetHlasov += this.pocetHlasovVRiadku(name, riadok);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pocetHlasov;
    }

    public int pocetHlasovVRiadku(String kandidat, String riadok) {
        File subor = new File(riadok.toLowerCase());
        try (Scanner sc = new Scanner(subor)) {
            while (sc.hasNext()) {
                if (sc.next().equals("trump")) {
                    return sc.nextInt();
                }else if (sc.next().equals("biden")) {
                    return sc.nextInt();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


}
