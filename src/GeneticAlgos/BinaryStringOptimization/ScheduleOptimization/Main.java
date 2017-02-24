package GeneticAlgos.BinaryStringOptimization.ScheduleOptimization;

import java.util.Scanner;

/**
 * Created by chyvn on 12-02-2017.
 *
 *  Main is the driver function.
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int populationSize = scanner.nextInt();
        int chromosomeSize = scanner.nextInt();

        Population population = new Population(populationSize, chromosomeSize);
        Chromosome target = new Chromosome(chromosomeSize);

        System.out.print("The target chromosome is : ");
        target.display();

        GA g = new GA();
        Chromosome optimalSolution = g.optimize(population, target);

        System.out.print("The optimal solution is found : ");
        target.display();
    }
}
