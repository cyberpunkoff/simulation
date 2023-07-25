package ru.cyberpunkoff;

import ru.cyberpunkoff.exceptions.OutOfBoundsException;

import javax.swing.*;
import java.awt.*;

import java.util.Map;

public class Renderer extends JPanel {

    private final int PIXEL_SIZE = 30;

    private final int BORDER_SIZE = 100;

    private final int pixelWidth;

    private final int pixelHeight;

    private final int width;

    private final int height;

    private Graphics g;

    private CellMap cellMap;

    Renderer(int pixelWidth, int pixelHeight) {

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.height = pixelHeight * PIXEL_SIZE;
        this.width = pixelWidth * PIXEL_SIZE;

        JFrame mainFrame = new JFrame("Simulation");
        mainFrame.setSize(width + BORDER_SIZE * 2, height + BORDER_SIZE * 2);
        mainFrame.getContentPane().setBackground(Color.GRAY);
        mainFrame.setLayout(new GridBagLayout());

        setSize(width, height);
        setPreferredSize(new Dimension(width+1, height+1));
        setLayout(null);
        setBackground(Color.BLACK);

        mainFrame.add(this, new GridBagConstraints());
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;

        drawMap();
        drawGrid();
        //drawPixel(0, 0, Color.RED);
        //drawPixel(228, 228, Color.GREEN);
        //clearPixel(20, 30);
        //drawGrid();

    }

    private void drawGrid() {
        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < height; i++)
            g.drawLine(0, i * PIXEL_SIZE, width, i * PIXEL_SIZE); // rows

        for (int i = 0; i < width; i++)
            g.drawLine(i * PIXEL_SIZE, 0, i * PIXEL_SIZE, height); // columns

        g.setColor(Color.MAGENTA);
        g.drawLine(0, 0, width, 0);
        g.drawLine(0, 0, 0, height);
        g.drawLine(width, 0, width, height);
        g.drawLine(0, height, width, height);

    }

    public void render(CellMap cellMap) {
        this.cellMap = cellMap;
        repaint();
    }

    private void drawMap() {

        Map<Cell, Entity> map = this.cellMap.getCells();

        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            Cell cell = entry.getKey();
            Entity entity = entry.getValue();
            drawPixel(cell.getX(), cell.getY(), entity.getColor());
        }
    }

    private void drawPixel(int pixelX, int pixelY, Color color) {

        if (pixelX < 0 || pixelX >= pixelWidth || pixelY < 0 || pixelY >= pixelHeight)
            throw new OutOfBoundsException();

        g.setColor(color);
        g.fillRect(pixelX * PIXEL_SIZE, pixelY * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

    }

    private void clearPixel(int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
}
