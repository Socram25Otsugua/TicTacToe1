import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
    Random rand = new Random();
    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(750, 750);
        this.frame.getContentPane().setBackground(new Color(50, 50, 50));
        this.frame.setLayout(new BorderLayout());
        this.frame.setVisible(true);
        this.textField.setHorizontalAlignment(0);
        this.textField.setBackground(new Color(25, 22, 25));
        this.textField.setForeground(new Color(55, 225, 50));
        this.textField.setFont(new Font("Serif", 1, 75));
        this.textField.setOpaque(true);
        this.textField.setText("Tic-Tac-Toe");
        this.title_panel.setLayout(new BorderLayout());
        this.title_panel.setBounds(0, 0, 800, 100);
        this.button_panel.setLayout(new GridLayout(3, 3));
        this.button_panel.setBackground(new Color(150, 150, 150));

        for(int i = 0; i < 9; ++i) {
            this.buttons[i] = new JButton();
            this.button_panel.add(this.buttons[i]);
            this.buttons[i].setFont(new Font("MV Boli", 1, 125));
            this.buttons[i].setFocusable(false);
            this.buttons[i].addActionListener(this);
        }

        this.title_panel.add(this.textField, "Center");
        this.frame.add(this.title_panel, "North");
        this.frame.add(this.button_panel);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; ++i) {
            if (e.getSource() == this.buttons[i]) {
                if (this.player1_turn) {
                    if (this.buttons[i].getText() == "") {
                        this.buttons[i].setForeground(Color.RED);
                        this.buttons[i].setText("X");
                        this.player1_turn = false;
                        this.textField.setText("O turn");
                        this.check();
                    }
                } else if (this.buttons[i].getText() == "") {
                    this.buttons[i].setForeground(Color.BLUE);
                    this.buttons[i].setText("O");
                    this.player1_turn = true;
                    this.textField.setText("X turn");
                    this.check();
                }
            }
        }

    }

    public void firstTurn() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            throw new RuntimeException(e);
        }

        if (this.rand.nextInt(2) == 0) {
            this.player1_turn = true;
            this.textField.setText("X turn");
        } else {
            this.player1_turn = false;
            this.textField.setText("O turn");
        }

    }

    public void check() {
        if (this.buttons[0].getText() == "X" && this.buttons[1].getText() == "X" && this.buttons[2].getText() == "X") {
            this.xWins(0, 1, 2);
        }

        if (this.buttons[3].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[5].getText() == "X") {
            this.xWins(3, 4, 5);
        }

        if (this.buttons[6].getText() == "X" && this.buttons[7].getText() == "X" && this.buttons[8].getText() == "X") {
            this.xWins(6, 7, 8);
        }

        if (this.buttons[0].getText() == "X" && this.buttons[3].getText() == "X" && this.buttons[6].getText() == "X") {
            this.xWins(0, 3, 6);
        }

        if (this.buttons[1].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[7].getText() == "X") {
            this.xWins(1, 4, 7);
        }

        if (this.buttons[2].getText() == "X" && this.buttons[5].getText() == "X" && this.buttons[8].getText() == "X") {
            this.xWins(2, 5, 8);
        }

        if (this.buttons[0].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[8].getText() == "X") {
            this.xWins(0, 4, 8);
        }

        if (this.buttons[2].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[6].getText() == "X") {
            this.xWins(2, 4, 6);
        }

        if (this.buttons[0].getText() == "O" && this.buttons[1].getText() == "O" && this.buttons[2].getText() == "O") {
            this.oWins(0, 1, 2);
        }

        if (this.buttons[3].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[5].getText() == "O") {
            this.oWins(3, 4, 5);
        }

        if (this.buttons[6].getText() == "O" && this.buttons[7].getText() == "O" && this.buttons[8].getText() == "O") {
            this.oWins(6, 7, 8);
        }

        if (this.buttons[0].getText() == "O" && this.buttons[3].getText() == "O" && this.buttons[6].getText() == "O") {
            this.oWins(0, 3, 6);
        }

        if (this.buttons[1].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[7].getText() == "O") {
            this.oWins(1, 4, 7);
        }

        if (this.buttons[2].getText() == "O" && this.buttons[5].getText() == "O" && this.buttons[8].getText() == "O") {
            this.oWins(2, 5, 8);
        }

        if (this.buttons[0].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[8].getText() == "O") {
            this.oWins(0, 4, 8);
        }

        if (this.buttons[2].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[6].getText() == "O") {
            this.oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        this.buttons[a].setBackground(Color.GREEN);
        this.buttons[b].setBackground(Color.GREEN);
        this.buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; ++i) {
            this.buttons[i].setEnabled(false);
        }

        this.textField.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        this.buttons[a].setBackground(Color.GREEN);
        this.buttons[b].setBackground(Color.GREEN);
        this.buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; ++i) {
            this.buttons[i].setEnabled(false);
        }

        this.textField.setText("O wins");
    }
}
