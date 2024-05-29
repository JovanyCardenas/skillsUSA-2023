import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
    PROJECT IS INCOMPLETE, but I worked on it as much as I could
 */



public class Project2 extends JFrame {
    public static int p1HP = 10;
    public static int p2HP = 10;
    public static boolean p1Turn = true;
    public static Random rng = new Random();

    public static int playerNum1 = 2;
    public static int playerNum2 = 2;

    public static void main(String[] args) {
        new Project2();
    }

    public Project2() { //Creates GUI
        super.setSize(1000, 800);
        super.setTitle("Bombs Away!");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        build();
        super.setVisible(true);
    }

    public void build() { //Builds each GUI component
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[225];

        playerNum1 = rng.nextInt(225);//2 random starting locations
        playerNum2 = rng.nextInt(225);

        for (int x = 0; x < 225; x++) {
            if (x == playerNum1 || x == playerNum2) { //It was working earlier, but now it says p1 & p2 are null
                if (x == playerNum1) {
                    JButton p1 = buttons[x];
                    p1.setText("P1");
                    p1.setBackground(Color.white);
                    panel.add(p1);
                } else {
                    JButton p2 = buttons[x];
                    p2.setText("P2");
                    p2.setBackground(Color.white);
                    panel.add(p2);
                }
            } else { //creates every other button and adds it to the gui and sets the color to cyan
                int math = x + 1;
                panel.add(buttons[x] = new JButton(String.valueOf(math))).setBackground(Color.cyan);
            }
        }


        LayoutManager layoutManager = new GridLayout(15, 15);//formats it into a grid 15x15
        panel.setLayout(layoutManager);
        super.add(panel);

        //going to move when you click on a different square
        JButton buttonLeft = buttons[playerNum1 - 1];
        JButton buttonRight = buttons[playerNum1 + 1];
        JButton buttonBottom = buttons[playerNum1 - 15];
        JButton buttonTop = buttons[playerNum1 + 15];

        JButton buttonLeft2 = buttons[playerNum2 - 1];
        JButton buttonRight2 = buttons[playerNum2 + 1];
        JButton buttonBottom2 = buttons[playerNum2 - 15];
        JButton buttonTop2 = buttons[playerNum2 + 15];

        buttonLeft.addActionListener(event -> {
            JButton op1 = buttons[playerNum1];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum1 - 1];
            playerNum1 = playerNum1 - 1;
        });
        buttonRight.addActionListener(event -> {
            JButton op1 = buttons[playerNum1];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum1 + 1];
            playerNum1 = playerNum1 + 1;
        });
        buttonBottom.addActionListener(event -> {
            JButton op1 = buttons[playerNum1];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum1 - 15];
            playerNum1 = playerNum1 - 15;
        });
        buttonTop.addActionListener(event -> {
            JButton op1 = buttons[playerNum1];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum1 + 15];
            playerNum1 = playerNum1 + 15;
        });

        buttonLeft2.addActionListener(event -> {
            JButton op1 = buttons[playerNum2];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum2 - 1];
            playerNum2 = playerNum2 - 1;
        });
        buttonRight2.addActionListener(event -> {
            JButton op1 = buttons[playerNum2];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum2 + 1];
            playerNum2 = playerNum2 + 1;
        });
        buttonBottom2.addActionListener(event -> {
            JButton op1 = buttons[playerNum2];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum2 - 15];
            playerNum2 = playerNum2 - 15;
        });
        buttonTop2.addActionListener(event -> {
            JButton op1 = buttons[playerNum2];
            op1.setBackground(Color.black);
            op1.setText("--");
            JButton p1 = buttons[playerNum2 + 15];
            playerNum2 = playerNum2 + 15;
        });

        //NOT FINISHED!!!

        int randomNum[] = new int[30];
        for (int x = 0; x < 10; x++) {
            randomNum[x] = rng.nextInt(225);
        }
        JButton but = buttons[randomNum[0]];
        JButton but1 = buttons[randomNum[1]];
        JButton but2= buttons[randomNum[2]];
        JButton but3 = buttons[randomNum[3]];
        JButton but4 = buttons[randomNum[4]];
        JButton but5 = buttons[randomNum[5]];
        JButton but6 = buttons[randomNum[6]];
        JButton but7 = buttons[randomNum[7]];

        but.addActionListener(event->{
            but.setText("BOMB!");
            but.setEnabled(false);
        }); but1.addActionListener(event->{
            but1.setText("BOMB!");
            but1.setEnabled(false);
        }); but2.addActionListener(event->{
            but2.setText("BOMB!");
            but2.setEnabled(false);
        }); but3.addActionListener(event->{
            but3.setText("BOMB!");
            but3.setEnabled(false);
        }); but4.addActionListener(event->{
            but4.setText("BOMB!");
            but4.setEnabled(false);
        }); but5.addActionListener(event->{
            but5.setText("BOMB!");
            but5.setEnabled(false);
        }); but6.addActionListener(event->{
            but6.setText("BOMB!");
            but6.setEnabled(false);
        }); but7.addActionListener(event->{
            but7.setText("BOMB!");
            but7.setEnabled(false);
        });
    }
}
