package offline;

/**
 * @author Volodymyr Varha
 */

import java.io.*;

public class Main {

    public static void main(String[] args){
        /**
         * Instantiating Generator object.
         */
        Generator generator = new Generator();

        /**
         * Generating password with taken from input length of the password.
         * @param generator.sizeRegistr()
         */
        generator.generate(generator.sizeRegistr());

        /**
         * Asking, if user needs one more password. If it's yes, repeating generation and writing.
         * @throws IOException
         */
        try {
            generator.repeat();
        } catch (IOException e) {
            System.out.println("Can't repeat");
        }

        /**
         * Writing created passwords to the file.
         * @param generator.passwords
         * @throws IOException
         */
        try {
            generator.inFileSave(generator.passwords);
        } catch (IOException e) {
            System.out.println("Can't write into the file");
        }

    }

}