package it.unica.cineva.utils;

import java.util.Calendar;
import java.util.TimeZone;

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
    
    public static String convertTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        
        return(cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" +
                cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY)+ ":" + 
                cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
    }
    
}
