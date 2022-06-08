import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {
    public static final int chipDiameter = 70;
    public static final int spacing = 4;
    private static final Color backgroundColor = new Color(86, 138, 199);
    private static final Color colorPlayer2 = new Color(246, 245, 35);
    private static final Color colorPlayer1 = new Color(232, 79, 76);
    private static final Color colorWinner = new Color(22, 193, 40);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setFont(new Font( "Default", Font.PLAIN, 20));

        g2D.setColor(backgroundColor);
        g2D.fillRect(0,0,800,600);

        renderBoard(g2D, Game.board);
        printStatusMessage(g2D, Game.statusMessage);
        renderActivePlayer(g2D, Game.activePlayer);
        repaint();
    }
    private void printStatusMessage(Graphics g2D, String message){
        g2D.setColor(Color.white);
        g2D.drawString(message,120,25);
    }
    private void renderActivePlayer(Graphics g2D, int player){
        g2D.setColor(Color.white);

        if (player > 0){
            g2D.drawString("Spieler " + player + " ist am Zug.", 120, 50);
        }

    }
    private void renderBoard(Graphics g2D, int[][] board) {

        int xPosition = 120;
        int yPosition = 120;

        for (int row = 0; row < Game.ROWS; row++) {
            for (int column = 0; column < Game.COLUMNS; column++) {
                renderChip(g2D, xPosition + (column * chipDiameter) + (column * spacing), yPosition + (row * chipDiameter) + (row * spacing), board[row][column]);
            }
        }
    }

    private void renderChip(Graphics g2D, int x, int y, int player) {

        int spacing = 2;

        g2D.setColor(Color.white);
        g2D.fillOval(x, y, chipDiameter, chipDiameter);
        g2D.setColor(Color.black);
        g2D.drawOval(x, y, chipDiameter, chipDiameter);

        if (player == 1) {
            g2D.setColor(colorPlayer1);
        }

        if (player == 2) {
            g2D.setColor(colorPlayer2);
        }

        if (player == 3) {
            g2D.setColor(colorWinner);
        }

        if (player > 0) {
            g2D.fillOval(x + spacing, y + spacing, chipDiameter - (spacing * 2), chipDiameter - (spacing * 2));
        }
    }
}
