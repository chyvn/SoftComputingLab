package InvasiveWeedOpti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chyvn on 02-03-2017.
 */
public class Colony {
    List<Weed> weeds;
    double globalHighestFitness;
    double globalLowestFitness;
    int population;
    TargetSystem system;

    Colony(int size, TargetSystem system) {

        weeds = new ArrayList<>();
        this.population = size;
        this.system = system;

        for (int i = 0; i < size; i++) {
            weeds.add(new Weed(system));
        }
    }

    void optimize(int iterations, TargetSystem system) {
        boolean isTerminate = false;
        for (int p = 0; p < iterations && !isTerminate; p++) {
            // rethinking on the offspring list.
            // List<Weed> offsprings = new ArrayList<>();
            for (Weed temp : weeds) {
                // get each weed's fitness value.
                double fitness = temp.fitness();

                // TODO : implement the fitness function.
                // produce seeds -> offsprings

                // TODO : seed production scheme.

                // calculate code distance of offsprings - done.

                // TODO : get clarity on the parameters.
                double seeds = ((temp.highestFitness - temp.lowestFitness) / (globalHighestFitness - globalLowestFitness)) * (fitness - temp.lowestFitness) + temp.lowestFitness;
                for (int i = 0; i < seeds; i++) {
                    weeds.add(temp.produce());
                }
            }
            // fit the offsprings depending on their fitness and make sure only th epopulation size is maintained
            sortWeeds();

            weeds.subList(0, population - 1);
            // check if termination condition is met.
            isTerminate = checkTermination();
        }

    }

    public void sortWeeds() {
        Collections.sort(weeds, new Comparator<Weed>() {
            @Override
            public int compare(Weed o1, Weed o2) {
                if (o1.fitness > o2.fitness) return 1;
                else return 0;
            }
        });
    }

    public boolean checkTermination() {
        // TODO : Termination condition.
        return  false;
    }

    public Weed getBest() {
        sortWeeds();
        return weeds.get(0);
    }

}