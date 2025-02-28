package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {

    public void centeredSquare(double lengthsize) {           //metodu som zobrala z prveho zadania
        this.penUp();
        this.step(lengthsize / 2);
        this.turn(90);
        this.step(lengthsize / 2);
        for (int i = 0; i < 3; i++) {
            this.turn(90);
            this.step(lengthsize);
        }
        this.turn(90);
        this.step(lengthsize / 2);
        this.turn(90);
        this.step(lengthsize / 2);
        this.turn(180);

    }

    public void squardot(double size) {
        this.penUp();
        while (size > 1) {
            this.setFillColor(Color.lightGray);
            this.dot(size);
            this.setFillColor(Color.gray);
            this.openPolygon();
            this.centeredSquare(Math.sqrt(size * size + size * size));      //dlzka strany stvorca je prepona vypocitana podla pytagorovej vety
            this.closePolygon();
            size = Math.sqrt(size * size - (size * size + size * size) / 4);  //opat cez pytagorovu vetu b^2=c^2-a^2;
        }
    }

    public int divergence(double c) {
        double pomocnaPremenna = 1;
        double A = 0;
        while (A < c) {                              //cyklus trva kym ten sucet je mensi nez dane cislo c
            pomocnaPremenna++;
            if (pomocnaPremenna % 2 == 0) {          //pripocitava sucet radu pre parne n (pomocnu premennu)
                A = A + 1 / pomocnaPremenna;
            } else {                                 //pre neparnu premennu
                A = A + (pomocnaPremenna - 1) / pomocnaPremenna;
            }
        }
        return (int) pomocnaPremenna;
    }

    public boolean isUniDigitNumber(int n) {
        int pomocnaPremenna = n % 10;
        n = n / 10;
        while (n > 1 || n < -1) {                //cyklus prebieha kým |n|>1
            if (n % 10 != pomocnaPremenna) {     //porovnava ci sa zvysok po deleni predchadzajuceho n rovna novemu
                return false;
            }
            pomocnaPremenna = n % 10;
            n = n / 10;
        }
        return true;
    }

    public int countHammingDistance(int number1, int number2) {
        int pomocnaPremenna = 0;
        while (number1 >= 1 || number2 >= 1) {        //cyklus prebieha kym jeden z nich nie je mensi nez 1
            int zvysok1 = number1 % 10;
            int zvysok2 = number2 % 10;
            if (zvysok1 % 10 != zvysok2 % 10) {       // ak sa cisla na rovnakej pozicii nerovnaju pripocitaj pomocnupremennu
                pomocnaPremenna++;
            }
            number1 = number1 / 10;
            number2 = number2 / 10;
        }
        return pomocnaPremenna;
    }

}
