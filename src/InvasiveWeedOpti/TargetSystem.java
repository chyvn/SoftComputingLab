package InvasiveWeedOpti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chyvn on 02-03-2017.
 * <p>
 * this class has all the information about
 * the processors, and the DAG.
 * <p>
 * For now all the params will be hard coded, and DAG will be a bunch of numbers.
 */
public class TargetSystem {
    int[] processors = new int[4]; // the number of processors, and their power in MIPS.

    List<List<Integer>> DAG;

    List<Integer> taskList;

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

        DAG.addAll(Arrays.asList(level0, level1, level2, level3, level4, level5));

        processors[0] = 1000;
        processors[1] = 1000;
        processors[2] = 1000;
        processors[3] = 1000;
    }

}
