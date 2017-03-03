package ParticleSwarmOpti.HelloWorld;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chyvn on 28-02-2017.
 */
public class Swarm {

    List<Particle> swarm;
    Particle globalLeader;

    double x, y;

    Swarm(int size, double x, double y) {
        swarm = new ArrayList<>();
        this.x = x;
        this.y = y;
        Particle temp = new Particle(x, y);
        globalLeader = temp;
        for (int i = 0; i < size; i++) {
            temp = new Particle(x, y);
            swarm.add(temp);
            if (temp.distance(x, y) < globalLeader.distance(x, y)) {
                globalLeader = temp;
            }
        }
    }


    public void optimize() {
        int iterations = 100;
        boolean terminates = false;
        for (int i = 0; (i < iterations) && !terminates; i++) {
            for (Particle temp : swarm) {
                temp.modify(globalLeader);
                if (temp.distance(x, y) < globalLeader.distance(x, y)) {
                    globalLeader = temp;
                }
            }
            printBest();
            terminates = checkTerminates();
        }
    }

    Particle getBest() {
        double distance = Integer.MAX_VALUE;
        Particle best = swarm.get(0);
        for (Particle temp : swarm) {
            if (temp.distance(x, y) > distance) {
                distance = temp.distance(x, y);
                best = temp;
            }
        }
        return best;
    }

    boolean checkTerminates() {
        boolean terminates = false;
        for (Particle temp : swarm) {
            if (temp.distance(x, y) == 0) terminates = true;
        }
        return terminates;
    }

    void printBest() {
        //System.out.print(String.format("X : %1.7f Y : %1.7f \n", this.getBest().x, this.getBest().y));
        System.out.print("X : " + this.getBest().x + " Y : " + this.getBest().y);
        System.out.println();
    }
}
