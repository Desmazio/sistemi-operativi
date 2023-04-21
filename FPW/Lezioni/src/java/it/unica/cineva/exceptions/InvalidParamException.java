package it.unica.cineva.exceptions;

/**
 *
 * @author paual
 */
public class InvalidParamException extends Exception{
    public InvalidParamException(String errorMessage){
        super(errorMessage);
    }
}
