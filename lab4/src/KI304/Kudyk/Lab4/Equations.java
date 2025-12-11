package KI304.Kudyk.Lab4;

/**
 * Class <code>Equations</code> implements a method for
 * calculating the expression y = ctg(x) / tg(x).
 * @author Kudyk
 * @version 1.0
 */
public class Equations {

    /**
     * Method that calculates y = ctg(x) / tg(x)
     * @param x angle in degrees
     * @return result of the expression
     * @throws CalcException if x leads to invalid tangent or cotangent
     */
    public double calculate(int x) throws CalcException {
        double rad = x * Math.PI / 180.0;
        double y;

        try {
            double tan = Math.tan(rad);
            double ctg = 1.0 / tan;

            y = ctg / tan;
            
            if (x == 45) {
            throw new ArithmeticException("Штучно спровокована помилка.");
        }
        
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }

        } catch (ArithmeticException ex) {
            if (x % 180 == 90) {
                throw new CalcException("Exception reason: X = " + x + 
                    " (tangent undefined)");
            } else if (x % 180 == 0) {
                throw new CalcException("Exception reason: X = " + x + 
                    " (cotangent undefined)");
            } else {
                throw new CalcException("Unknown exception reason during calculation.");
            }
        }

        return y;
    }
}
