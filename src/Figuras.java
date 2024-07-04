import javax.swing.*;
import java.awt.*;

public class Figuras extends JPanel {
    public int opcion;

    public Figuras(int opcionUsuario) {
        opcion = opcionUsuario;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int xCenter = width / 2;
        int yCenter = height / 2;

        switch (opcion) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    g.setColor(Color.RED);
                    g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    g.setColor(Color.BLUE);
                    g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
                }
                break;
            case 3:
                drawArtisticName(g2d, xCenter, yCenter);
                break;
            case 4:
                drawCreativeJosue(g2d, xCenter, yCenter - 100);
                drawSignatureSafron(g2d, width - 200, height - 100);
                break;
        }
    }

    private void drawArtisticName(Graphics2D g2d, int x, int y) {
        Font font = new Font("TimesRoman", Font.BOLD, 36);
        g2d.setFont(font);
        FontMetrics metrics = g2d.getFontMetrics(font);
        String name = "Josue Guerra";

        int textWidth = metrics.stringWidth(name);
        int xText = x - textWidth / 2;
        int yText = y + metrics.getHeight() / 2;

        GradientPaint gradient = new GradientPaint(xText, yText, Color.RED, xText + textWidth, yText, Color.BLUE);
        g2d.setPaint(gradient);
        g2d.drawString(name, xText, yText);
    }

    private void drawCreativeJosue(Graphics2D g2d, int x, int y) {
        int[][] coordinates = {
                {x - 300, y},
                {x - 250, y},
                {x - 200, y},
                {x - 150, y},
                {x - 100, y},
                {x - 50, y}
        };

        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
        for (int i = 0; i < coordinates.length; i++) {
            g2d.setColor(colors[i]);
            g2d.setStroke(new BasicStroke(3 + i));
            switch (i) {
                case 0:
                    draw3DLetterJ(g2d, coordinates[i][0], coordinates[i][1]);
                    break;
                case 1:
                    draw3DLetterO(g2d, coordinates[i][0], coordinates[i][1]);
                    break;
                case 2:
                    draw3DLetterS(g2d, coordinates[i][0], coordinates[i][1]);
                    break;
                case 3:
                    draw3DLetterU(g2d, coordinates[i][0], coordinates[i][1]);
                    break;
                case 4:
                    draw3DLetterE(g2d, coordinates[i][0], coordinates[i][1]);
                    break;
            }
        }
    }

    private void drawSignatureSafron(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        // Draw two lines
        g2d.drawLine(x - 150, y, x + 150, y);
        g2d.drawLine(x - 150, y + 20, x + 150, y + 20);

        // Draw "Safron" with semi-oval letters and a signature style
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawArc(x - 70, y + 30, 20, 30, 0, 180); // semi-oval S top
        g2d.drawArc(x - 70, y + 45, 20, 30, 0, -180); // semi-oval S bottom

        g2d.drawLine(x - 40, y + 30, x - 40, y + 60); // side A left
        g2d.drawLine(x - 40, y + 30, x - 20, y + 60); // side A right
        g2d.drawLine(x - 35, y + 45, x - 25, y + 45); // middle line of A

        g2d.drawLine(x - 10, y + 30, x - 10, y + 60); // side F left
        g2d.drawLine(x - 10, y + 30, x + 10, y + 30); // top line of F
        g2d.drawLine(x - 10, y + 45, x + 5, y + 45); // middle line of F

        g2d.drawLine(x + 20, y + 30, x + 20, y + 60); // side R left
        g2d.drawLine(x + 20, y + 30, x + 40, y + 30); // top line of R
        g2d.drawLine(x + 40, y + 30, x + 40, y + 45); // right side of R top
        g2d.drawLine(x + 20, y + 45, x + 40, y + 45); // middle line of R
        g2d.drawLine(x + 20, y + 45, x + 45, y + 60); // bottom diagonal of R

        g2d.drawOval(x + 50, y + 30, 20, 30); // O

        g2d.drawLine(x + 80, y + 30, x + 80, y + 60); // side N left
        g2d.drawLine(x + 80, y + 30, x + 100, y + 60); // diagonal of N
        g2d.drawLine(x + 100, y + 30, x + 100, y + 60); // side N right
    }

    private void draw3DLetterJ(Graphics2D g2d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(x + i, y, x + 10 + i, y);  // parte superior
            g2d.drawLine(x + 10 + i, y, x + 10 + i, y + 30);  // lado derecho
            g2d.drawLine(x + 10 + i, y + 30, x + 5 + i, y + 30);  // curva inferior derecha
            g2d.drawLine(x + 5 + i, y + 30, x + 5 + i, y + 40);  // parte inferior
            g2d.drawLine(x + 5 + i, y + 40, x + i, y + 40);  // parte inferior izquierda
        }
    }

    private void draw3DLetterO(Graphics2D g2d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            g2d.drawOval(x + i, y, 20, 40);  // óvalo
        }
    }

    private void draw3DLetterS(Graphics2D g2d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(x + i, y, x + 20 + i, y);  // parte superior
            g2d.drawLine(x + i, y, x + i, y + 20);  // lado izquierdo superior
            g2d.drawLine(x + i, y + 20, x + 20 + i, y + 20);  // línea media
            g2d.drawLine(x + 20 + i, y + 20, x + 20 + i, y + 40);  // lado derecho inferior
            g2d.drawLine(x + 20 + i, y + 40, x + i, y + 40);  // parte inferior
        }
    }

    private void draw3DLetterU(Graphics2D g2d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(x + i, y, x + i, y + 40);  // lado izquierdo
            g2d.drawLine(x + i, y + 40, x + 20 + i, y + 40);  // parte inferior
            g2d.drawLine(x + 20 + i, y + 20, x + i, y + 20);  // línea media
        }
    }

    private void draw3DLetterE(Graphics2D g2d, int x, int y) {
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(x + i, y, x + 20 + i, y);  // parte superior
            g2d.drawLine(x + i, y, x + i, y + 40);  // lado izquierdo
            g2d.drawLine(x + i, y + 20, x + 20 + i, y + 20);  // línea media
            g2d.drawLine(x + i, y + 40, x + 20 + i, y + 40);  // parte inferior
        }
    }

}
