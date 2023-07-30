package ru.cyberpunkoff;

import ru.cyberpunkoff.exceptions.OutOfBoundsException;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Renderer extends JPanel {

    private static final int PIXEL_SIZE = 30;
    private static final int BORDER_SIZE = 100;
    private final int pixelWidth;
    private final int pixelHeight;
    private final int width;
    private final int height;
    Simulation simulation;  // storing simulation probably not the best solution, but I don't know
                            // how to call methods from gui otherwise
    private Graphics g;
    private CellMap cellMap;

    Renderer(int pixelWidth, int pixelHeight, Simulation simulation) {

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.height = pixelHeight * PIXEL_SIZE;
        this.width = pixelWidth * PIXEL_SIZE;
        this.simulation = simulation;

        JFrame mainFrame = new JFrame("Simulation");
        mainFrame.setSize(width + BORDER_SIZE * 2, height + BORDER_SIZE * 2);
        mainFrame.getContentPane().setBackground(Color.BLACK); // Color.GRAY
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));
        buttonsPanel.setPreferredSize(new Dimension(70, 90));

        Button startButton = new Button("Start");
        startButton.addActionListener(e -> simulation.startSimulation());

        Button pauseButton = new Button("Pause");
        pauseButton.addActionListener(e -> simulation.pauseSimulation());

        Button resetButton = new Button("Step");
        resetButton.addActionListener(e -> simulation.nextTurn());

        buttonsPanel.add(startButton);
        buttonsPanel.add(pauseButton);
        buttonsPanel.add(resetButton);
        mainFrame.add(buttonsPanel);
        mainFrame.add(Box.createHorizontalStrut(40));

        mainFrame.setLayout(new GridBagLayout());
        // fixme Because of GridBagLayout limitations we have problem when JPanel is too big it's just not showing

        setSize(width, height);
        setPreferredSize(new Dimension(width + 1, height + 1));
        setLayout(null);
        setBackground(Color.BLACK);

        mainFrame.add(this);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        drawMap();
        drawGrid();
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
        if (this.cellMap == null) return; // fix for initial call when there is no map

        Map<Cell, Entity> map = this.cellMap.getCells();

        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            Cell cell = entry.getKey();
            Entity entity = entry.getValue();
            drawPixel(cell.getX(), cell.getY(), getEntityColor(entity));
        }
    }

    private Color getEntityColor(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Grass" -> new Color(0, 100, 0);
            case "Rock" -> Color.LIGHT_GRAY;
            case "Tree" -> new Color(150, 75, 0);
            case "Herbivore" -> Color.GREEN;
            case "Predator" -> Color.RED;
            default -> Color.BLACK;
        };
    }

    private void drawPixel(int pixelX, int pixelY, Color color) {
        if (pixelX < 0 || pixelX >= pixelWidth || pixelY < 0 || pixelY >= pixelHeight) throw new OutOfBoundsException();
        g.setColor(color);
        g.fillRect(pixelX * PIXEL_SIZE, pixelY * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

    }

    private void clearPixel(int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
}
