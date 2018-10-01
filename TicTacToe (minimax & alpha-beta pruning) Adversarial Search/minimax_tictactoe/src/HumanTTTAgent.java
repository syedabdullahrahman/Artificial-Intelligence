
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HumanTTTAgent extends Agent {

    static Scanner in = new Scanner(System.in);
    TickTackToe TTTgame;
    boolean given;

    public HumanTTTAgent(String name) {
        super(name);
    }

    @Override
    public void makeMove(Game game) {
        turn.setText("Your turn...");
        TTTgame = (TickTackToe) game;
//        TTTgame = tttGame;
//        
//        int row = -1, col = -1;
//
//        System.out.println("Row & Column:");
//        row = in.nextInt();
//        col = in.nextInt();
//        if (!tttGame.isValidCell(row, col)) {
//            System.out.println("Enter valid Row & Column:");
//            row = in.nextInt();
//            col = in.nextInt();
//        }
//        tttGame.board[row][col] = role;
        while (!given) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HumanTTTAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        given = false;
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == button1) {
            button1.setText("O");
            button1.setEnabled(false);
            TTTgame.board[0][0] = role;
            given = true;
        } else if (a.getSource() == button2) {
            button2.setText("O");
            button2.setEnabled(false);
            TTTgame.board[0][1] = role;
            given = true;
        } else if (a.getSource() == button3) {
            button3.setText("O");
            button3.setEnabled(false);
            TTTgame.board[0][2] = role;
            given = true;
        } else if (a.getSource() == button4) {
            button4.setText("O");
            button4.setEnabled(false);
            TTTgame.board[1][0] = role;
            given = true;
        } else if (a.getSource() == button5) {
            button5.setText("O");
            button5.setEnabled(false);
            TTTgame.board[1][1] = role;
            given = true;
        } else if (a.getSource() == button6) {
            button6.setText("O");
            button6.setEnabled(false);
            TTTgame.board[1][2] = role;
            given = true;
        } else if (a.getSource() == button7) {
            button7.setText("O");
            button7.setEnabled(false);
            TTTgame.board[2][0] = role;
            given = true;
        } else if (a.getSource() == button8) {
            button8.setText("O");
            button8.setEnabled(false);
            TTTgame.board[2][1] = role;
            given = true;
        } else if (a.getSource() == button9) {
            button9.setText("O");
            button9.setEnabled(false);
            TTTgame.board[2][2] = role;
            given = true;
        }
    }
}
