package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {
        ObjectInspector oi = new ObjectInspector();
//        String s = new String("aaakkooo sa  mmmass");
//        oi.inspect(s);
//        HomeTurtle kory = new HomeTurtle();
//        String n = kory.sanitize(s);
//        System.out.println(n);
//        s.deleteCharAt(2);
//        System.out.println(s.charAt(2));
        ClickPane pane = new ClickPane();
        oi.inspect(pane);
    }
}
