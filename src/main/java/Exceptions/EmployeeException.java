package Exceptions;



public class EmployeeException extends AssertionError {

    public static final String MESSAGE = "La información  no corresponde a la esperada";

    public EmployeeException(String msg, Throwable cause){
        super(msg,cause);
    }
}
