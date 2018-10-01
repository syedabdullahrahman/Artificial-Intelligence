
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Extend this abstract class for human/ AI agent
 *
 *
 */
public abstract class Agent implements ActionListener {

    String name;
    int role;

    //Jframe
    static JFrame window = new JFrame("Tic-Tac-Toe");
    static JPanel panel = new JPanel();
    static JLabel message = new JLabel("Computer:   X    You:   O");
    static JLabel turn = new JLabel("");
    static JLabel time = new JLabel("");
    static JButton button1 = new JButton("");
    static JButton button2 = new JButton("");
    static JButton button3 = new JButton("");
    static JButton button4 = new JButton("");
    static JButton button5 = new JButton("");
    static JButton button6 = new JButton("");
    static JButton button7 = new JButton("");
    static JButton button8 = new JButton("");
    static JButton button9 = new JButton("");

    public Agent(String name) {
        this.name = name;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void TicTacToe() {

        window.setSize(350, 450);
        window.setLayout(new GridLayout(4, 3));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        message.setBounds(50, 25, 100, 30);
        message.setFont(new Font("Serif", Font.BOLD, 16));
        turn.setBounds(160, 25, 100, 30);
        turn.setFont(new Font("Serif", Font.BOLD, 16));
        time.setBounds(160, 25, 100, 30);
        time.setFont(new Font("Serif", Font.BOLD, 16));

        window.add(message);
        window.add(time);
        window.add(turn);
        

        panel.setLayout(new GridLayout(3, 3));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        window.add(panel);

        button1.addActionListener(this);
        button1.setFont(new Font("Serif", Font.BOLD, 16));
        button2.addActionListener(this);
        button2.setFont(new Font("Serif", Font.BOLD, 16));
        button3.addActionListener(this);
        button3.setFont(new Font("Serif", Font.BOLD, 16));
        button4.addActionListener(this);
        button4.setFont(new Font("Serif", Font.BOLD, 16));
        button5.addActionListener(this);
        button5.setFont(new Font("Serif", Font.BOLD, 16));
        button6.addActionListener(this);
        button6.setFont(new Font("Serif", Font.BOLD, 16));
        button7.addActionListener(this);
        button7.setFont(new Font("Serif", Font.BOLD, 16));
        button8.addActionListener(this);
        button8.setFont(new Font("Serif", Font.BOLD, 16));
        button9.addActionListener(this);
        button9.setFont(new Font("Serif", Font.BOLD, 16));
        
        window.setVisible(true);

    }

    public abstract void makeMove(Game game);

}
