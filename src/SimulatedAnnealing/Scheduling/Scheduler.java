package SimulatedAnnealing.Scheduling;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by chyvn on 28-01-2017.
 */
public class Scheduler {
    public static int[] anneal(int[] solution, Schedule schedule) {

        double oldCost = schedule.cost(solution);
        double temperature = 1;
        double minTemperature = 0.00001;
        double alpha = 0.9; // as a standard, the value can be 0.8 as well.

        //System.out.println("Cost     Temperature    Result");
        int[] outSolution = new int[solution.length];
        while (temperature > minTemperature) {

            int[] newSolution = neighbour(solution);
            double newCost = schedule.cost(newSolution);
            //System.out.print(newSolution + " " + newCost + " " + temperature + " ");
            //printSolution(solution);
            System.out.print(String.format("    %04.1f   %1.7f ", newCost, temperature));
            double acceptanceProbability = getAcceptanceProb(oldCost * 0.00001, newCost * 0.00001, temperature);
            if (acceptanceProbability > Math.random()) {
                outSolution = solution;
                solution = newSolution;
                oldCost = newCost;
                System.out.println("Accepted");
                //System.out.print("An accepted solution is : ");
                //printSolution(solution);
                System.out.println();
            } else {
                System.out.println("Rejected");
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

    /*
    *  A schedule class.
    *  it has a list or processes and processors.
    *
    *  initiates and calculates the cost of a schedule.
    * */
    public static class Schedule {
        int processes[];
        int processors[];

        Schedule(int n, int m) {
            processes = new int[n];
            processors = new int[m];
            for (int i = 0; i < n; i++) {
                processes[i] = (int) (Math.random() * 100) + 1;
            }
            for (int i = 0; i < m; i++) {
                processors[i] = (int) (Math.random() * 10000);
            }
        }

        public double cost(int[] schedule) {
            double cost = 0;

            int i = 0;
            for (int a : schedule) {
                cost += processors[a] / processes[i];
                ++i;
            }

            return cost;
        }
    }


    /*
    *  Driver function.
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Schedule schedule = new Schedule(n, m);
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = ((int) (Math.random() * 10000) % m);
        anneal(a, schedule);
    }
}
