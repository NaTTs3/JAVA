package sk.upjs.paz;

import java.util.*;

public class ZoznamOdberov {

    /**
     * List reprezentujuci zoznam odberov
     */
    private List<Odber> odbery;

    /**
     * Konstruktor zoznamu odberov vytvori prazdny ArrayList
     */
    public ZoznamOdberov() {
        odbery = new ArrayList<>();
    }

    /**
     * Pridavanie odberu do list-u
     */
    public void pridaj(Odber o) {
        odbery.add(o);
    }

    /**
     * Metoda vrati, kolko odberov sa vykonalo na odbernom mieste zdanom parametrom
     *
     * @param odberneMiesto cislo odberneho miesta
     * @return pocet odberov, ktore sa vykonali na odbernom mieste odberneMiesto
     */
    public int pocetOdberovNaMieste(int odberneMiesto) {
        int pocet = 0;
        for (Odber o : odbery) {
            if (o.getOdberneMiesto() == odberneMiesto) {
                pocet++;
            }
        }
        return pocet;
    }

    /**
     * Metoda vrati zoznam mien pozitivne testovanych. Mena sa nenachadzaju na zozname dupliticne
     *
     * @return zoznam mien pozitivne testovanych, bez duplicit
     */
    public List<String> pozitivneTestovani() {
        Set<String> mena = new HashSet<>();
        for (Odber o : odbery) {
            if (o.getVysledok()) {
                mena.add(o.getMenoZamestnanca());
            }
        }
        return new ArrayList<>(mena);
    }

    /**
     * Metoda vrati priemerny pocet testovanych za den testovania.
     * Ak testujeme v pondelok 30.11. a piatok 4.12., tak sú to dva dni,
     * pocas ktorych sa testovalo.
     *
     * @return priemerny pocet testovanych za den testovania
     */
    public double priemernyPocetTestovZaDenTestovania() {
        Map<String, Integer> dni = new HashMap<>();
        for (Odber o : odbery) {
            //zvysi v mape hodnotu o jedna pre dany datum
            dni.put(o.getDatumOdberu(), dni.getOrDefault(o.getDatumOdberu(), 0) + 1);
        }

        int pocetDni = 0;
        int pocetTestov = 0;
        for (int pocet : dni.values()) {
            pocetTestov += pocet;
            pocetDni++;
        }
        if (pocetDni == 0) {
            return 0;
        }
        return (double) pocetTestov / pocetDni;
    }

    /**
     * Metoda vrati zoznam mien vsetkych testovanych, ktori sa zucastnili odberu v rozmedzi datumov. Mena sa nenachadzaju na zozname dupliticne
     *
     * @param odDatum datum zaciatku, vratane tohto datumu
     * @param doDatum datum konca, vratane tohto datumu
     * @return mena testovanych v rozmedzi datumov
     */
    public List<String> testovaniOdDo(String odDatum, String doDatum) {
        Set<String> mena = new HashSet<>();
        int odDat = datumNaCislo(odDatum);
        int doDat = datumNaCislo(doDatum);
        for (Odber o : odbery) {
            int datum = datumNaCislo(o.getDatumOdberu());
            if (datum >= odDat && datum <= doDat) {
                mena.add(o.getMenoZamestnanca());
            }
        }
        return new ArrayList<>(mena);
    }

    private int datumNaCislo(String datum) {
        String[] casti = datum.split("\\.");
        String den = String.format("%02d", Integer.parseInt(casti[0]));
        String mesiac = String.format("%02d", Integer.parseInt(casti[1]));
        String rok = casti[2];
        return Integer.parseInt(rok + mesiac + den);
    }

    /**
     * Metoda vrati mapu, kde je kazdemu menu priradene kolko testov absolvoval
     *
     * @return mapa osob a ich poctu absolvovanych testov
     */
    public Map<String, Integer> pocetTestovOsoby() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Odber o : odbery){
            mapa.put(o.getMenoZamestnanca(),mapa.getOrDefault(o.getMenoZamestnanca(),0)+1);
        }
        return mapa;
    }

    /**
     * Metoda vrati zoznam mien pozitivne testovanych, ktori mali aspon 2 pozitivne testy. Mena sa nenachadzaju na zozname dupliticne.
     *
     * @return zoznam mien tych, ktori boli pozitivne testovani aspon dvakrat, bez duplicity mien
     */
    public List<String> opakovanePozitivny() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Odber o : odbery){
            if (o.getVysledok()) {
                mapa.put(o.getMenoZamestnanca(),mapa.getOrDefault(o.getMenoZamestnanca(),0) + 1);
            }
        }
        List<String> vysledok = new ArrayList<>();
        for (Map.Entry<String, Integer> m : mapa.entrySet()) {
            if(m.getValue() >= 2) {
                vysledok.add(m.getKey());
            }
        }
        return null;
    }

    /**
     * Metoda vrati, ci zamestnanec prekonal nakazu. To znamena, ze mal pozitivny test v nejaky den a negativny neskor.
     *
     * @param menoZamestnanca
     * @return
     */
    public boolean prekonalNakazu(String menoZamestnanca) {
        boolean malPozit = false;
        for (Odber o : odbery) {
            if (o.getMenoZamestnanca().equals(menoZamestnanca)) {
                if (o.getVysledok()) {
                    malPozit = true;
                } else if (malPozit) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metoda vrati zoznam tych mien z vyberu zamestnancov, ktori este neabsolvovali ziaden odber.
     *
     * @param vyberZamestnancov
     * @return novy zoznam vytvoreny zo zoznamu vyberZamestancov, bez zamestancov, ktori uz absolvovali odber
     */
    public List<String> bezOdberu(List<String> vyberZamestnancov) {
        Set<String> otestovani = new HashSet<>();
        for (Odber o : odbery) {
            otestovani.add(o.getMenoZamestnanca());
        }
        List<String> vysledok = new ArrayList<>();
        for (String z : vyberZamestnancov) {
            if (!otestovani.contains(z)){
                vysledok.add(z);
            }
        }
        return vysledok;
    }

    /**
     * Metoda vrati zoznam mien zamestnancov, ktori mali pocas toho isteho dna pozitivny aj negativny test. Mena sa nenachadzaju na zozname dupliticne.
     *
     * @return zoznam mien tych, ktori pocas jedneho dna mali pozitivny aj negativny test
     */
    public List<String> podozrivoTestovani() {
        // ??? (1 bod)
        // hint: vyuzite dvojicu menoZamestnanca datumOdberu
        return null;
    }

    /**
     * Metoda vrati cislo odberneho miesta, kde sa vykonalo najviac odberov. Ak je takychto pracovisk viac, tak vrati ktorekolvek z nich.
     *
     * @return cislo pracoviska, ktore vykonalo najviac odberov
     */
    public int najvytazenejsiePracovisko() {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (Odber o : odbery) {
            mapa.put(o.getOdberneMiesto(), mapa.getOrDefault(o.getOdberneMiesto(),0) + 1);
        }

        int maxPocet = 0;
        int najvytazenejsieMiesto = -1;
        for (Map.Entry<Integer,Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > maxPocet) {
                maxPocet = entry.getValue();
                najvytazenejsieMiesto = entry.getKey();
            }
        }
        return najvytazenejsieMiesto;
    }

}