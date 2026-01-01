/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {

    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }

    // Draws a Sierpinski triangle of depth n on the standard canvas.
    public static void sierpinski(int n) {
        // Canvas setup (optional but nice)
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();

        // Big equilateral triangle coordinates (with margins)
        double margin = 0.05;
        double side = 0.90;
        double h = side * Math.sqrt(3) / 2.0;

        // vertices: top (x1,y1), left (x2,y2), right (x3,y3)
        double x1 = 0.5,           y1 = margin + h;
        double x2 = 0.5 - side/2,  y2 = margin;
        double x3 = 0.5 + side/2,  y3 = margin;

        // draw recursively
        sierpinski(n, x1, x2, x3, y1, y2, y3);

        StdDraw.show();
    }

    // Does the actual drawing, recursively.
    private static void sierpinski(int n,
                                   double x1, double x2, double x3,
                                   double y1, double y2, double y3) {

        // Base case: draw one triangle
        if (n <= 1) {
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.line(x2, y2, x3, y3);
            StdDraw.line(x3, y3, x1, y1);
            return;
        }

        // Midpoints of the sides
        double x12 = (x1 + x2) / 2.0, y12 = (y1 + y2) / 2.0;
        double x23 = (x2 + x3) / 2.0, y23 = (y2 + y3) / 2.0;
        double x31 = (x3 + x1) / 2.0, y31 = (y3 + y1) / 2.0;

        // Recurse on the 3 corner triangles (skip the middle one)
        sierpinski(n - 1, x1,  x12, x31, y1,  y12, y31); // top
        sierpinski(n - 1, x12, x2,  x23, y12, y2,  y23); // left
        sierpinski(n - 1, x31, x23, x3,  y31, y23, y3);  // right
    }
}
