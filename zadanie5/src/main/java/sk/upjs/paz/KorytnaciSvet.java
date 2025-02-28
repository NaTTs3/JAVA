package sk.upjs.paz;

import java.awt.event.MouseEvent;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
    /**
     * Referencia na pole korytnaciek
     */
    private Turtle[] korytnacky = null;

    /**
     * Inicializacna metoda (konstruktor)
     */
    public KorytnaciSvet() {
        this.korytnacky = new Turtle[0];
    }

    /**
     * Metoda na pridanie korytnacky na zadanych suradniciach
     */
    public void pridajKorytnacku(int x, int y) {
        Turtle novaKorytnacka = new Turtle();
        this.add(novaKorytnacka);
        novaKorytnacka.setPosition(x, y);

        Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
        System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
        noveKorytnacky[noveKorytnacky.length - 1] = novaKorytnacka;

        this.korytnacky = noveKorytnacky;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
            this.pridajKorytnacku(x, y);
        }
    }

    public void vystrelNaTazisko() {
        double sucX = 0;
        double sucY = 0;
        for (int i = 0; i < this.korytnacky.length; i++) {     //vypocet sumy suradnic
            double X = this.korytnacky[i].getX();
            double Y = this.korytnacky[i].getY();
            sucX = sucX + X;
            sucY = sucY + Y;
        }
        double prX = sucX / this.korytnacky.length;           //vypocet suradnic taziska
        double prY = sucY / this.korytnacky.length;
        for (int i = 0; i < this.korytnacky.length; i++) {          //posielam korytancky do taziska a spat
            double X = this.korytnacky[i].getX();
            double Y = this.korytnacky[i].getY();
            this.korytnacky[i].penDown();
            this.korytnacky[i].moveTo(prX, prY);
            this.korytnacky[i].moveTo(X, Y);
        }
    }

    public int[] histogram(double x, double y, double d) {
        int[] pole = new int[1];
        for (int i = 0; i < this.korytnacky.length; i++) {
            double X = this.korytnacky[i].getX();       //zisti suradnice i-tej korytnacky
            double Y = this.korytnacky[i].getY();
            double vzdialenost = this.korytnacky[i].distanceTo(x, y);          //vzdialenost od bodu c
            int zona = (int) (vzdialenost / d);
            if (zona >= pole.length) {          //zvacsuje pole podobnou sposobom ako v metode pridajKorytnacku
                int[] novePole = new int[zona + 1];
                System.arraycopy(pole, 0, novePole, 0, pole.length);
                pole = novePole;
            }
            pole[zona]++;
        }
        return pole;
    }


    public void doStvorca(double dlzkaStrany) {
        int pocetKoryNaStrane = this.korytnacky.length / 4;
        double startX = (double)this.getWidth()/2 - dlzkaStrany / 2;
        double startY = (double)this.getHeight()/2 - dlzkaStrany / 2;
        for (int i = 0; i < pocetKoryNaStrane; i++) {           //lava vertikalna strana
            double yPosition = startY + (i + 1) * (dlzkaStrany / (pocetKoryNaStrane + 1));
            this.korytnacky[i].setPosition(startX, yPosition);
        }
        for (int i = 0; i < pocetKoryNaStrane; i++) {          //prava vertikalna
            double yPosition = startY + (i + 1) * (dlzkaStrany / (pocetKoryNaStrane + 1));
            this.korytnacky[pocetKoryNaStrane + i].setPosition(startX + dlzkaStrany, yPosition);
        }
        for (int i = 0; i < pocetKoryNaStrane; i++) {           //horna horizontalna
            double xPosition = startX + (i + 1) * (dlzkaStrany / (pocetKoryNaStrane + 1));
            this.korytnacky[2 * pocetKoryNaStrane + i].setPosition(xPosition, startY);
        }
        for (int i = 0; i < pocetKoryNaStrane; i++) {          //dolna horizontalna
            double xPosition = startX + (i + 1) * (dlzkaStrany / (pocetKoryNaStrane + 1));
            this.korytnacky[3 * pocetKoryNaStrane + i].setPosition(xPosition, startY + dlzkaStrany);
        }
    }

}


