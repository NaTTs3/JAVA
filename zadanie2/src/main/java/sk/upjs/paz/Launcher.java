package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		AnimatedWinPane sandbox = new AnimatedWinPane();

		// create new turtle and add it to the "sandbox"
		HomeTurtle franklin = new HomeTurtle();
		sandbox.add(franklin);

		// create new object inspector
		ObjectInspector oi = new ObjectInspector();
		// ask the inspector to inspect "franklin" and "sandbox"
		oi.inspect(franklin);
		oi.inspect(sandbox);

		// you can put other initialization commands here
		sandbox.setAnimationSpeed(AnimatedWinPane.AnimationSpeed.NONE);
//		franklin.setPosition(20,20);
//		franklin.setDirection(150);
		franklin.flagOfSouthKorea(100000,200);
	}
}