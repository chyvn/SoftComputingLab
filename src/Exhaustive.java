import java.util.Scanner;

/**
 * Created by chyvn on 12-01-2017.
 */
public class Exhaustive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a, b, n;

        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();

        float del = (b - a) / n;
        double x = a;
        double x1 = a + del;
        double x2 = x1 + del;
        double fx = f(x);
        double fx1 = f(x1);
        double fx2 = f(x2);
        while (!((fx > fx1) && (fx2 > fx1))) {
            System.out.println("x : " + x + " f(x) : " + f(x) + "x1 : " + x1 + " f(x1) : " + f(x1) + "x2 : " + x2 + " f(x2) : " + f(x2));
            x = x1;
            x1 = x2 + del;
            x2 = x1 + del;
            fx = f(x);
            fx1 = f(x1);
            fx2 = f(x2);
        }
        System.out.println("The final output is : ");
        System.out.println("x : " + x1 + " f(x) : " + f(x1));

    }

    static double f(double x) {
        return (Math.pow((2 * x - 8), 2) + Math.pow((5 * x - 9), 2));
    }
}
