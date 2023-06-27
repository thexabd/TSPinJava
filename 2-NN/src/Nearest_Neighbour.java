

        import java.awt.geom.Point2D;
        import java.util.ArrayList;
        import java.util.Collections;

public class Nearest_Neighbour {
    protected static ArrayList<Point2D> NN(ArrayList<Point2D> cities) {
        Collections.shuffle(cities);
        ArrayList<Point2D> result = new ArrayList<>();
        Point2D currentCity = cities.remove(0);
        Point2D closestCity = cities.get(0);
        Point2D possible;
        double dist;

        result.add(currentCity);

        while (cities.size() > 0) {

            dist = Double.MAX_VALUE;


            for (int count = 0; count < cities.size(); count++) {
                possible = cities.get(count);
                if (currentCity.distance(possible) < dist) {
                    dist = currentCity.distance(possible);
                    closestCity = possible;
                }
            }
            currentCity = closestCity;
            cities.remove(closestCity);
            result.add(currentCity);
        }
        return result;
    }
}

