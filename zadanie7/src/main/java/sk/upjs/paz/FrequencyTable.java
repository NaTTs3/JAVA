package sk.upjs.paz;

public class FrequencyTable {

    //budem mat tabulku s 2 stlpcami kde v prvom bude slovo a v druhom pocet vyskytov
    private String[][] tabulka;

    /**
     * Konstruktor: vytvori prazdnu frekvencnu tabulku
     */
    public FrequencyTable() {
        tabulka = new String[1][2];
    }

    /**
     * Vyprazdni obsah tabulky (vratene vlozenych slov)
     */
    public void clear() {
        tabulka = new String[1][2];
    }

    /**
     * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
     * vrati 0
     *
     * @param word retazec, ktoreho pocet vyskytov chceme zistit
     * @return pocet vyskytov zadaneho slova (retazca)
     */
    public int getNumberOfOccurrences(String word) {
        for (int i = 0; i < tabulka.length; i++) {
            if (tabulka[i][0] != null && tabulka[i][0].equals(word)) {
                return Integer.parseInt(tabulka[i][1]);
            }
        }
        return 0;
    }

    /**
     * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo
     * priradene danemu slovu o 1). Ak take slovo sa v tabulke nenachadza,
     * nastavi pocet jeho vyskytov na 1
     *
     * @param word slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
     */
    public void addOccurrence(String word) {
        //pred zapisanim prveho slova je na oboch poziciach v tabulke null preto pre prve slovo:
        if (tabulka[0][0] == null){
            tabulka[0][0] = word;
            tabulka[0][1] = "1";
            return;
        }

        //ak uz tam to dane slovo je a chcem len pripocitat k poctu
        for (int i = 0; i < tabulka.length; i++) {
            //hladaj slovo
            if (tabulka[i][0].equals(word)) {
                //pretypujem string z pola na int
                int cislo = Integer.parseInt(tabulka[i][1]);
                //pripocitam vyskyt
                cislo += 1;
                //pretypujem naspat na string a referencujem na spravnu poziciu
                tabulka[i][1] = String.valueOf(cislo);
                return;
            }
        }

        //Ak je treba zaviest do tabulky uplne nove slovo
        String[][] pomocnePole = new String[tabulka.length + 1][2];
        //idem po riadkoch pola tabulka a kopirujem ich do pomocneho Pola
            for (int j = 0; j < tabulka.length; j++) {
                System.arraycopy(tabulka[j], 0, pomocnePole[j], 0, 2);
            }
        //na posledny riadok dam nove slovo
        pomocnePole[pomocnePole.length - 1][0] = word;
        pomocnePole[pomocnePole.length - 1][1] = "1";
        //prereferencujem
        tabulka = pomocnePole;

    }

    /**
     * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
     *
     * @return pocet slov vo frekvencnej tabulke
     */
    public int getWordCount() {
        int sucet = 0;
        if (tabulka[0][1] != null) {
            for (int i = 0; i < tabulka.length; i++) {
                sucet += Integer.parseInt(tabulka[i][1]);
            }
        }
        return sucet;
    }

    /**
     * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
     *
     * @return referencia na novovytvorene pole retazcov so slovami v tabulke
     */
    public String[] getWords() {
        String[] pole = new String[tabulka.length];
        if (tabulka[0][0] != null) {
            for (int i = 0; i < tabulka.length; i++) {
                pole[i] = tabulka[i][0];
            }
        }
        return pole;
    }


    /**
     * Vrati obsah frekvencnej tabulky ako retazec vo formate
     * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (tabulka[0][0] != null) {
            for (int i = 0; i < tabulka.length; i++) {
                sb.append(tabulka[i][0]).append("=").append(tabulka[i][1]);
                if (i < tabulka.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        return "v tabulke je null";
    }
}
