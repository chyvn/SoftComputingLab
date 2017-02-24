package GeneticAlgos.BinaryStringOptimization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chyvn on 11-02-2017.
 */
public class Population {
    List<Chromosome> chromosomes;
    int size;

    double currentFitness;

    Population(int length, int chromosomeLength) {
        size = length;
        chromosomes = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            chromosomes.add(new Chromosome(chromosomeLength));
        }

        currentFitness = Integer.MAX_VALUE;
    }

    double[] getFitness(Chromosome target) {
        double[] toReturn = new double[chromosomes.size()];
        int index = 0;
        for (Chromosome c : chromosomes) {
            toReturn[index] = c.getFitness(target);
            //System.out.print("Fitness is : " + toReturn[index]);
            //c.display();
            ++index;
        }
        return toReturn;
    }

    void add(Chromosome chromosome) {
        chromosomes.add(chromosome);
    }

    boolean checkFitness(double[] fitness) {
        if (currentFitness > fitness[0]) {
            currentFitness = fitness[0];
            System.out.println("The fitness value is now : " + currentFitness);
        }

        if (fitness[0] == 0) return true;
        else return false;
    }
}
