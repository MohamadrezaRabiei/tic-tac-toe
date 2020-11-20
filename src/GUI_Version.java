import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Version implements ActionListener {
    private static JFrame mainFrame = new JFrame("Tic-Tac-Toe");

    private String winner = "";
    private String player = "X";

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JButton btn6 = new JButton();
    JButton btn7 = new JButton();
    JButton btn8 = new JButton();
    JButton btn9 = new JButton();

    JButton btnReset = new JButton("Reset");

    JLabel lblStatus = new JLabel();
    JButton[] buttons;


    static int fontSize = 70;
    private static Font font = new Font("arial", Font.BOLD, fontSize);


    public void btnCellAction() {

        //Set Buttons Location:
        btn1.setBounds(10, 10, 110, 110);

        //btn2:
        btn2.setBounds(130, 10, 110, 110);
        //btn3:
        btn3.setBounds(250, 10, 110, 110);
        //btn4:
        btn4.setBounds(10, 130, 110, 110);
        //btn5:
        btn5.setBounds(130, 130, 110, 110);
        //btn6:
        btn6.setBounds(250, 130, 110, 110);
        //btn7:
        btn7.setBounds(10, 250, 110, 110);
        //btn8:
        btn8.setBounds(130, 250, 110, 110);
        //btn9:
        btn9.setBounds(250, 250, 110, 110);

        //btnReset:
        btnReset.setBounds(150, 365, 70, 32);


        //Adding Buttons to Frame:
        mainFrame.add(btn1);
        mainFrame.add(btn2);
        mainFrame.add(btn3);
        mainFrame.add(btn4);
        mainFrame.add(btn5);
        mainFrame.add(btn6);
        mainFrame.add(btn7);
        mainFrame.add(btn8);
        mainFrame.add(btn9);
        mainFrame.add(btnReset);


        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);

    }

    //Class Constructor:
    public GUI_Version() {
        buttons = new JButton[9];
        buttons[0] = btn1;
        buttons[1] = btn2;
        buttons[2] = btn3;
        buttons[3] = btn4;
        buttons[4] = btn5;
        buttons[5] = btn6;
        buttons[6] = btn7;
        buttons[7] = btn8;
        buttons[8] = btn9;

        mainFrame.setSize(440, 440);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);

        lblStatus.setBounds(260, 370, 60, 23);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        btnCellAction();
        updateStatus();

        mainFrame.add(lblStatus);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnAll = (JButton) e.getSource();

        if (!winner.isEmpty()) return;

        if (!btnAll.getText().isEmpty()) {
            return;
        }

        btnAll.setText(player);
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }

        updateStatus();
    }




    private void reset() {
        player = "X";
        for (JButton btn : buttons) {
            btn.setText("");
        }

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        updateStatus();
    }

    private void updateStatus() {
        winner = getWinner();

        btnReset.setEnabled(!winner.isEmpty());
        String status;

        switch (winner) {
            case "X":
                status = "X Wins!";
                break;

            case "O":
                status = "O Wins!";
                break;

            case "D":
                status = "Draw";
                break;

            default:
                status = player + " Round";
        }

        lblStatus.setText(status);
    }

    private String getWinner() {
        int[] c = new int[9];
        int nEmpty = 0;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("X"))
                c[i] = 1;

            if (buttons[i].getText().equals("O"))
                c[i] = 2;

            if (c[i] == 0)
                nEmpty++;
        }

        if (isWinner(c,1)) return "X";
        if (isWinner(c,2)) return "O";

        if (nEmpty > 1) {
            return "";
        } else {
            return "D";
        }

    }

    private boolean isWinner(int[] c, int p){
        if (c[0] == p && c[1] == p && c[2] == p) return true;
        if (c[3] == p && c[4] == p && c[5] == p) return true;
        if (c[6] == p && c[7] == p && c[8] == p) return true;

        if (c[0] == p && c[3] == p && c[6] == p) return true;
        if (c[1] == p && c[4] == p && c[7] == p) return true;
        if (c[2] == p && c[5] == p && c[8] == p) return true;

        if (c[0] == p && c[4] == p && c[8] == p) return true;
        if (c[2] == p && c[4] == p && c[6] == p) return true;

        return false;

    }


    //Main Method:
    public static void main(String[] args) {
        GUI_Version ttt = new GUI_Version();

    }

}


