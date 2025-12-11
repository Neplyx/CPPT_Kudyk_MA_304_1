package KI304.Kudyk.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class <code>FioApp</code> is a test driver for the CalcWFio class.
 * It demonstrates calculation, writing and reading results using files.
 *
 * @author Kudyk
 * @version 1.1
 */
public class FioApp {

    /**
     * Main method that runs the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("Enter X (in degrees): ");
            double x = s.nextDouble();

            obj.calculate(x);
            System.out.println("Result is: " + obj.getResult());

            obj.writeResTxt("Result.txt");
            obj.writeResBin("Result.bin");

            obj.readResTxt("Result.txt");
            System.out.println("Read from text: " + obj.getResult());

            obj.readResBin("Result.bin");
            System.out.println("Read from binary: " + obj.getResult());

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number for X.");
        } catch (IOException e) {
            System.out.println("File I/O error: " + e.getMessage());
        
        } finally {
            System.out.println("Program finished.");
            s.close();
        }
    }
}
