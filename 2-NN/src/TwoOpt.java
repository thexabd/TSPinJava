

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TwoOpt {
    public static ArrayList<Point2D> Switch(ArrayList<Point2D> cities) {
        ArrayList<Point2D> newTour;
        double bestDist = Euclidean.routeDistance(cities);
        double newDist;
        int swaps = 1;
        int improve = 0;
        int iterations = 0;
        long comparisons = 0;
        while (swaps != 0) {
            swaps = 0;


            for (int i = 1; i < cities.size() - 2; i++) {
                for (int j = i + 1; j < cities.size() - 1; j++) {
                    comparisons++;

                    if ((cities.get(i).distance(cities.get(i - 1)) + cities.get(j + 1).distance(cities.get(j))) >=
                            (cities.get(i).distance(cities.get(j + 1)) + cities.get(i - 1).distance(cities.get(j)))) {

                        newTour = swap(cities, i, j); //pass arraylist and 2 points to be swapped.

                        newDist = Euclidean.routeDistance(newTour);

                        if (newDist < bestDist) {
                            cities = newTour;
                            bestDist = newDist;
                            swaps++;
                            improve++;
                        }
                    }
                }
            }
            iterations++;
        }
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total improvements made: " + improve);
        System.out.println("Total iterations made: " + iterations);
        return cities;
    }

    private static ArrayList<Point2D> swap(ArrayList<Point2D> cities, int i, int j) {

        ArrayList<Point2D> newTour = new ArrayList<>();


        int size = cities.size();
        for (int c = 0; c <= i - 1; c++) {
            newTour.add(cities.get(c));
        }


        int dec = 0;
        for (int c = i; c <= j; c++) {
            newTour.add(cities.get(j - dec));
            dec++;
        }


        for (int c = j + 1; c < size; c++) {
            newTour.add(cities.get(c));
        }

        return newTour;
    }
}
