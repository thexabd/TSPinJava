

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadFile {
    public static ArrayList<Point2D> loadTSPFile(String fName) {

        ArrayList<Point2D> result = new ArrayList<Point2D>();
        BufferedReader br = null;
        try {
            String currentLine;
            int dimension = 107;
            boolean readingNodes = false;
            br = new BufferedReader(new FileReader(fName));
            while ((currentLine = br.readLine()) != null) {

                if (currentLine.contains("EOF")) {

                    readingNodes = false;

                }
                if (readingNodes)
                {

                    String[] tokens = currentLine.split(" ");

                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);

                    Point2D city = new Point2D.Float(x, y);

                    result.add(city);
                }

                dimension = 107;

                readingNodes = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
