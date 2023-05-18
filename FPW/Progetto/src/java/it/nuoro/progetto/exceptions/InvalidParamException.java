package it.nuoro.progetto.exceptions;

/**
 *
 * @author paual
 */
public class InvalidParamException extends Exception{
    public InvalidParamException(String errorMessage){
        super(errorMessage);
    }
}
