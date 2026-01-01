/** Draws the Koch curve and the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        /*
        // Tests the curve function:
        curve(Integer.parseInt(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]),
              Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        */

        /*
        // Tests the snowflake function:
        snowFlake(Integer.parseInt(args[0]));
        */
    }

    /** Draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base case: draw the straight segment
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Split the segment into thirds: A -> B -> D -> E
        double bx = (2 * x1 + x2) / 3.0;
        double by = (2 * y1 + y2) / 3.0;

        double dx = (x1 + 2 * x2) / 3.0;
        double dy = (y1 + 2 * y2) / 3.0;

        // вершина של משולש שווה-צלעות על המקטע האמצעי (B->D)
        // given formula in the PDF (point outside the line):
        double cx = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
        double cy = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

        // Recurse on the 4 new segments
        curve(n - 1, x1, y1, bx, by);
        curve(n - 1, bx, by, cx, cy);
        curve(n - 1, cx, cy, dx, dy);
        curve(n - 1, dx, dy, x2, y2);
    }

    /** Draws a Koch snowflake of depth n on the standard canvas. */
    public static void snowFlake(int n) {
        // setup canvas nicely
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);

        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);

        // Equilateral triangle vertices
        double xA = 0.1, yA = 0.1;
        double xB = 1.0, yB = 0.1;
        double xC = 0.55, yC = 0.1 + 0.9 * Math.sqrt(3) / 2.0; // height of side 0.9

        // Draw 3 Koch curves around the triangle (order matters for “outward” bumps)
        curve(n, xA, yA, xB, yB);
        curve(n, xB, yB, xC, yC);
        curve(n, xC, yC, xA, yA);
    }
}
