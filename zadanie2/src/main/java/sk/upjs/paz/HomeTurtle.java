package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {
    public void flagOfSouthKorea(int stepCount, double height) {
        // inicializacne prikazy
        double startX = this.getX();          // zapamatanie si pociatocnych suradnic
        double startY = this.getY();
        double startDir = this.getDirection();

        this.penUp();                          // ram vlajky
        this.setDirection(90);
        this.step(3 * height / 4);
        this.turn(90);
        this.penDown();
        this.setPenColor(Color.black);
        for (int i = 0; i < 2; i++) {
            this.step(height / 2);
            this.turn(90);
            this.step(3 * height / 2);
            this.turn(90);
            this.step(height / 2);
        }
        this.setDirection(startDir);
        this.setPosition(startX, startY);

        for (int i = 0; i < stepCount; i++) {

            this.turn(Math.random() * 360);
            this.step(5);

            if (this.getY() < startY) {                         //podmienka aby hornu cast kruhu farbila na cerveno
                this.setPenColor(Color.red);
            } else {
                this.setPenColor(Color.blue);                   // spodnu cast kruhu na modro
            }
            if (this.distanceTo(startX - height / 8, startY) < height / 8) {             //podmienka na dofarbenie cervenej casti
                this.setPenColor(Color.red);
            }
            if (this.distanceTo(startX + height / 8, startY) < height / 8) {           //dofarbenie modrej casti
                this.setPenColor(Color.blue);
            }

            if (this.distanceTo(startX, startY) > height / 4) {            //podmienka aby korytnacka nevysla z kruhu
                this.step(-5);
            }
        }

        // prikazy, ktore obnovia vychodiskovy stav
        this.setPosition(startX, startY);
        this.setDirection(startDir);
    }

    public void sipka(double sirka, double dlzka) {
        double startX = this.getX();                 //zapamatanie si pociatocnzch suradnic
        double startY = this.getY();
        double startDir = this.getDirection();
        this.penUp();                                 //dvihni pero
        this.openPolygon();                           //sipka
        this.turn(90);
        this.step(sirka / 2);
        this.turn(-90);
        this.step(dlzka);
        this.turn(-30);
        this.step(sirka);
        ;
        this.turn(-120);
        this.step(sirka);
        this.turn(-30);
        this.step(dlzka);
        this.turn(-150);
        this.step(sirka);
        this.turn(120);
        this.step(sirka);
        this.closePolygon();
        this.setPosition(startX, startY);                    //spat do startovacich suradnic
        this.setDirection(startDir);
    }

    public void sipkovnica(int pocetSipok, double sirka, double dlzkaPrvej, double medzera) {
        double startX = this.getX();
        double startY = this.getY();
        double startDir = this.getDirection();
        for (int i = 0; i < pocetSipok; i++) {
            if (i % 2 == 0) {
                this.setFillColor(Color.orange);
            } else {
                this.setFillColor(Color.black);
            }
            this.sipka(sirka, dlzkaPrvej);
            this.step(dlzkaPrvej + medzera);
            dlzkaPrvej = 0.7 * dlzkaPrvej;
        }
        this.setPosition(startX, startY);
        this.setDirection(startDir);
    }
}
