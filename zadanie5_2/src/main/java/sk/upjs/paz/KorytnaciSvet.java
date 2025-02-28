package sk.upjs.paz;

import java.awt.event.MouseEvent;

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

    public void explozia(double x, double y, double sila) {
        for (int i = 0; i < this.korytnacky.length; i++) {
            //pome spocitat vzdialenost kory od miesta exlozie
            double dx = x - this.korytnacky[i].getX();
            double dy = y - this.korytnacky[i].getY();
            double d = Math.sqrt(dx*dx+dy*dy);
            this.korytnacky[i].penUp();
            this.korytnacky[i].setDirectionTowards(x,y);
            this.korytnacky[i].turn(180);
            this.korytnacky[i].step(sila*sila/(d*d*d*d));
        }
    }

}