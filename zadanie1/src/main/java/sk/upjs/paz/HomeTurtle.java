package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {
    public void flower(double radius) {
        this.penUp();
        this.setFillColor(Color.red);
        for (int i = 0; i < 10; i++) {
            this.step(radius);
            this.dot(radius / 2);
            this.step(-radius);
            this.turn(36);
        }
        this.setFillColor(Color.yellow);
        this.dot(radius);
    }

    public void arrow(double size) {
        this.openPolygon();
        this.penUp();
        this.setFillColor(Color.orange);
        this.turn(90);
        this.step(size / 2);
        for (int i = 0; i < 2; i++) {
            this.turn(-120);
            this.step(size);
        }
        this.turn(-120);
        this.step(size / 2);
        this.turn(-90);
        this.closePolygon();
    }

    public void navigationArrow(double size) {
        for (int i = 0; i < 5; i++) {
            this.arrow(size);
            this.step(size / 2);
        }
        this.step(-5 * size / 2);
    }

    public void hexagon(double size) {
        this.penUp();
        this.step(size);
        this.penDown();
        this.turn(120);
        for (int i = 0; i < 6; i++) {
            this.step(size);
            this.turn(360 / 6);
        }
        this.turn(-120);
        this.penUp();
        this.step(-size);
        this.penDown();
    }

    public void beehive(double size) {
        this.setPenColor(Color.green);
        this.hexagon(size);
        this.penUp();
        this.step(2 * size);
        this.turn(120);
        for (int i = 0; i < 6; i++) {
            this.step(size);
            this.penDown();
            this.hexagon(size);
            this.penUp();
            this.step(size);
            this.turn(60);
        }
        this.turn(-120);
        this.step(-2 * size);
    }

    public void smartWatch(double radius, int hh, int mm) {
        this.penUp();
        this.setFillColor(Color.blue);
        this.dot(radius);                      //modry kruh

        this.setFillColor(Color.lightGray);
        this.dot(3 * radius / 4);        //sivy kruh

        this.setPenColor(Color.black);
        for (int i = 0; i < 12; i++) {         //znacky celych hodin
            this.step(radius / 2);
            this.penDown();
            this.step(radius / 4);
            this.penUp();
            this.step(-3 * radius / 4);
            this.turn(30);
        }
        this.penDown();

        this.setDirection(hh * 30 + mm * 0.5);           //hodinova rucicka
        this.setPenWidth(5);
        this.setPenColor(Color.red);
        this.step(radius / 3);
        this.step(-radius / 3);

        this.setDirection(mm * 6);            //minutova rucicka
        this.setPenWidth(3);
        this.step(2 * radius / 3);
        this.step(-2 * radius / 3);

        this.setDirection(0);

        this.setFillColor(Color.blue);       //modry stred
        this.dot(radius / 10);
    }
}
