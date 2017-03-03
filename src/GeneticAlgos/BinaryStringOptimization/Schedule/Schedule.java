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
            schedule[i] = (int) ((Math.random() * 100) % system.processors.length);
            int a = 6;
        }
    }

    public double fitness(TargetSystem system) {
        double cost = 0;

        for (int i = 0; i < schedule.length; i++) {
            cost += system.processes[i] / system.processors[schedule[i]];
        }

        return cost;
    }

    public void print() {
        for (int i = 0; i < schedule.length; i++) System.out.print(schedule[i] + " ");
        System.out.println();
    }
}
