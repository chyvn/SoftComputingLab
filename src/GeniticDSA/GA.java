package GeniticDSA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chyvn on 27-02-2017.
 */
public class GA {
    static int tournamentSize = 5;
    static double mutationRate = 0.015;


    public static Schedule evolve(Population population, TargetSystem system) {

        List<Schedule> evolvingPopulation = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Schedule schedule1 = tournamentSelection(system);
            Schedule schedule2 = tournamentSelection(system);

            schedule1 = mutate(schedule1, schedule2);
            evolvingPopulation.add(schedule1);
            System.out.println("Iteration : " + (i + 1) + " Added schedule with fitness : " + schedule1.fitness(system));
        }

        Schedule finalSchedule = evolvingPopulation.get(0);
        double bestFit = finalSchedule.fitness(system);

        for (Schedule temp : evolvingPopulation) {
            if (temp.fitness(system) < bestFit) {
                finalSchedule = temp;
                bestFit = finalSchedule.fitness(system);
            }
        }

        return finalSchedule;
    }

    private static Schedule mutate(Schedule schedule1, Schedule schedule2) {

        for (int i = 0; i < schedule1.schedule.length; i++) {
            if (Math.random() > mutationRate) {
                schedule1.schedule[i] = schedule2.schedule[i];
            }
        }
        return schedule1;
    }

    private static Schedule tournamentSelection(TargetSystem system) {
        Population population = new Population(tournamentSize, system);
        double fitness = 0;

        Schedule fittest = population.getFittest();
        fitness = fittest.fitness(system);
        for (int i = 0; i < tournamentSize; i++) {
            population = new Population(tournamentSize, system);
            Schedule temp = population.getFittest();
            if (temp.fitness(system) < fitness) {
                fittest = temp;
            }
        }
        return fittest;
    }
}
