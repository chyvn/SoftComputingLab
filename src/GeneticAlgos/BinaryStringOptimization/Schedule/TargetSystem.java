package GeneticAlgos.BinaryStringOptimization.Schedule;

/**
 * Created by chyvn on 25-02-2017.
 */
public class TargetSystem {
    int processes[];
    int processors[];

    TargetSystem(int n, int m) {
        processes = new int[n];
        processors = new int[m];
        for (int i = 0; i < n; i++) {
            processes[i] = (int) (Math.random() * 10000) + 1;
        }
        for (int i = 0; i < m; i++) {
            processors[i] = (int) (Math.random() * 100) + 1;
        }
    }
}
