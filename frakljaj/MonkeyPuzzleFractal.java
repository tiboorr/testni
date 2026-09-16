import java.awt.Color;

public class MonkeyPuzzleFractal {

    public static void main(String[] args) {
        // 1. Setup the canvas dimensions and coordinate scale
        int width = 800;
        int height = 800;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        //StdDraw.enableDoubleBuffering();

        // 2. Clear canvas with a soft dark green blurred background color
        StdDraw.clear(new Color(25, 45, 15));

        // 3. Define configuration parameters for the phyllotaxis spiral
        int totalLeaves = 800;              // Total number of leaves to draw
        double goldenAngle = 137.507764;     // The golden angle in degrees
        double spacingFactor = 0.032;        // Controls how far apart leaves stretch from center

        // Draw from outside to inside so that closer leaves overlay the outer ones
        for (int i = totalLeaves; i >= 1; i--) {
            // Fermat's Spiral radius: r = c * sqrt(n)
            double radius = spacingFactor * Math.sqrt(i);
            
            // Calculate angle for the current leaf index
            double thetaDegrees = i * goldenAngle;
            double thetaRadians = Math.toRadians(thetaDegrees);

            // Polar to Cartesian coordinate mapping for center position of the leaf
            double x = radius * Math.cos(thetaRadians);
            double y = radius * Math.sin(thetaRadians);

            // Dynamically size each leaf based on its distance from the core
            double leafLength = 0.06 + (radius * 0.16); 
            double leafWidth = leafLength * 0.55;       

            // Calculate a color gradient (outer layers are darker, inner layers are lighter yellow-green)
            double colorProgress = (double) i / totalLeaves; // 1.0 at outer edge, 0.0 at center
            
            int r = (int) (40 + (100 * (1 - colorProgress)));
            int g = (int) (90 + (100 * (1 - colorProgress)));
            int b = (int) (30 + (20 * colorProgress));
            Color leafColor = new Color(r, g, b);
            
            // Subtle bright yellow-orange tip highlights seen on some outer leaves
            Color tipColor = new Color(r + 40 > 255 ? 255 : r + 40, g + 30 > 255 ? 255 : g + 30, b);

            // Draw the structural leaf unit
            drawLeafPolygon(x, y, thetaRadians, leafLength, leafWidth, leafColor, tipColor);
        }

        // Display the finished pattern
        StdDraw.show();
    }

    /**
     * Helper method to construct a point-oriented leaf polygon pointing directly away from the center.
     */
    private static void drawLeafPolygon(double cx, double cy, double angle, double length, double width, Color baseColor, Color edgeColor) {
        // Direction vectors (pointing outward along the radius, and orthogonal for width)
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        // 4 Coordinate vertices mapping out a diamond-shaped sharp leaf
        // Tip (pointing outwards)
        double x1 = cx + length * cos;
        double y1 = cy + length * sin;

        // Right flank
        double x2 = cx + (length * 0.2) * cos + (width * 0.5) * sin;
        double y2 = cy + (length * 0.2) * sin - (width * 0.5) * cos;

        // Base (closest to plant core)
        double x3 = cx - (length * 0.2) * cos;
        double y3 = cy - (length * 0.2) * sin;

        // Left flank
        double x4 = cx + (length * 0.2) * cos - (width * 0.5) * sin;
        double y4 = cy + (length * 0.2) * sin + (width * 0.5) * cos;

        double[] px = {x1, x2, x3, x4};
        double[] py = {y1, y2, y3, y4};

        // Draw the inner leaf filling
        StdDraw.setPenColor(baseColor);
        StdDraw.filledPolygon(px, py);

        // Add bright sharp edge outlines to mimic the highlighting borders of the spikes
        StdDraw.setPenColor(edgeColor);
        StdDraw.setPenRadius(0.002);
        StdDraw.polygon(px, py);
    }
}
