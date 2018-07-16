
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Extend this abstract class for your game implementation
 *
 *
 */
public abstract class Game {

    Agent agent[];
    String name = "A Generic Game";
    Random random = new Random();
    Agent winner = null;

    public Game(Agent a, Agent b) {
        agent = new Agent[2];
        agent[0] = a;
        agent[1] = b;

    }

    public void play() {
        updateMessage("Starting " + name + " between " + agent[0].name + " and " + agent[1].name + ".");
        int turn = random.nextInt(2);

        //System.out.println(agent[turn].name+ " makes the first move.");
        initialize(false);

        while (!isFinished()) {
            updateMessage(agent[turn].name + "'s turn. ");
            agent[turn].makeMove(this);
            showGameState();
            turn = (turn + 1) % 2;
        }

        if (winner != null) {
            updateMessage(winner.name + " wins!!!");
            JOptionPane.showMessageDialog(null,winner.name + " WINS!");
            agent[0].window.setVisible(false);
            System.exit(0);
        } else {
            updateMessage("Game drawn!!");
            JOptionPane.showMessageDialog(null, "Tie Game!");
            agent[0].window.setVisible(false);
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        String str = "";
        return str;
    }

    abstract boolean isFinished();

    abstract void initialize(boolean fromFile);

    abstract void showGameState();

    abstract void updateMessage(String msg);
}
