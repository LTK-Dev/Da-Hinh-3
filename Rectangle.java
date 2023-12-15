import java.awt.*;
import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle() {

    }

    /**
     * Ham khoi tao 2 ham so.
     *
     * @param width  chieu rong
     * @param length chieu dai
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Ham khoi tao 4 tham so.
     *
     * @param width  rong
     * @param length dai
     * @param color  mau
     * @param filled fill
     */
    public Rectangle(double width, double length, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.width = width;
        this.length = length;
    }

    /**
     * Ham khoi tao.
     *
     * @param topLeft top
     * @param width   w
     * @param length  l
     * @param color   c
     * @param filled  f
     */
    public Rectangle(Point topLeft, double width, double length, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    /**
     * set top.
     *
     * @param topLeft top
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    /**
     * set rong.
     *
     * @param width rong
     */
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    /**
     * set dai.
     *
     * @param length dai
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * tra ve dien tich.
     *
     * @return dien tich
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * tra ve chu vi.
     *
     * @return chu vi
     */
    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    /**
     * Ham in ra.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft.toString()
                + ",width=" + width
                + ",length=" + length
                + ",color=" + color
                + ",filled=" + filled + "]";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) (topLeft.getPointX()), (int) (topLeft.getPointY()), (int) (width), (int) (length));
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        topLeft.setPointX(topLeft.getPointX() + getVelocity().getPointX());
        topLeft.setPointY(topLeft.getPointY() + getVelocity().getPointY());

        if (topLeft.getPointX() <= 0 || topLeft.getPointX() + width >= panelWidth) {
            getVelocity().setPointX(-getVelocity().getPointX());
        }
        if (topLeft.getPointY() <= 0 || topLeft.getPointY() + length >= panelHeight) {
            getVelocity().setPointY(-getVelocity().getPointY());
        }
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
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) <= 0.001
                && Double.compare(length, rectangle.length) <= 0.001
                && Objects.equals(topLeft, rectangle.topLeft);
    }

    /**
     * hash.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }
}
