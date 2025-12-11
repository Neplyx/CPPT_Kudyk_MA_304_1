package KI304.Kudyk.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Class <code>CalcWFio</code> implements methods for calculating
 * expression y = ctg(x) / tg(x) and provides functionality for
 * saving and reading results in text and binary formats.
 *
 * @author Kudyk
 * @version 1.0
 */
public class CalcWFio {

    /** Variable to store the result of calculation */
    private double result;

    /**
 * Calculates expression y = ctg(x) / tg(x)
 * @param x angle in degrees
 * @throws ArithmeticException if tg(x) = 0 or undefined
 */
public void calculate(double x) {
    double rad = x * Math.PI / 180.0;
    double tan = Math.tan(rad);

    if (Math.abs(tan) < 1e-12 || Math.abs(tan) > 1e12) {
        throw new ArithmeticException("Помилка: tg(" + x + ") недопустиме значення (" + tan + ")");
    }

    double ctg = 1.0 / tan;
    result = ctg / tan;
}

    /**
     * Returns the last calculated result
     * @return result value
     */
    public double getResult() {
        return result;
    }

    /**
     * Writes result to a text file
     * @param fName file name
     * @throws FileNotFoundException if file cannot be created
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%g", result);
        f.close();
    }

    /**
     * Reads result from a text file
     * @param fName file name
     * @throws FileNotFoundException if file not found
     */
    public void readResTxt(String fName) throws FileNotFoundException {
        File f = new File(fName);
        if (!f.exists())
            throw new FileNotFoundException("File " + fName + " not found");
        Scanner s = new Scanner(f);
        result = s.nextDouble();
        s.close();
    }

    /**
     * Writes result to a binary file
     * @param fName file name
     * @throws IOException if writing error occurs
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads result from a binary file
     * @param fName file name
     * @throws IOException if reading error occurs
     */
    public void readResBin(String fName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
}
