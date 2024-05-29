import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Encryption Program v0.0.1");


        boolean repeat = true;
        while (repeat) { //repeat the encrypting program or not
            repeat = false;


            System.out.println("Please enter a 4-digit number");
            int encrypt = keyboard.nextInt();

            String encryptedMessage = null, decryptedMessage = null;
            int y = 0;

                do { //do while the number is 4 digits no more or no less

                    String len = "" + encrypt;
                    int length = len.length();
                    if (length == 4) {
                        encryptedMessage = Encrypt.encrypt(encrypt);
                        decryptedMessage = Encrypt.decrypt(encrypt);
                        y++;
                    } else {
                        System.out.println("Please enter a 4-digit number");
                        encrypt = keyboard.nextInt();
                    }
                } while (y == 0);

            FileWriter fwriter = new FileWriter("encryptedmessages.txt", true);
            PrintWriter file = new PrintWriter(fwriter);

            //prints out encrypted and decrypted information in file
            file.println("Encrypted:" + encryptedMessage);
            file.println("Decrypted:" + decryptedMessage);

            file.close();

            //asks if you want to repeat the program, clear the file, or exit the program
            System.out.println("Enter a number from 0-2");
            System.out.println("[1] Enter more Data");
            System.out.println("[2] Clear File");
            System.out.println("[0] Exit Program");
            int numenter = keyboard.nextInt();
            if (numenter == 0) {
                System.exit(0);
            } else if (numenter == 1) {
                repeat = true;
            } else if (numenter == 2) {
                PrintWriter clearFile = new PrintWriter("encryptedmessages.txt");
                clearFile.print("");
                clearFile.close();
            }
        }
    }
}
