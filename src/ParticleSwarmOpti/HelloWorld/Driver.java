package ParticleSwarmOpti.HelloWorld;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

/**
 * Created by chyvn on 28-02-2017.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double maxX = scanner.nextInt();
        double maxY = scanner.nextInt();

        int swarmSize = scanner.nextInt();

        Swarm swarm = new Swarm(swarmSize, maxX, maxY);
        swarm.optimize();
        System.out.println();
        System.out.print("The best we could get is : ");
        System.out.print("X : " + swarm.getBest().x + " Y : " + swarm.getBest().y);
    }
}
