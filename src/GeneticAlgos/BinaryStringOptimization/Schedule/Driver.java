package GeneticAlgos.BinaryStringOptimization.Schedule;

import GeneticAlgos.BinaryStringOptimization.TSP.GA;

import java.util.Scanner;

/**
 * Created by chyvn on 24-02-2017.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int processes = scanner.nextInt();
        int processors = scanner.nextInt();

        TargetSystem system = new TargetSystem(processes, processors);

        int populationSize = scanner.nextInt();
        Population population = new Population(populationSize, system);

        //population = GA.evolvePopulation(population);

        System.out.println("The evolved population is : ");
        //population.getFittest.print();

    }
}
