import java.math.BigInteger;

/**
 * BigIntNumber is a wrapper for BigIntegers to implement interface Numeric.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigIntNumber implements Numeric {
   private BigInteger value;
   /**
    * Constructor for objects of class BigIntNumber
    */
   public BigIntNumber (String s) {
      value = new BigInteger(s);
       }
   
   public String toString() {
      return value.toString();
       }
   
   /**
    * Returns an object reopresenting thge zero value for the type
    */
   public Numeric getZero() {
      return new BigIntNumber("0");
       }
   
   /**
    * Returns a copy of the object implementing numeric
    */
   public Numeric copy() {
      return new BigIntNumber(value.toString());
       }
   
   /**
    * Adds two numeric objects and returns a new object holding the sum
    *      * 
    *      * @param  term   Numeric object add with
    *      * @return        sum
    */
   public Numeric add(Numeric term) {
      return new BigIntNumber(value.add(((BigIntNumber)term).value));
       }
   
   /**
    * Subtracts two numeric objects and returns a new object holding the difference
    *      * 
    *      * @param  term   term to subtract from this Numeric object
    *      * @return difference
    */
   public Numeric subtract(Numeric term) {
      return new BigIntNumber(value.subtract(((BigIntNumber)term).value));
       }
   
   /**
    * Multiplies two numeric objects and returns a new object holding the product
    *      * 
    *      * @param  multiplier Numeric object to multiply with
    *      * return product
    */
   public Numeric multiply(Numeric multiplier) {
      return new BigIntNumber(value.multiply(((BigIntNumber)multiplier).value));
       }
   
   /**
    * Divides two numeric objects and returns a new object holding the quotient
    *      * 
    *      * @param  divisor Numeric object to divide to
    *      * @return quotient
    */
   public Numeric divide(Numeric divisor) {
      return new BigIntNumber(value.divide(((BigIntNumber)divisor).value));
       }
   
   /**
    * Constructor for objects of class BigIntNumber
    */
   public BigIntNumber (BigInteger b) {
      value = b;
       }
   
   /**
    * Returns an object representing the zero value for the type
    */
   public int compareTo(Object val) {
      return value.compareTo(((BigIntNumber)val).value);
       }
   
   }
