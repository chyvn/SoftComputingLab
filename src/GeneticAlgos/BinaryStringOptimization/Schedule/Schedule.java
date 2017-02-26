package GeneticAlgos.BinaryStringOptimization.Schedule;

import java.util.Random;

/**
 * Created by chyvn on 24-02-2017.
 */
public class Schedule {

    int schedule[];
    Schedule(TargetSystem system) {
        schedule = new int[system.processes.length];
        for (int i = 0; i < schedule.length; i++) {
            Random random = new Random();
            schedule[i] = (random.nextInt() * 10000) % system.processors.length;
        }
    }

    public double fitness(TargetSystem system) {
        double cost = 0;

        int i = 0;
        for (int a : schedule) {
            cost += system.processors[a] / system.processes[i];
            ++i;
        }

        return cost;
    }
}
