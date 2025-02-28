package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {

    public String removeExtraSpaces(String s) {        //metoda z cvicenia
        StringBuilder pomocnyRetazec = new StringBuilder(s.trim());
        for (int i = 0; i < pomocnyRetazec.length() - 1; i++) {
            if (pomocnyRetazec.charAt(i) == ' ' && pomocnyRetazec.charAt(i) == pomocnyRetazec.charAt(i + 1)) {
                pomocnyRetazec.deleteCharAt(i + 1);
            }
        }
        return pomocnyRetazec.toString();
    }

    public String toEmailAddress(String name) {
        if (name == null) {
            return "retazec je null";                     //kontrola ci nie je retazec null
        }
        name = name.toLowerCase();                       //male pismena
        name = removeExtraSpaces(name);
        name = name.replace(' ', '.');    //nahrad medzery bodkou
        name = name + "@upjs.sk";                         //pridej @upjs.ks
        return name;
    }

    public int countAcronyms(String r) {
        int pocetAcronymov = 0;
        for (int i = 2; i < r.length(); i++) {
            boolean prvePismeno = (r.charAt(i) >= 'A' && r.charAt(i) <= 'Z');                   //podmienky co overuju ci su velke 3 pismena za sebou
            boolean druhePismeno = (r.charAt(i - 1) >= 'A' && r.charAt(i - 1) <= 'Z');
            boolean tretiePismeno = (r.charAt(i - 2) >= 'A' && r.charAt(i - 2) <= 'Z');
            if (prvePismeno && druhePismeno && tretiePismeno) {          //ak idu 3 velke pismena po sebe pridaj pocetAcronymov
                pocetAcronymov++;
                int j = i;
                while ((r.charAt(j) >= 'A') && (r.charAt(j) <= 'Z') && (j < r.length() - 1)) {      //posunie i pomocou j na poziciu kde konci dany acronym
                    j = j + 1;
                }
                i = j;
            }
        }
        return pocetAcronymov;
    }

    public String replaceNumbers(String s, String replacement) {
        StringBuilder pomocnyString = new StringBuilder(s);                       //pomocou StringBuildera
        for (int i = 0; i < s.length(); i++) {                                    //prejde cez vsetky znaky retazca
            if (pomocnyString.charAt(i) <= '9' && pomocnyString.charAt(i) >= '0') {      //ak je znak cislo
                pomocnyString.deleteCharAt(i);                                           //odstrani ynak na pozicii
                pomocnyString.insert(i, replacement.charAt(i));                          //vlozi znak z replacememntu
            }
        }
        return pomocnyString.toString();
    }

    public String sanitize(String s) {
        StringBuilder pomocnyString = new StringBuilder(s);
        int i = 0;
        while (i < pomocnyString.length() - 1) {   // prejde cez vsetky znaky okrem posledneho aby sme neboli out of bounds
            if (pomocnyString.charAt(i) == pomocnyString.charAt(i + 1)) {    //ak je rovnaky znak na i+1 pozicii vymaze ho
                pomocnyString.deleteCharAt(i + 1);
            } else {
                i++;              // na dalsie i sa presunie az ked znak na i+1 je rozdielny
            }
        }
        return pomocnyString.toString();
    }


}


