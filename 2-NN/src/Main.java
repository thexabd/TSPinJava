

        import java.awt.geom.Point2D;
        import java.io.IOException;
        import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        double timetaken;

        double startTime = System.currentTimeMillis();
        ArrayList<Point2D> cities = new ArrayList<>(LoadFile.loadTSPFile("TSP_107.txt")); //alter file name here.
        ArrayList<Point2D> nearestN;
        ArrayList<Point2D> result;

        double length = Euclidean.routeDistance(cities);
        System.out.println("Initial tour length is: " + length);
        double time = System.currentTimeMillis() - startTime;
        nearestN = Nearest_Neighbour.NN(cities);
        length = Euclidean.routeDistance(nearestN);
        System.out.println("Nearest neighbour solution complete, distance: " + length);
        TourCheck.check(nearestN);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for init and Nearest Neighbour: " + time);
        timetaken=time;

        startTime = System.currentTimeMillis();
        result = TwoOpt.Switch(nearestN);
        length = Euclidean.routeDistance(result);
        System.out.println("2-opt solution complete, distance: " + length);
        TourCheck.check(result);
        time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for 2 opt optimisation: " + time);
        timetaken=timetaken+time;
        System.out.println("The total time taken is: "+timetaken+" ms");
        Draw draw=new Draw(result);

    }
}
