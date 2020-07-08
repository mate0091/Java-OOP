import java.math.BigInteger;
/**
 * Write a description of class TestStringCodes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestStringCodes
{
    // instance variables - replace the example below with your own
    public static void main(String args[])
    {
        String s1 = "Test String";
        BigInteger encoded = StringCodes.encode(s1);
        System.out.println("Encoded " + s1 + " = " + encoded); 
        String decoded = StringCodes.decode(encoded);
        System.out.println("Decoded " + s1 + " = " + decoded);
    }
}
