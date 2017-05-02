package GeniticDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chyvn on 25-02-2017.
 */
public class TargetSystem {

    List<List<Integer>> DAG;

    List<Integer> taskList;
    int[] processors = new int[4]; // the number of processors, and their power in MIPS.
    int[] cost = new int[4];
    int[] processes = new int[29];


    TargetSystem() {
        List<Integer> level0 = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        List<Integer> level2 = new ArrayList<>();
        List<Integer> level3 = new ArrayList<>();
        List<Integer> level4 = new ArrayList<>();
        List<Integer> level5 = new ArrayList<>();

        level0.add(0);
        level1.addAll(Arrays.asList(1, 2, 3));
        level2.addAll(Arrays.asList(4, 5, 6, 7, 8, 9, 10));
        level3.addAll(Arrays.asList(11, 12, 13, 14));
        level4.addAll(Arrays.asList(15, 16, 17, 18, 19, 20, 21));
        level5.addAll(Arrays.asList(22, 23, 24, 25, 26, 27, 28));

        DAG = new ArrayList<>();
        DAG.addAll(Arrays.asList(level0, level1, level2, level3, level4, level5));

        processors[0] = 1500;       cost[0] = 15;
        processors[1] = 800;        cost[1] = 8;
        processors[2] = 90;         cost[2] = 9;
        processors[3] = 1800;       cost[3] = 1800;

        /**
         * TODO: add cost function and time function.
         */

        for (int i = 0; i < 29; i++) {
            processes[i] = (int) (Math.random() * 10000) + 1;
        }

    }
}
