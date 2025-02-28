package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		KorytnaciSvet kr = new KorytnaciSvet();
		ObjectInspector oi = new ObjectInspector();
		oi.inspect(kr);
	}
}