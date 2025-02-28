package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		AnimatedWinPane sandbox = new AnimatedWinPane();

		// create new turtle and add it to the "sandbox"
//		SmartTurtle franklin = new SmartTurtle();
//		sandbox.add(franklin);

		// create new object inspector
		ObjectInspector oi = new ObjectInspector();
		// ask the inspector to inspect "franklin" and "sandbox"
//		oi.inspect(franklin);
		oi.inspect(sandbox);
//
//		sandbox.setBackgroundColor(Color.white);
//		franklin.setPosition(100, 150);
//		franklin.turn(65);
//
//		franklin.centeredSquare(50);

		HomeTurtle albert = new HomeTurtle();
		sandbox.add(albert);
		oi.inspect(albert);

		albert.beehive(20);

		// you can put other initialization commands here

	}
}