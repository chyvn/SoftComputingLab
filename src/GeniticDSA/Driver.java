package GeniticDSA;

import java.util.Scanner;

/**
 * Created by chyvn on 24-02-2017.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TargetSystem system = new TargetSystem();

        System.out.print("Enter the population size : ");
        int populationSize = scanner.nextInt();
        long tStart = System.currentTimeMillis();
        Population population = new Population(populationSize, system);


        System.out.println("The evolved population is : ");
        Schedule finalSchedule = GA.evolve(population, system);
        double fitness = finalSchedule.fitness(system);
        finalSchedule.print();
        System.out.println("And the fitness value is : " + fitness);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println("Time taken : " + elapsedSeconds + " seconds");

    }
}
