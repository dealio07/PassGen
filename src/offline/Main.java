package offline;

/**
 * @author Volodymyr Varha
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        int size = Generator.sizeRegister();
        boolean withOrWithoutChars = Generator.withOrWithoutCharacters();
        /**
         * Generating password with taken from input length of the password.
         * @param generator.sizeRegister()
         */
        Generator.generate(size, withOrWithoutChars);

        /**
         * Asking, if user needs one more password. If it's yes, repeating generation and writing.
         * @throws IOException
         */
        try {
            Generator.repeat();
        } catch (IOException e) {
            System.out.println("Can't repeat");
        }

        /**
         * Writing created passwords to the file.
         * @param Generator.passwords
         * @throws IOException
         */
        try {
            Generator.inFileSave(Generator.passwords);
        } catch (IOException e) {
            System.out.println("Can't write into the file");
        }

    }

}