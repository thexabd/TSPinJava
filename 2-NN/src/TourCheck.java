

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class TourCheck {
    public static void check(ArrayList<Point2D> cities) {
        Set<Point2D> set = new HashSet<>(cities);
        if (set.size() == cities.size()) {
            System.out.println("This tour is valid");
        } else {
            System.out.println("This tour is invalid");
        }
    }
}
