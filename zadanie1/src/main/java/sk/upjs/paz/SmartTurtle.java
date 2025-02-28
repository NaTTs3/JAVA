package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class SmartTurtle extends Turtle {

    public void centeredSquare(double lengthsize) {
        this.penUp();
        this.step(lengthsize / 2);
        this.turn(90);
        this.penDown();
        this.step(lengthsize / 2);
        for (int i = 0; i < 3; i++) {
            this.turn(90);
            this.step(lengthsize);
        }
        this.turn(90);
        this.step(lengthsize / 2);
        this.turn(90);
        this.penUp();
        this.step(lengthsize / 2);
        this.turn(180);

    }

}
