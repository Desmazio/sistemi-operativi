package it.unica.cineva.utils;
import it.unica.cineva.exceptions.InvalidParamException;

/**
 *
 * @author paual
 */
public class Utils {
    
    public static void checkString(String param, int min, int max) throws InvalidParamException{
        if(param == null)
            throw new InvalidParamException("Parametro nullo");
        
        if(param.length() < min || param.length() > max)
            throw new InvalidParamException("La stringa " + param + " non è valida perché deve avere una dimensione compresa tra " + min + " e " + max + " caratteri");
    } 
    
    public static void checkInteger(String param, int min, int max) throws InvalidParamException{
        try{
            int value = Integer.valueOf(param);
            if(value < min || value > max)
                throw new InvalidParamException("Il valore " + param + " dev'essere compreso tra " + min + " e " + max);
        }
        catch(NumberFormatException e){
            throw new InvalidParamException("Il valore " + param + " non rappresenta un valore intero");
        }
    }
    
}
