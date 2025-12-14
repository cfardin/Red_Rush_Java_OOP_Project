import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class RoadPanel extends JPanel {

    int lineY = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);

        int dashH = 20;
        int dashGap = 20;
        int centerX = getWidth() / 2 - 2;

        for (int i = -dashH; i < getHeight(); i += dashH + dashGap) {
            int y = i + lineY;
            g.fillRect(centerX, y, 4, dashH);
        }
    }

    public void moveLine(int speed) {
        lineY += speed;
        if (lineY > 40)
            lineY = 0;
        repaint();
    }
}