package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
//		WinPane sandbox = new WinPane();

		HomeTurtle franklin = new HomeTurtle();
//		sandbox.add(franklin);
//
//		ObjectInspector oi = new ObjectInspector();
//		oi.inspect(franklin);
//		oi.inspect(sandbox);

		int n = franklin.countHammingDistance(191949,9999);
		System.out.println(n);
		
	}
}
