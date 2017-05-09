package ClosestPairOfPoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Shuonan on 4/28/2017.
 * Load data from given txt file to List<Point> points
 */
public class LoadData {

    String fileName;
    public ArrayList<Point> points = new ArrayList<Point>();
    public LoadData() {
    }

    public LoadData(String newData) throws FileNotFoundException {

        fileName = newData;
        Scanner data = new Scanner(new File(fileName));

        while (!(!data.hasNextLine() || !data.hasNextInt()))

        {
            int curX = data.nextInt();
            int curY = data.nextInt();

            Point curPoint = new Point(curX, curY);
            points.add(curPoint);
        }
        data.close();
    }

    public ArrayList<Point> getList() {
        return points;
    }

}
