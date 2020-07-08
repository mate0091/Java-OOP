import java.math.BigInteger;
/**
 * Write a description of class StringCodes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringCodes
{
    public static String CHARACTERS = " ,.:;?!/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final BigInteger VAL_63 = new BigInteger("63"); // 63 is an unused coding, i.e characters has to be at most 63 in length
    /**
     * Encodes a String in a BigInteger
     * 
     * @param  s   String to encode
     * @return     the code for the string given as an argument  
     */
    public static BigInteger encode(String s)
    {
        if (s == null) return new BigInteger("-1"); // signal bad arg; replace with exception later
        if (s.length() == 0) return new BigInteger("-2"); // signal bad arg; replace with exception later
        
        BigInteger code = VAL_63; 
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int codeIndex = getCode(c);
            if (codeIndex < 0) return new BigInteger("-3");
            code = code.shiftLeft(6).add(new BigInteger(Integer.toString(codeIndex)));
        }
        return code;
    }
    /**
     * Decodes a BigInteger into a String
     * 
     * @param code what to decode
     * @return decoded value
     */
    public static String decode(BigInteger code)
    {
        String s = "";
        while (code.compareTo(VAL_63) != 0)
        {
            char c = getChar(code.and(VAL_63).intValue());
            s = c + s;
            code = code.shiftRight(6);
        }
        return s;
    }
    private static int getCode(char c)
    {
        return CHARACTERS.indexOf(c);
    }
    private static char getChar(int index)
    {
        return CHARACTERS.charAt(index);
    }
        
}
