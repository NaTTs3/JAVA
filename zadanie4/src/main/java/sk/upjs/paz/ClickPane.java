package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {
    private int dotCount;
    private double lastX = 0;
    private double lastY = 0;
    private double prveX = 0;
    private double prveY = 0;
    private boolean polygonInProgress = false;

    public void bodka(int x, int y) {
        Turtle kory = new Turtle();
        this.add(kory);
        kory.setPosition(x, y);
        kory.setFillColor(Color.orange);
        kory.dot(10);
        this.dotCount++;
        kory.setDirection(90);
        kory.printCenter(Integer.toString(this.dotCount));
        this.remove(kory);
    }

    public void ciara(int x, int y) {
        Turtle kory = new Turtle();
        this.add(kory);
        kory.setPosition(lastX, lastY);
        kory.setDirectionTowards(x, y);
        kory.penUp();
        kory.step(10);
        kory.penDown();
        kory.setPenColor(Color.black);
        kory.moveTo(x, y);
        this.remove(kory);
        this.lastX = x;
        this.lastY = y;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        if (!polygonInProgress) {
            dotCount = 0;
            prveX = x;
            prveY = y;
            polygonInProgress = true;
        }

        //zisti rozdiel suradnic kliknuteho od prveho
        int dx = x - (int) prveX;
        int dy = y - (int) prveY;

        if (Math.sqrt(dx * dx + dy * dy) < 20 && dotCount > 1) { //ak je vzdialenost kliknuteho od prvych bodov mensia ako polomer, nastav sa do prvych suradnic
            ciara((int) prveX, (int) prveY);
            this.polygonInProgress = false; //ak opat kliknes na prve sur ukonci sa polygon
            return;
        }

        if (dotCount > 0) {
            this.ciara(x,y);
        }

        this.bodka(x,y);

        lastX = x;
        lastY = y;
    }
}
