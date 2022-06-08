import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    JFrame window;

    public UserInterface() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setTitle("VierGewinnt");
        window.setResizable(false);
    }

    private void initializeButtons() {

        int labelHeight = 50;
        int buttonHeight = 50;
        int chipWidth = Board.chipDiameter;

        for (int column = 0; column < Game.COLUMNS; column++) {
            JButton button = new JButton("\u2193" );
            int yPosition = 5 + labelHeight + 10;
            button.setBounds((column * chipWidth)+ (column * Board.spacing) + 120, yPosition, chipWidth, buttonHeight);
            int targetColumn = column;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.playChip(targetColumn);
                }
            });

            button.setVisible(true);
            window.add(button);
        }


        JButton newGameButton = new JButton("Neues Spiel");
        newGameButton.setBounds(680, 510, 100, 50);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.startNewGame();
            }
        });
        newGameButton.setVisible(true);
        window.add(newGameButton);
    }

    private void initializeBoard() {
        Board board = new Board();
        board.setBounds(0,0,800,600);
        window.add(board);
    }

    public void initialize() {
        initializeButtons();
        initializeBoard();
        window.setVisible(true);
    }
}