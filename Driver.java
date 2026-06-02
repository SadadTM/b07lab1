import java.io.File;

public class Driver {
    public static void main(String[] args) throws Exception{
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double [] c1 = {6, -2, 5};
        int [] e1 = {0, 1, 3};
        Polynomial p1 = new Polynomial(c1, e1);
        double [] c2 = {-10, -2, 4, 5, -9};
        int [] e2 = {0, 1, 4, 6, 8};
        Polynomial p2 = new Polynomial(c2, e2);
        Polynomial s = p1.add(p2);
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        if (s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");

        //Lab 2
        Polynomial m = p1.multiply(p2);
        System.out.println("m(1) = "+m.evaluate(1));
        m.saveToFile("f.txt");
        File f = new File("f.txt");
        Polynomial poly = new Polynomial(f);
        System.out.println("poly(1) = "+poly.evaluate(1));

    }
}