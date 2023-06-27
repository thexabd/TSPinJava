
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Euclidean {
    public static double routeDistance(ArrayList<Point2D> cities) {

        double result = 0; //Holds the route length
        Point2D prev = cities.get(cities.size() - 1);

        for (Point2D city : cities) {

            result += city.distance(prev);

            prev = city;

        }
        return result;
    }
}
