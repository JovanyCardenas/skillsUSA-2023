import java.lang.reflect.Array;

public class Encrypt {
    public static String encrypt(int input) {
         int four =(input % 10);
         input = input / 10;
         int three = (input % 10);
        input = input / 10;
         int two = (input % 10);
        input = input / 10;
         int one = (input % 10);

        int finalone = (three + 7)%10;
        int finaltwo = (four + 7)%10;
        int finalthree = (one + 7)%10;
        int finalfour = (two + 7)%10;

        return finalone + "" + finaltwo + finalthree + finalfour;
    }
    public static String decrypt(int input) {

        int four = (input % 10);
        input = input / 10;
        int three = (input % 10);
        input = input / 10;
        int two = (input % 10);
        input = input / 10;
        int one = (input % 10);

        int finalon = (three - 7);
        int finaltw = (four - 7);
        int finalthre = (one - 7);
        int finalfou = (two - 7);

        if (finalon < 0) {
            finalon+=10;
        }
        if (finaltw < 0) {
            finaltw+=10;
        }
        if (finalthre < 0) {
            finalthre+=10;
        }
        if (finalfou < 0) {
            finalfou+=10;
        }
        return finalon + "" + finaltw + finalthre + finalfou;
    }
}
