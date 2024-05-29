import javax.swing.*;
import java.awt.*;
/*
        SkillsUSA CA Task #1
        Contestant # 5010
        11:00 AM 4/15/2023
 */
public class contestTask1 extends JFrame {
    public double value = 0;
    public double interestRate = 0;
    public int numOfYears = 0;
    public char compoundPeriod;
    public double output = 1;
    public contestTask1(){
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Future Value Calculator Program");
        super.setSize(600,800); //Size of GUI
        buildPanel(); //Creates the GUI
        super.setVisible(true);
    }
    public void buildPanel(){
            //Creates input and its labels
        JPanel input = new JPanel();
        JLabel presentValue = new JLabel("Present Value Dollars: ");
        JTextField presentValueText = new JTextField(10);
        input.add(presentValue);
        input.add(presentValueText);

        JLabel interest = new JLabel("Interest Rate: ");
        JTextField interestText = new JTextField(5);
        input.add(interest);
        input.add(interestText);

        JLabel numOYears = new JLabel("Number of Years: ");
        JTextField numOYearsText = new JTextField(5);
        input.add(numOYears);
        input.add(numOYearsText);

        JLabel compoundingPeriod = new JLabel("Compounding Period(Yearly or Monthly): ");
        JTextField compPeriod = new JTextField(5);
        input.add(compoundingPeriod);
        input.add(compPeriod);

            //adds it to GUI
        super.add(input, BorderLayout.CENTER);


            //Creates each button and adds it to JPanel then adds JPanel to GUI
        JPanel buttons = new JPanel();
        JButton calculate = new JButton("Calculate");
        JButton reset = new JButton("Clear Input");
        JButton exit = new JButton("Exit");
        buttons.add(calculate);
        buttons.add(reset);
        buttons.add(exit);
        super.add(buttons, BorderLayout.SOUTH);


            //When "Calculate" button is pressed, it checks validation of input
        calculate.addActionListener(event ->{
            //Checks first input if its only numbers if not it clears it and says not valid
            for (int x = 0; x < presentValueText.getText().length(); x++){
                if (presentValueText.getText().contains(".")){
                    value = Double.parseDouble(presentValueText.getText());
                }
                else if (!Character.isDigit(presentValueText.getText().charAt(x))){
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    presentValueText.setText("");
                }else{
                    value = Double.parseDouble(presentValueText.getText());
                }
            }
            //Checks second input if its only numbers if not it clears it and says not valid
            for (int x = 0; x < interestText.getText().length(); x++){
                if (interestText.getText().contains(".")){
                    interestRate = Double.parseDouble(interestText.getText());
                } else if (!Character.isDigit(interestText.getText().charAt(x))){
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    interestText.setText("");
                }else{
                    interestRate = Double.parseDouble(interestText.getText());
                }
            }
            //Checks third input if its only numbers if not it clears it and says not valid
            for (int x = 0; x < numOYearsText.getText().length(); x++){
                if (!Character.isDigit(numOYearsText.getText().charAt(x))){
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    numOYearsText.setText("");
                } else{
                    numOfYears = Integer.parseInt(numOYearsText.getText());
                }
            }
            //Checks fourth input if its letters if not it clears it and says not valid, also checks if input starts with either 'm' or 'y'
            for (int x = 0; x < compPeriod.getText().length(); x++){
                if (!Character.isLetter(compPeriod.getText().charAt(x))){
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    compPeriod.setText("");
                }else if (compPeriod.getText().toUpperCase().charAt(0) == 'M' || compPeriod.getText().toUpperCase().charAt(0) == 'Y' ){
                    compoundPeriod = compPeriod.getText().charAt(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    compPeriod.setText("");
                }

            }

            if (!presentValueText.getText().equals("") || !interestText.getText().equals("")|| !numOYearsText.getText().equals("") || !compPeriod.getText().equals("")){
                calculation();
            }
        });
            //When "Reset" is pressed it clears the text boxes
        reset.addActionListener(event ->{
            presentValueText.setText("");
            interestText.setText("");
            numOYearsText.setText("");
            compPeriod.setText("");

        });
            //When "Exit" is pressed it exits the program
        exit.addActionListener(event ->{
            System.exit(0);
        });
    }
    public static void main(String[] args) {
        //opens GUI
        new contestTask1();
    }
    public void calculation(){
        //calculates the output from the input
            output = 1;
        if (compoundPeriod == 'M'){
            for (int y = 0; y < (numOfYears * 12); y++){
                output = output * (1 + interestRate/12);
            }
                output = output * value;
            //A = P(1 + r/n)^nt
        }else if (compoundPeriod == 'Y'){
            for (int y = 0; y < (numOfYears); y++) {
                output = output *(1 + interestRate);
            }
            output = output * value;
        }
        JOptionPane.showMessageDialog(this, String.format("Output: %.2f", output));
    }
}
