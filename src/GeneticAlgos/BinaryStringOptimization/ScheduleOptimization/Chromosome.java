package GeneticAlgos.BinaryStringOptimization.ScheduleOptimization;

/**
 * Created by chyvn on 11-02-2017.
 */
public class Chromosome {

    int[] genes;

    Chromosome(int length) {
        genes = new int[length];

        for (int i = 0; i < length; i++) {
            genes[i] = (int) Math.round(Math.random());
        }
    }

    Chromosome crossover(Chromosome that) {
        Chromosome output = new Chromosome(this.genes.length);
        for (int i = 0; i < this.genes.length / 2; i++) {
            output.genes[i] = this.genes[i];
        }
        for (int i = this.genes.length / 2 + 1; i < this.genes.length; i++) {
            output.genes[i] = that.genes[i];
        }
        return output;
    }

    Chromosome mutate() {

        // flip random number of bits at random positions.

        for (int i = 0; i < this.genes.length; i++) {
            int isFlip = (int) Math.round(Math.random());;
            if (isFlip == 0) {
                if (this.genes[i] == 1) {
                    this.genes[i] = 0;
                } else {
                    this.genes[i] = 1;
                }
            }
        }
        return this;
    }

    void display() {
        for (int i = 0; i < this.genes.length; i++) System.out.print(this.genes[i] + " ");
        System.out.println();
    }

    double getFitness(Chromosome target) {
        int fitness = 0;
        for (int i = 0; i < target.genes.length; i++) {
            if (target.genes[i] != this.genes[i]) fitness++;
        }
        return fitness;
    }
}
