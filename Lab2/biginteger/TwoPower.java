import java.lang.*;
import java.io.*;
import java.math.*;
/**
 * 2. The legend says that the inventor of the game of chess asked a number of wheat grains: a double
 *  amount for each of the 64 squares of the board (i.e.1 for the first square, 2 for the second, 4 for the
 *  third, 2i-1
 *  for the ith. Hint: use BigInteger class. 
 */
public class TwoPower
{
    public static void Main()
    {
        //calculate 2^64
        
        BigInteger value = new BigInteger("2");
        //System.out.println(value.toString());
        value = value.pow(64);
        //System.out.println(value.toString());
        
        byte value2 = Byte.MIN_VALUE;
        System.out.println(value2);
        value2 = value2 + ;
        System.out.println(value2);
    }
}
