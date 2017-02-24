package SimulatedAnnealing.MathematicalFunction;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by chyvn on 14-01-2017.
 */

public class Anneal {
    public static double anneal(double solution) {
        double oldCost = cost(solution);
        double temperature = 1;
        double minTemperature = 0.00001;
        double alpha = 0.9; // as a standard, the value can be 0.8 as well.

        System.out.println("Sol   Cost     Temperature    Result");
        while (temperature > minTemperature) {

            double newSolution = neighbour(solution);
            double newCost = cost(newSolution);
            //System.out.print(newSolution + " " + newCost + " " + temperature + " ");
            System.out.print(String.format("%04.1f   %07.1f   %1.7f ", newSolution, newCost, temperature));
            double acceptanceProbability = getAcceptanceProb(oldCost, newCost, temperature);
            if (acceptanceProbability > Math.random()) {
                solution = newSolution;
                oldCost = newCost;
                System.out.println("Accepted");
            } else System.out.println("Rejected");

            temperature = temperature * alpha;
        }
        return solution;
    }

    /*
    *  This is a standard Acceptance probability function.
    * */
    public static double getAcceptanceProb(double oldCost, double newCost, double temperature) {
        return (Math.exp((oldCost - newCost) / temperature));
    }


    /**
     * This function calculates the cost for the proposed solution.
     * <p>
     * In case of scheduling, we can make this function calculate the
     * time taken by the last process to finish it's task.
     */

    public static double cost(double x) {
        return (Math.pow((2 * x - 8), 2) + Math.pow((5 * x - 9), 2));
    }

    /**
     * This function generates the next neighbour.
     */

    public static double neighbour(double solution) {
        int randomNumber = ThreadLocalRandom.current().nextInt(-1000, 1001);
        double neighbor = randomNumber / 100;
        return (neighbor);
    }

    /*
    *  Driver function.
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();

        System.out.print("Annealing found the optimal solution to be " + anneal(n));
    }
}
