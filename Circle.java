import java.awt.*;
import java.util.Objects;

public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle() {

    }

    /**
     * Ham khoi tao 1 tham so.
     *
     * @param radius ban kinh
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Ham khoi tao 3 tham so.
     *
     * @param radius ban kinh
     * @param color  mau
     * @param filled fill
     */
    public Circle(double radius, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.radius = radius;
    }

    /**
     * ham khoi tao.
     *
     * @param center c
     * @param radius r
     * @param color  c
     * @param filled f
     */
    public Circle(Point center, double radius, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.radius = radius;
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    /**
     * set.
     *
     * @param center c
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Ham set ban kinh.
     *
     * @param radius ban kinh
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Ham dien tich.
     *
     * @return din tich
     */
    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    /**
     * Ham chu vi.
     *
     * @return chu vi
     */
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Ham in ra.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Circle[center=" + center.toString()
                + ",radius=" + radius
                + ",color=" + color
                + ",filled=" + filled + "]";
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
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) <= 0.001
                && Objects.equals(center, circle.center);
    }

    /**
     * hash.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (center.getPointX() - radius), (int) (center.getPointY() - radius), (int) (2 * radius), (int) (2 * radius));
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        center.setPointX(center.getPointX() + getVelocity().getPointX());
        center.setPointY(center.getPointY() + getVelocity().getPointY());

        if (center.getPointX() - radius <= 0 || center.getPointX() + radius >= panelWidth) {
            getVelocity().setPointX(-getVelocity().getPointX());
        }
        if (center.getPointY() - radius <= 0 || center.getPointY() + radius >= panelHeight) {
            getVelocity().setPointY(-getVelocity().getPointY());
        }
    }
}
