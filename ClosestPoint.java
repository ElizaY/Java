package ClosestPairOfPoints;

import java.util.*;

public class ClosestPoint {

	Point p1, p2;

	double delta = Double.MAX_VALUE;
	double minDist = Double.MAX_VALUE;

	public double closestPoint(List<Point> pList) {

		// sort strip by X, use comparator compare 2 points by x coordinate
		Collections.sort(pList, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o1.getX(), o2.getX());
			}
		});
		// compute closest points in pList:
		return closest(pList);
	}

	public double closest(List<Point> pList) {

		double minDist;

		if (pList.size() <= 3) {
			minDist = bruteForce(pList);

		} else {
			
			int mid = pList.size() / 2;
			Point midPoint = pList.get(mid);

			// Recursively split points by mid to left and right
			double dLeft = closest(pList.subList(0, mid));
			double dRight = closest(pList.subList(mid + 1, pList.size()));
			delta = Math.min(dLeft, dRight);

			// Auxiliary list to store points within 2 delta width strip area
			List<Point> strip = new ArrayList<Point>();

			for (int i = 0; i < pList.size(); i++)

				if (Math.abs(pList.get(i).getX() - midPoint.getX()) <= delta) {
					strip.add(pList.get(i));
				}

			double dStrip = stripClosest(strip, strip.size(), delta);
			minDist = Math.min(delta, dStrip);
		}

		return minDist;
	}

	private double stripClosest(List<Point> strip, int size, double delta) {

		double sDist = delta;

		// sort strip area points by Y, use comparator compare 2 points by y coordinate
		Collections.sort(strip, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o1.getY(), o2.getY());
			}
		});

		if (strip.size() <= 1) {
			sDist = Double.MAX_VALUE;
		}

		else {
			for (int i = 0; i < size; i++)

				for (int j = i + 1; j <= size - 1 && ((strip.get(j).getY() - strip.get(i).getY()) < delta); j++)

					if (distanceTo(strip.get(i), strip.get(j)) < delta) {

						sDist = distanceTo(strip.get(i), strip.get(j));

						if (sDist < minDist) {
							minDist = sDist;
							p1 = strip.get(i);
							p2 = strip.get(j);
						}
					}
		}
		return minDist;// final return this
	}

	private double bruteForce(List<Point> pList) {

		int listSize = pList.size();

		for (int i = 0; i < listSize; i++) {
			for (int j = i + 1; j < listSize; j++) {

				double distance = distanceTo(pList.get(i), pList.get(j));

				if (distance < minDist) {
					minDist = distance;
					p1 = pList.get(i);
					p2 = pList.get(j);
				}
			}
		}
		return minDist;
	}

	private double distanceTo(Point a, Point b) {

		int ax = a.getX();
		int ay = a.getY();
		int bx = b.getX();
		int by = b.getY();

		return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
	}

}
