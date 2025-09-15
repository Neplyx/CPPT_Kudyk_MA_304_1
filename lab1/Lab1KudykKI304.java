import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас Lab1KudykKI304 будує квадратну матрицю n×n,
 * де верхня половина заповнена символом лише справа,
 * нижня половина — лише зліва, а порожні клітини заповнені ' '.
 *
 * @author Kudyk
 * @version 1.1
 * @since 2025-09-15
 */
public class Lab1KudykKI304 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix: ");
        int n = in.nextInt();
        in.nextLine();

        System.out.print("Enter a placeholder character: ");
        String filler = in.nextLine();

        if (filler.length() != 1) {
            System.out.println(filler.length() == 0
                    ? "No placeholder character entered."
                    : "Too many placeholder characters entered.");
            return;
        }

        char symbol = filler.charAt(0);
        char empty = ' ';

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n / 2) {
                    matrix[i][j] = (j >= n / 2) ? symbol : empty;
                } else {
                    matrix[i][j] = (j < n / 2) ? symbol : empty;
                }
            }
        }

        File outFile = new File("Lab1Variant11.txt");
        PrintWriter fout = new PrintWriter(outFile);

        System.out.println("\nThe formed matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                fout.print(matrix[i][j]);
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
        System.out.println("\nThe result is saved to a file: " + outFile.getAbsolutePath());
    }
}
