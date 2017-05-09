package ClosestPairOfPoints;

import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by Shuonan on 4/28/2017.
 * Application Main Entry File
 */
/*Implement the algorithm for the closest point of points (Section 33.4 in
 * the textbook). Algorithm should input the coordinates of the points in
 * the point-set from a text file whose format matches the test files uploaded
 * on D2L, and output (1) the coordinates of a closest point in the point-set,
 * and (2) the distance between the two points in the closest point.
 */

public class ClosestPointMain {
    public static void main(String[] args) throws FileNotFoundException {

        LoadData tenPoints = new LoadData("10points.txt");
        LoadData hundredPoints = new LoadData("100points.txt");
        LoadData thousandPoints = new LoadData("1000points.txt");
        
        ArrayList<Point>tenList = tenPoints.getList();
        ArrayList<Point>hunList = hundredPoints.getList();
        ArrayList<Point>thouList = thousandPoints.getList();
        
        ClosestPoint cp = new ClosestPoint();// apply algorithm to get closest point
        
        double tenMinDist = cp.closestPoint(tenList);     
        System.out.println("10 points test file:\n");
        System.out.println("The minimum distance is: ");
        System.out.format("%.9f: (%d, %d)<--->(%d, %d)\n\n", 
        		tenMinDist, cp.p1.getX(),cp.p1.getY(),cp.p2.getX(),cp.p2.getY());
        
        
        double hunMinDist = cp.closestPoint(hunList);
        System.out.println("100 points test file:\n");
        System.out.println("The minimum distance is: ");
        System.out.format("%.10f: (%d, %d)<--->(%d, %d)\n\n", 
        		hunMinDist, cp.p1.getX(),cp.p1.getY(),cp.p2.getX(),cp.p2.getY());
        
        double thouMinDist = cp.closestPoint(thouList);
        System.out.println("1000 points test file:\n");
        System.out.println("The minimum distance is: ");
        System.out.format("%.9f: (%d, %d)<--->(%d, %d)",
        		thouMinDist, cp.p2.getX(),cp.p2.getY(),cp.p1.getX(),cp.p1.getY());
    }

}
