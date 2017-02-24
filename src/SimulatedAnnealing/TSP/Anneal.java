package SimulatedAnnealing.TSP;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by chyvn on 14-01-2017.
 */

public class Anneal {
    public static int[] anneal(int[] solution, int n) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int[][] graph = init(n);
        double oldCost = cost(solution, graph);
        double temperature = 1;
        double minTemperature = 0.00001;
        double alpha = 0.9; // as a standard, the value can be 0.8 as well.

        //System.out.println("Solution             Cost     Temperature    Result");
        int[] outSolution = new int[n];
        while (temperature > minTemperature) {

            int[] newSolution = neighbour(solution);
            double newCost = cost(newSolution, graph);
            //System.out.print(newSolution + " " + newCost + " " + temperature + " ");
            printSolution(solution);
            System.out.print(String.format("    %04.1f   %1.7f ", newCost, temperature));
            double acceptanceProbability = getAcceptanceProb(oldCost * 0.01, newCost * 0.01, temperature);
            if (acceptanceProbability > Math.random()) {
                outSolution = solution;
                solution = newSolution;
                oldCost = newCost;
               System.out.println("Fitness better");
                System.out.print("An accepted solution is : ");
                printSolution(solution);
                System.out.println();
            } else {
               System.out.println("Fitness worse");
            }

            temperature = temperature * alpha;
        }

        return outSolution;
    }

    /*
    *  This is a standard Acceptance probability function.
    * */
    public static double getAcceptanceProb(double oldCost, double newCost, double temperature) {
        return (Math.exp((oldCost - newCost) / temperature));
    }

    public static void printSolution(int[] a) {
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
    }

    /**
     * This function calculates the cost for the proposed solution.
     * <p>
     * In case of scheduling, we can make this function calculate the
     * time taken by the last process to finish it's task.
     */

    public static double cost(int[] x, int[][] graph) {
        int cost = 0;
        for (int i = 1; i < x.length; i++) {
            cost += graph[x[i]][x[i - 1]];
        }
        return cost;
    }

    /**
     * This function generates the next neighbour.
     */

    public static int[] neighbour(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }


    public static int[][] init(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    array[i][j] = (int) (Math.random() * 10);
                } else array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    /*
    *  Driver function.
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        anneal(a, n);
    }
}
