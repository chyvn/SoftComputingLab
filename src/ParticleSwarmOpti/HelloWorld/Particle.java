package ParticleSwarmOpti.HelloWorld;

import java.awt.geom.Point2D;

import static java.awt.geom.Point2D.distance;

/**
 * Created by chyvn on 28-02-2017.
 */
public class Particle {
    double x;
    double y;

    double lbX, lbY;
    double myVelocity;

    Particle(double maxX, double maxY) {
        x = (int) ((Math.random() * 100) % maxX);
        y = (int) ((Math.random() * 100) % maxY);

        // initializing local best values to x and y
        lbX = x;
        lbY = y;
        myVelocity = 0;

    }

    void modify(Particle leader) {
        // find my velocity
        int C1 = 1;
        int C2 = 1;

        double velocity1 = C1 * Math.random() * (lbX - x) * 0.001;
        double velocity2 = C2 * Math.random() * (leader.x - x) * 0.001;
        myVelocity = myVelocity + velocity1 + velocity2;
        x = x * myVelocity;

        velocity1 = C1 * Math.random() * (lbY - y) * 0.001;
        velocity2 = C2 * Math.random() * (leader.y - y) * 0.001;
        myVelocity = myVelocity + velocity1 + velocity2;
        y = y * myVelocity;

        lbX = x;
        lbY = y;
    }

    double distance(double x, double y) {
        return Point2D.distance(this.x, this.y, x, y);
    }

}
