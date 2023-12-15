import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Layer extends JPanel {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Thêm hình vào danh sách shapes.
     *
     * @param shape Hình cần thêm
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Lấy thông tin về danh sách shapes.
     *
     * @return Thông tin về danh sách shapes
     */
    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Layer of crazy shapes:\n");

        for (Shape shape : shapes) {
            result.append(shape.toString()).append("\n");
        }

        return result.toString();
    }

    /**
     * Xóa các hình tròn khỏi danh sách shapes.
     */
    public void removeCircles() {
        Iterator<Shape> it = shapes.iterator();

        while (it.hasNext()) {
            Shape tmp = it.next();

            if (tmp instanceof Circle) {
                it.remove();
            }
        }
    }

    /**
     * Xóa các hình trùng lặp khỏi danh sách shapes.
     */
    public void removeDuplicates() {
        HashSet<Shape> set = new LinkedHashSet<>();
        for (Shape shape : shapes) {
            set.add(shape);
        }
        shapes.clear();
        shapes.addAll(set);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public void move(int panelWidth, int panelHeight) {
        for (Shape s : shapes) {
            s.move(panelWidth, panelHeight);
        }
        repaint();
    }


}