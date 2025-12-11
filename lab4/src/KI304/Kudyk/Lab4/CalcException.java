package KI304.Kudyk.Lab4;

/**
 * Class <code>CalcException</code> specifies user-defined
 * arithmetic errors for equation calculation.
 * @author Kudyk
 * @version 1.0
 */
public class CalcException extends ArithmeticException {

    /** Default constructor */
    public CalcException() {}

    /**
     * Constructor with custom message
     * @param cause description of the error
     */
    public CalcException(String cause) {
        super(cause);
    }
}
