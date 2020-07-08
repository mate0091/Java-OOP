
/**
 * IntNumber is a wrapper for class Integer to implement interface Numeric
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntNumber implements Numeric {
   private int value;
   /**
    * Constructor for objects of class IntNumber
    */
   public IntNumber (int intVal) {
      value = intVal;
       }
   
   public String toString() {
      return Integer.toString(value);
       }
   
   /**
    * Returns an object reopresenting the zero value for the type
    */
   public Numeric getZero() {
      return new IntNumber(0);
       }
   
   /**
    * Returns a copy of the object implementing numeric
    */
   public Numeric copy() {
      return new IntNumber(value);
       }
   
   /**
    * Adds two numeric objects and returns a new object holding the sum
    *      * 
    *      * @param  term   Numeric object add with
    *      * @return        result of this + term
    */
   public Numeric add(Numeric term) {
      int val = value + ((IntNumber)term).value;
           return new IntNumber(val);
       }
   
   /**
    * Subtracts two numeric objects and returns a new object holding the difference
    *      * 
    *      * @param  term   term to subtract from this Numeric object
    */
   public Numeric subtract(Numeric term) {
      int val = value - ((IntNumber)term).value;
           return new IntNumber(val);
       }
   
   /**
    * Multiplies two numeric objects and returns a new object holding the product
    *      * 
    *      * @param  multiplier Numeric object to multiply with
    */
   public Numeric multiply(Numeric multiplier) {
      int val = value * ((IntNumber)multiplier).value;
           return new IntNumber(val);
       }
   
   /**
    * Divides two numeric objects and returns a new object holding the quotient
    *      * 
    *      * @param  divisor Numeric object to divide to
    *      * @return        result of this / divisor
    */
   public Numeric divide(Numeric divisor) {
      int val = value / ((IntNumber)divisor).value;
           return new IntNumber(val);
       }
   
   /**
    * Returns an object representing the zero value for the type
    */
   public int compareTo(Object val) {
      return value - ((IntNumber) val).value;
       }
   
   }
