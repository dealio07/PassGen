package offline;

/**
 * @author Volodymyr Varha
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Generator {

    static List<String> passwords = new ArrayList<>();

    /**
     * Generates, saves and shows a password to user in console.
     * @param size
     */
    public static void generate(int size){

        List<String> elements = new ArrayList<>();
        String password = "";

        System.out.println("Here is your password:");

        for (int k = 0; k < size; k++) {
            elements.add(randomCharGenerate());
            System.out.print(elements.get(k));
            password += elements.get(k);
        }
        passwords.add(password);
        System.out.println();
    }

    /**
     * Asks, if user want more passwords.
     * @throws IOException
     */
    public static void repeat() throws IOException {
        System.out.println("Do you need more?\n Enter Y/N");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        switch (str) {
            case "Yes": {
                System.out.println("Okay, one more");
                generate(sizeRegistr());
                repeat();
                break;
            }
            case "yes": {
                System.out.println("Okay, one more");
                generate(sizeRegistr());
                repeat();
                break;
            }
            case "Y": {
                System.out.println("Okay, one more");
                generate(sizeRegistr());
                repeat();
                break;
            }
            case "y": {
                System.out.println("Okay, one more");
                generate(sizeRegistr());
                repeat();
                break;
            }
            case "No": {
                System.out.println("No problem, bye");
                break;
            }
            case "no": {
                System.out.println("No problem, bye");
                break;
            }
            case "N": {
                System.out.println("No problem, bye");
                break;
            }
            case "n": {
                System.out.println("No problem, bye");
                break;
            }
            default: System.out.println("Can't get it. Try typing 'Yes/Y/yes/y' or 'No/N/no/n'");
                repeat();
                break;



        }
    }

    /**
     * Registering the size of password user need from input.
     * @return
     */
    public static int sizeRegistr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the password below (only number):");

        int size;
        if (scanner.hasNextInt()){
            size = scanner.nextInt();

        } else {
            System.out.println("Wrong input");
            return sizeRegistr();
        }

        return size;
    }

    /**
     * Generating string of random chars.
     * @return
     */
    public static String randomCharGenerate(){
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = alphabet.length();

        Random r = new Random();

        return Character.toString(alphabet.charAt(r.nextInt(n)));
    }

    /**
     * Saving the password to the file Password.txt.
     * @param passwords
     * @throws IOException
     */
    public static void inFileSave(List<String> passwords) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Password.txt"),"utf-8"))) {
            for (String pass : passwords) {
                bw.append(pass+"\n");
            }
        } catch (IOException e) {
            System.out.println("Can't create file");
        }
    }

}
