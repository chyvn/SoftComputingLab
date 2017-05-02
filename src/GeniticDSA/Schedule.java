package GeniticDSA;

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

        int time = 0; // time taken by each processor to complete a task.
        int cost = 0; // cost of using a processor for a particular time.
        double fitness = 0;

        for (int i = 0; i < schedule.length; i++) {
            time = system.processes[i] / system.processors[schedule[i]];
            cost = time * system.cost[schedule[i]];
            fitness += time + cost;
        }

        return fitness;
    }

    public void print() {
        for (int i = 0; i < schedule.length; i++) System.out.print(schedule[i] + " ");
        System.out.println();
    }
}
