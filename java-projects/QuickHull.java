/**
This file shows my implementation of the Quick Hull algorithm, seen in the public QuickHull() method.
Only that part is coded by me, with the rest being provided by my instructor.
The main method shows the visual output of the algorithm.
*/

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the QuickHull algorithm for finding the convex hull of a list of points. To use, create an instance
 * and then call hull(). Run this class to display an example.
 */
public class QuickHull {

    /** The points for which we are finding the convex hull. */
    private List<Point2D> points;

    /** The points in the convex hull, in clockwise order. */
    private List<Point2D> hull;

    public QuickHull(List<Point2D> points) {
        this.points = new ArrayList<>(points);
        this.hull = new ArrayList<>();

        //creates lineL
        Line2D lineL = extrema();

        //finds all points to the left of lineL, then adds those points to this.points
        List<Point2D> leftPointsInLineL = leftSet(points, lineL);
        this.points.addAll(leftPointsInLineL);

        //finds leftmost point in leftPointsInLineL, then removes it from this.points
        Point2D leftmostPoint = farthestLeft(leftPointsInLineL, lineL);
        this.points.remove(leftmostPoint);

        //reverses lineL
        Line2D lineR = lineL.reversed();

        //finds all points to the left of lineR, then adds those points to this.points
        List<Point2D> leftPointsInLineR = leftSet(points, lineR);
        this.points.addAll(leftPointsInLineR);

        //finds leftmost point in leftPointsInLineR, then removes it from this.points
        leftmostPoint = farthestLeft(leftPointsInLineR, lineR);
        this.points.remove(leftmostPoint);

        //calculates hull based on remaining points
        this.hull.addAll(findHull(points, lineL));
        this.hull.addAll(findHull(points, lineR));

    }

    /**
     * Returns the points along the convex hull from a (exclusive) to b (inclusive) that are on
     * or left of the line ab. The points are returned in clockwise order.
     * @param lefts The set of points to the left of the line.
     * @param line Includes a and b.
     */
    List<Point2D> findHull(List<Point2D> lefts, Line2D line) {
        List<Point2D> result = new ArrayList<>();
        // No points on this side
        if (lefts.isEmpty()) {
            result.add(line.b());
            return result;
        }
        // Only one point on this side
        if (lefts.size() == 1) {
            result.add(lefts.get(0));
            result.add(line.b());
            return result;
        }
        // More than one point on this side
        Point2D max = farthestLeft(lefts, line);
        Line2D line1 = new Line2D(line.a(), max);
        List<Point2D> part1 = findHull(leftSet(lefts, line1), line1);
        Line2D line2 = new Line2D(max, line.b());
        List<Point2D> part2 = findHull(leftSet(lefts, line2), line2);
        part1.addAll(part2);
        return part1;
    }

    /** Returns a line between two of points, which are at opposite ends of the convex hull of points. */
    Line2D extrema() {
        // Sort points by x coordinates, with ties broken by y
        points.sort(Point2D.Y_ORDER);
        points.sort(Point2D.X_ORDER);
        // Return the first and last points
        return new Line2D(points.get(0), points.get(points.size() - 1));
    }

    /** Returns the set of all the points to the left of line. */
    List<Point2D> leftSet(List<Point2D> points, Line2D line) {
        List<Point2D> result = new ArrayList<>();
        for (Point2D p : points) {
            if (line.isOnLeftSide(p)) {
                result.add(p);
            }
        }
        return result;
    }

    /**
     * Returns the point in lefts (all of which are assumed to be left of line)
     * that is farthest from line.
     */
    public Point2D farthestLeft(List<Point2D> lefts, Line2D line) {
        Point2D result = null;
        double largestArea = -1;
        for (Point2D p : lefts) {
            double area = line.triangleArea(p);
            if (area > largestArea) {
                result = p;
                largestArea = area;
            }
        }
        return result;
    }

    /** Returns the hull computed by the constructor. */
    public List<Point2D> hull() {
        return hull;
    }

    public static void main(String[] args) {
        // Generate and draw points
        StdDraw.setPenRadius(0.01);
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Point2D p = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points.add(p);
            StdDraw.point(p.x(), p.y());
            //if(i % 10 == 0) System.out.println(i);
        }
        // Find hull
        List<Point2D> hull = new QuickHull(points).hull();
        // Draw hull
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < hull.size(); i++) {
            Point2D p = hull.get(i);
            Point2D q = hull.get((i + 1) % hull.size());
            StdDraw.line(p.x(), p.y(), q.x(), q.y());
        }
    }
}
