import javax.swing.*;
import java.awt.*;

/*
        SkillsUSA CA Task #2
        Contestant # 5010
        12:10 PM 4/15/2023
 */
public class contestTask2 extends JFrame {
    public int year = 0;
    public double beginValue = 0;
    public double depreciation = 0;
    public double endValue = 0;

    public contestTask2() {
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Contestant#5010 Task#2 Asset Inventory Tracking Program");
        super.setSize(600, 800);
        buildPanel();
        super.setVisible(true);
    }

    public void buildPanel() {
        //Create each button and label and add them to the panel
        JPanel panel = new JPanel();
        JLabel assetName = new JLabel("Asset Name: ");
        JTextField asset = new JTextField(25);

        JLabel assetValue = new JLabel("Asset Value: ");
        JTextField valueText = new JTextField("0", 10);

        JLabel depreciateYears = new JLabel("Number of Years to Depreciate: ");
        JTextField depreciate = new JTextField("0", 10);

        JLabel salvageValue = new JLabel("Salvage Value (Value of Item after number of years depreciation): ");
        JTextField salvageV = new JTextField("0", 10);

        panel.add(assetName);
        panel.add(asset);
        panel.add(assetValue);
        panel.add(valueText);
        panel.add(depreciateYears);
        panel.add(depreciate);
        panel.add(salvageValue);
        panel.add(salvageV);
        super.add(panel, BorderLayout.CENTER); //Panel puts them in the center


        //Creates each button and adds it to JPanel then adds JPanel to GUI
        JPanel buttons = new JPanel();
        JButton calculate = new JButton("Calculate");
        JButton reset = new JButton("Clear Input");
        JButton exit = new JButton("Exit");
        buttons.add(calculate);
        buttons.add(reset);
        buttons.add(exit);
        super.add(buttons, BorderLayout.SOUTH);


        calculate.addActionListener(event -> {
            if (asset.getText().length() > 25){
                System.out.println("Limit Characters is 25");
            }
            for (int x = 0; x < valueText.getText().length(); x++) {
                if (!Character.isDigit(valueText.getText().charAt(x))) {
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    valueText.setText("");
                } else{
                    beginValue = Double.parseDouble(valueText.getText());
                }
            }
            for (int x = 0; x < depreciate.getText().length(); x++) {
                if (!Character.isDigit(depreciate.getText().charAt(x))) {
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    depreciate.setText("");
                }else {
                    year = Integer.parseInt(depreciate.getText());
                }
            }
            for (int x = 0; x < salvageV.getText().length(); x++) {
                if (!Character.isDigit(salvageV.getText().charAt(x))) {
                    JOptionPane.showMessageDialog(this, "Input is not Valid!");
                    salvageV.setText("");
                }else{
                    endValue = Double.parseDouble(salvageV.getText());
                }
            }
            if (valueText.getText().equals("") ||depreciate.getText().equals("") ||salvageV.getText().equals("") || !(asset.getText().length() > 25)){
            calculation();}
        });
        reset.addActionListener(event -> {
            asset.setText("");
            valueText.setText("0");
            depreciate.setText("0");
            salvageV.setText("0");
        });
        exit.addActionListener(event -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        new contestTask2();
    }

    public void calculation() {
            depreciation = -1*((endValue * year) - beginValue);
        JOptionPane.showMessageDialog(this, String.format("Depreciation Schedule\nYear: %4d\nBeginning Value: %4.2f\nDepreciation Amount: %4.2f\nEnding Value: %4.2f", year, beginValue, depreciation, endValue));
    }
}
