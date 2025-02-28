package sk.upjs.paz;

import sk.upjs.jpaz2.*;
import java.util.*;

public class Launcher {

	public static void main(String[] args) {
		// Vytvorenie zoznamu odberov
		ZoznamOdberov zoznam = new ZoznamOdberov();

		// Vytvárame niekoľko odberov
		Odber odber1 = new Odber("Janko", "30.11.2020", 1, true);
		Odber odber2 = new Odber("Marek", "01.12.2020", 1, false);
		Odber odber3 = new Odber("Peter", "02.12.2020", 2, true);
		Odber odber4 = new Odber("Janko", "02.12.2020", 1, false);
		Odber odber5 = new Odber("Marek", "03.12.2020", 1, true);
		Odber odber6 = new Odber("Marek", "03.12.2020", 2, true);
		Odber odber7 = new Odber("Janko", "03.12.2020", 1, true);

		// Pridanie odberov do zoznamu
		zoznam.pridaj(odber1);
		zoznam.pridaj(odber2);
		zoznam.pridaj(odber3);
		zoznam.pridaj(odber4);
		zoznam.pridaj(odber5);
		zoznam.pridaj(odber6);
		zoznam.pridaj(odber7);

		// Testovanie metódy na počet odberov na mieste
		System.out.println("Počet odberov na mieste 1: " + zoznam.pocetOdberovNaMieste(1)); // Očakávané: 5

		// Testovanie metódy na pozitívne testované osoby
		System.out.println("Pozitívne testovaní: " + zoznam.pozitivneTestovani()); // Očakávané: [Janko, Peter, Marek]

		// Testovanie priemerného počtu testovaných za deň
		System.out.println("Priemerný počet testovaných za deň: " + zoznam.priemernyPocetTestovZaDenTestovania());

		// Testovanie testovaných v rozmedzí dátumov
		System.out.println("Testovaní od 01.12.2020 do 03.12.2020: " + zoznam.testovaniOdDo("01.12.2020", "03.12.2020"));

		// Testovanie počtu testov jednotlivých osôb
		System.out.println("Počet testov jednotlivých osôb: " + zoznam.pocetTestovOsoby());

		// Testovanie opakovane pozitívnych
		System.out.println("Opakovane pozitívni: " + zoznam.opakovanePozitivny());

		// Testovanie, či zamestnanec prekonal nákazu
		System.out.println("Marek prekonal nákazu: " + zoznam.prekonalNakazu("Marek")); // Očakávané: true
		System.out.println("Janko prekonal nákazu: " + zoznam.prekonalNakazu("Janko")); // Očakávané: false

		// Testovanie zamestnancov bez odberu
		List<String> vyberZamestnancov = new ArrayList<>(Arrays.asList("Janko", "Marek", "Peter"));
		System.out.println("Zamestnanci bez odberu: " + zoznam.bezOdberu(vyberZamestnancov));

		// Testovanie podozrivých testovaných (pozitívny a negatívny test v rovnaký deň)
		System.out.println("Podozrivo testovaní: " + zoznam.podozrivoTestovani());

		// Testovanie najvyťaženejšieho pracoviska
		System.out.println("Najvyťaženejšie pracovisko: " + zoznam.najvytazenejsiePracovisko()); // Očakávané: 1
	}

}