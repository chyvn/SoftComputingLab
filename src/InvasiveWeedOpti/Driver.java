package InvasiveWeedOpti;

import java.util.Scanner;

/**
 * Created by chyvn on 02-03-2017.
 */
public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TargetSystem system = new TargetSystem();
        int population = scanner.nextInt();
        Colony solutionColony = new Colony(population, system);
        solutionColony.optimize(1000, system);
        Weed finalSolution = solutionColony.getBest();

        // print the solution..
    }
}
