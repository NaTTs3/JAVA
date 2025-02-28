package sk.upjs.paz;

import java.util.Arrays;

/**
 * Trieda realizujuca dynamicke pole (zoznam) cisel.
 */
public class NumberList {
    //Hodnotenie: konstruktory a metody bez uvedeneho hodnotania celkom 3 body

    private int[] numbers;

    /**
     * Konstruktor zoznamu cisel - vytvori prazdny zoznam
     */
    public NumberList() {
        numbers = new int[0];
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA pola
     * @param numbers pole, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers,numbers.length);
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA ineho zoznamu
     * @param numberList zoznam, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(NumberList numberList) {
        this.numbers = Arrays.copyOf(numberList.numbers, numberList.numbers.length);
    }

    /**
     * Vrati cislo aktualne ulozene na zadanom indexe v zozname
     * @param index index prvku zoznamu, ktoreho hodnotu chceme vratit
     * @return cislo na zadanom indexe v zozname
     */
    public int get(int index) {
        return numbers[index];
    }

    /**
     * Nastavi hodnotu prvku zoznamu na zadanom (uz existujucom) indexe
     * @param index index prvku
     * @param value nova hodnota pre prvom na zadanom indexe
     */
    public void set(int index, int value) {
        numbers[index] = value;
    }

    /**
     * Prida na koniec zoznamu novy prvok so zadanou hodnotou
     * @param value hodnota prvku pridaneho na koniec zoznamu
     */
    public void add(int value) {
        int[] pomocnePole = new int[numbers.length + 1];
        System.arraycopy(numbers,0,pomocnePole,0,numbers.length);
        pomocnePole[pomocnePole.length - 1] = value;
        numbers = pomocnePole;
    }

    /**
     * Vrati aktualny pocet prvkov v zozname cisel
     * @return pocet prvkov v zozname cisel
     */
    public int size() {
        return numbers.length;
    }

    /**
     * Vyprazdni zoznam
     */
    public void clear() {
        numbers = new int[0];
    }

    /**
     * Odstrani zo zoznamu prvok na zadanom indexe a vrati hodnotu odstraneneho prvku
     * @param index index odstranovaneho prvku v zozname
     * @return hodnota odstranovaneho prvku v zozname
     */
    public int remove(int index) {
        int hodnotaNaIndexe = numbers[index];
        int[] pomocnePole = new int[numbers.length - 1];
        System.arraycopy(numbers,0,pomocnePole,0,index-1);
        System.arraycopy(numbers,index + 1, pomocnePole, index, numbers.length - index);
        numbers = pomocnePole;
        return hodnotaNaIndexe;
    }

    /**
     * Vrati obsah zoznamu vo forme formatovaneho retazca [prvok1, prvok2, prvok3, prvok4]
     */
    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
