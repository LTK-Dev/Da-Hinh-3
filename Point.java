import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * ham khoi tao.
     *
     * @param pointX x
     * @param pointY y
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    /**
     * get x.
     *
     * @param pointX x
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    /**
     * get y.
     *
     * @param pointY y
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * distance.
     *
     * @param newPoint p
     * @return res
     */
    public double distance(Point newPoint) {
        return Math.sqrt(Math.pow(newPoint.pointX - this.pointX, 2)
                + Math.pow(newPoint.pointY - this.pointY, 2));
    }

    /**
     * equals.
     *
     * @param o obj
     * @return ans
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(pointX, point.pointX) <= 0.001
                && Double.compare(pointY, point.pointY) <= 0.001;
    }

    /**
     * hash.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}
