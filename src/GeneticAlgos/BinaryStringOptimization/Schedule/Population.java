package GeneticAlgos.BinaryStringOptimization.Schedule;

import java.util.List;

/**
 * Created by chyvn on 24-02-2017.
 */
public class Population {

    List<Schedule> scheduleList;
    TargetSystem system;

    Population(int size, TargetSystem system) {
        this.system = system;
        for (int i = 0; i < size; i++) {
            scheduleList.add(new Schedule(system));
        }
    }

    Schedule getSchedule(int n) {
        return scheduleList.get(n);
    }

    Schedule getFittest() {
        Schedule fittest = scheduleList.get(0);

        for (Schedule temp : scheduleList) {
            double fitness = temp.fitness(system);
            if (fitness < fittest.fitness(system)) {

            }
        }
        return null;
    }
}
