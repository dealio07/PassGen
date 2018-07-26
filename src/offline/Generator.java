package offline;

/**
 * @author Volodymyr Varha
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Generator {

    static List<String> passwords = new ArrayList<>();

    /**
     * Generates, saves and shows a password to user in console.
     */
    static void generate(int size, boolean withChars){

        List<String> elements = new ArrayList<>();
        StringBuilder password = new StringBuilder();

        System.out.println("Here is your password:");

        Character previousElement = 0;
        for (int k = 0; k < size;) {
            Character element = randomCharGenerate(withChars);
            boolean charsCond = element.equals(previousElement);
            boolean stringsCond = element.toString().toLowerCase().equals(previousElement.toString().toLowerCase());
            boolean condition = charsCond || stringsCond;
            if (!condition) {
                elements.add(element.toString());
                System.out.print(elements.get(k));
                password.append(elements.get(k));
                previousElement = element;
                k++;
            }
        }
        passwords.add(password.toString());
        System.out.println();
    }

    /**
     * Asks, if user want more passwords.
     * @throws IOException
     */
    static void repeat() throws IOException {
        System.out.println("Do you need more?\n (Enter Y/N)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        switch (str) {
            case "Yes": {
                doIfYes();
                break;
            }
            case "yes": {
                doIfYes();
                break;
            }
            case "Y": {
                doIfYes();
                break;
            }
            case "y": {
                doIfYes();
                break;
            }
            case "No": {
                System.out.println("---------------------------\nBye\n---------------------------");
                break;
            }
            case "no": {
                System.out.println("---------------------------\nBye\n---------------------------");
                break;
            }
            case "N": {
                System.out.println("---------------------------\nBye\n---------------------------");
                break;
            }
            case "n": {
                System.out.println("---------------------------\nBye\n---------------------------");
                break;
            }
            default: System.out.println("Can't get it. Try typing 'Yes/Y/yes/y' or 'No/N/no/n'");
                repeat();
                break;



        }
    }

    private static void doIfYes() throws IOException {
        System.out.println("---------------------------\nOne more\n---------------------------");
        generate(sizeRegister(), withOrWithoutCharacters());
        repeat();
    }

    /**
     * Registering the size of password user need from input.
     */
    static int sizeRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the password below (only number):");

        int size;
        if (scanner.hasNextInt()){
            size = scanner.nextInt();

        } else {
            System.out.println("Wrong input");
            return sizeRegister();
        }

        return size;
    }

    static boolean withOrWithoutCharacters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("With special characters like '-+=.$%' ?  (Enter Y, if yes)");

        String answer;
        boolean result = false;
        if (scanner.hasNextLine()) {
            answer = scanner.nextLine();
            switch (answer) {
                case "Yes": {
                    result = true;
                    break;
                }
                case "yes": {
                    result = true;
                    break;
                }
                case "Y": {
                    result = true;
                    break;
                }
                case "y": {
                    result = true;
                    break;
                }
                default:
                    result = false;
                    break;
            }
        }
        return result;
    }

    /**
     * Generating string of random chars.
     */
    private static Character randomCharGenerate(boolean withChars){
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetWithChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()-_=+.>,</?;:'|[{]}";
        int n = withChars ? alphabetWithChars.length() : alphabet.length();

        Random r = new Random();

        return withChars ? alphabetWithChars.charAt(r.nextInt(n)) : alphabet.charAt(r.nextInt(n));
    }

    /**
     * Saving the password to the file Password.txt.
     * @throws IOException
     */
    static void inFileSave(List<String> passwords) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Password.txt"),"utf-8"))) {
            for (String pass : passwords) {
                bw.append(pass+"\n");
            }
        } catch (IOException e) {
            System.out.println("Can't create file");
        }
    }

}
