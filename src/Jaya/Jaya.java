package Jaya;

import java.util.Random;

/**
 * Created by chyvn on 11-04-2017.
 */
public class Jaya {

    public static int MAX_ROUNDS = 100;


    public static void main(String[] args) {
        // Initialize
        double x1[] = {-5, 14, 70, -8, -12};
        double x2[] = {18, 63, -6, 7, -18};

        double fx[] = {0, 0, 0, 0, 0};

        for (int i = 0; i < x1.length; i++) {
            fx[i] = f(x1[i], x2[i]);
        }

        int round = 1;
        // Identify best and worst.
        while (round <= MAX_ROUNDS) {
            double worst = fx[0];
            double best = fx[0];

            int worstIndex = 0;
            int bestIndex = 0;

            for (int i = 0; i < fx.length; i++) {
                if (fx[i] > worst) {
                    worst = fx[i];
                    worstIndex = i;
                }
                if (fx[i] < best) {
                    best = fx[i];
                    bestIndex = i;
                }
            }


            // regenerate new values and replace them.
            double r1 = Math.random();
            double r2 = Math.random();

            System.out.println("Round : " + round + "\n" + "Worst : " + worst + "\n" + "Best : " + best);
            for (int i = 0; i < x1.length; i++) {
                //System.out.println("X1: " + x1[i] + " X2: " + x2[i] + " f(x): " + fx[i]);
                if (x1[i] > 0) System.out.printf("X1:  %.4f", x1[i]);
                else System.out.printf("X1: %.4f", x1[i]);
                if (x2[i] > 0) System.out.printf(" X2:  %.4f", x2[i]);
                else System.out.printf(" X2: %.4f", x2[i]);
                System.out.printf(" f(x): %.4f\n", fx[i]);
            }
            for (int i = 0; i < fx.length; i++) {
                double tempx1 = x1[i] + (r1 * (x1[bestIndex] - Math.abs(x1[i]))) - (r2 * (x1[worstIndex] - Math.abs(x1[i])));
                double tempx2 = x2[i] + (r1 * (x2[bestIndex] - Math.abs(x2[i]))) - (r2 * (x2[worstIndex] - Math.abs(x2[i])));
                double tempfx = f(tempx1, tempx2);

                if (tempfx < fx[i]) {
                    // System.out.println("Value is now better, replacing the old values");
                    x1[i] = tempx1;
                    x2[i] = tempx2;
                    fx[i] = tempfx;
                }
            }
            ++round;
            System.out.print("\n\n\n\n\n");
        }

    }

    public static double f(double x1, double x2) {
        return ((x1 * x1) + (x2 * x2));
    }
}
