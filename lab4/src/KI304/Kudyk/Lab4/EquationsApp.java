package KI304.Kudyk.Lab4;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * Class <code>EquationsApp</code> implements driver for Equations class
 * and demonstrates exception handling in Java.
 * @author Kudyk
 * @version 1.0
 */
public class EquationsApp {

    /**
     * Main method that drives the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            out.print("Enter output file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();

            PrintWriter fout = new PrintWriter(new File(fName));

            try {
                try {
                    Equations eq = new Equations();

                    out.print("Enter X (in degrees): ");
                    int x = in.nextInt();

                    double result = eq.calculate(x);

                    fout.println("For x = " + x);
                    fout.println("Result: y = " + result);

                    out.println("Result successfully written to file.");
                } finally {
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {
                out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            out.println("Exception reason: Incorrect file path!");
        }
    }
}
