import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Project1 extends JFrame {
    //Variables saved up here to be able to access them throughout the entire file
    public static String correctName;
    public static String fullName;
    public static String anagram;
    public static ArrayList<String> lines = new ArrayList<>();
    public static ArrayList<String> anagramList = new ArrayList<>();

    public static void main(String[] args) {
        //reads through dictionary and saves it in an arrayList
        try {
            File f = new File("dictionary.txt");
            Scanner fileReader = new Scanner(f);
            while (fileReader.hasNext()) {
                lines.add(fileReader.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File \"dictionary.txt\" is not found!");
        }
        new Project1();
    }

    public Project1() { //creates the GUI, its size & title here
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(600, 800);
        super.setTitle("Anagrams");
        build();
        super.setVisible(true);
    }

    public void build() {
        //Creates the panel, label, textField, and buttons that appear on GUI
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your full name");
        JTextField name = new JTextField(20);
        JButton rearrange = new JButton("Rearrange Name");

        //adds the things to the panel then adds the panel to the GUI
        panel.add(label);
        panel.add(name);
        panel.add(rearrange);

        super.add(panel);

        rearrange.addActionListener(event -> { //When the button is clicked it checks to look and see which anagrams
            int y = 0;
            for (int x = 0; x < name.getText().length(); x++) {
                if ((Character.isLetter(name.getText().charAt(x))) || Character.isWhitespace(name.getText().charAt(x))) {
                    y++;
                }
            }
            if (y >= name.getText().length()) {
                fullName = "";
                String[] names = name.getText().toLowerCase().split(" ");
                for (int z = 0; z < names.length; z++){
                    fullName = fullName + names[z].toLowerCase();
                }
                ArrayList<String> characters = new ArrayList<>();
                for (int x = 0; x < fullName.length(); x++) {
                    characters.add(String.valueOf(fullName.charAt(x)));
                }
                Collections.sort(characters);
                    fullName = "";
                for (int x = 0; x < characters.size(); x++){
                    fullName = fullName + characters.get(x);
                }
                correctName = name.getText();
                check();

                JOptionPane.showMessageDialog(this, "Anagram for " + correctName + " is " + anagram);
            } else {
                JOptionPane.showMessageDialog(this, "Input name with alphabetical letters only!");
            }
        });
    }

    public void check() {
        ArrayList<String> possibleList = new ArrayList<>(); //ArrayList to add all possible anagrams
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < fullName.length(); x++) {
                if (lines.get(y).contains(String.valueOf(fullName.charAt(x)))) { //checks to see if the first character of name is in the lines list and adds it to a possible answer
                    possibleList.add(lines.get(y));
                }
            }
        }

        ArrayList<String> possibleList1 = new ArrayList<>();
        for (int x = 0; x < possibleList.size(); x++) {
            if (possibleList.get(x).length() <= fullName.length()) { //makes sure possible anagrams aren't longer than the name
                possibleList1.add(possibleList.get(x));
            }
        }

        int z = 0;
        for (int theta = 0; theta < possibleList1.size(); theta++) {
            for (int x = 0; x < fullName.length(); x++) {
                if (possibleList1.get(theta).contains(String.valueOf(fullName.charAt(x)))) {
                    z++;
                } else {
                    z = 0;
                    x = fullName.length();
                    theta++;
                }
            }
            if (z == fullName.length()) {
                anagram = possibleList1.get(theta);
                theta = possibleList1.size();
            }
        }

        //Write all anagrams logged into "log.txt"
        try {
            anagramList.add(correctName + " == " + anagram);
            File f = new File("log.txt");
            FileWriter fileWriter = new FileWriter(f);
            for (int x = 0; x < anagramList.size(); x++) {
                fileWriter.write(anagramList.get(x) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
