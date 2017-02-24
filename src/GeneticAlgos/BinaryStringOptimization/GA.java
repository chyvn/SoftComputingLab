package GeneticAlgos.BinaryStringOptimization;

import java.util.Arrays;

/**
 * Created by chyvn on 11-02-2017.
 */
public class GA {

    Chromosome optimize(Population population, Chromosome target) {
        Chromosome best = null;

        int iterations = 200;
        while(iterations > 0) {
            --iterations;
            double[] fitness = population.getFitness(target);
            Arrays.sort(fitness);

            boolean isSolutionFit = population.checkFitness(fitness);

            if (isSolutionFit) {
                return population.chromosomes.get(0);
            }


            // crossover.
            Population childPopulation = new Population(population.size, population.chromosomes.size());
            for (int i = 0; i < fitness.length / 2; i++) {
                childPopulation.add(population.chromosomes.get(i).crossover(population.chromosomes.get(i + 1)));
            }

            // mutation.
            for (Chromosome child : childPopulation.chromosomes) {
                child.mutate();
            }

            population.chromosomes = population.chromosomes.subList(0, population.chromosomes.size() / 2);
            population.chromosomes.addAll(childPopulation.chromosomes);

        }
        System.out.println("The fitness condition was not met, number of iterations exhausted.");
        return best;
    }
}
