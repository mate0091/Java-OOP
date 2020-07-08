
public class Fraction implements Numeric {
   private int numerator;
   
   public int getNumerator() {
      return this.numerator;
   }
   
   private int denominator;
   
   public int getDenominator() {
      return this.denominator;
   }
   
   /**
    * Constructor for Fraction
    *      * creates a unitary fraction
    */
   public Fraction () {
      denominator = numerator = 1;
       }
   
   /**
    * Constructor for Fractionm
    *      * @param n - numerator, integer
    *      * @param m - denominator, integer
    *      * By convention, the sign is kept with the numerator; 
    *      * thus, negative deniminators are not legal
    */
   public Fraction (int n, int d) {
      numerator = n;
          if ( d > 0 )
          {
              denominator = d;
           }
           else
           {
               System.out.println("Illegal denominator (<=0): " + d);
               denominator = 1;
           }
       }
   
   /**
    * Simplifies this fraction
    */
   public void simplify() {
      int gcd = getGCD( numerator, denominator);
           
           if (gcd > 1)
           {
               numerator /= gcd;
               denominator /= gcd;
           }
       }
   
   /**
    * Swaps numerator with denominator; thus inverts fraction
    */
   public void swap() {
      int t = numerator;
           denominator = numerator;
           numerator = t;
       }
   
   /**
    * Returns the real equivalent of this fraction
    *      * @return a double approx. equal to this fraction
    */
   public double toDouble() {
      return (double)numerator / (double)denominator;
       }
   
   /**
    * @retruns a String representation of this fraction
    */
   public String toString() {
      return numerator + "/" + denominator;
       }
   
   public Numeric copy() {
      return new Fraction(this);
        }
   
   public Fraction getZero() {
      return new Fraction(0, 1);
           }
   
   /**
    * Greatest common divisor of two integers a and b
    */
   private static int getGCD(int a, int b) {
      int t;
          if (a < 0) a = -1;
          if (b < 0) b = -b;
          while ( b != 0 )
          {
              t = b;
              b = a % b;
              a = t;
           }
          return a;
       }
   
   /**
    * Least common multiple of two integers a and b
    */
   private static int getLCM(int a, int b) {
      if (a < 0) a = -1;
          if (b < 0) b = -b;
          return a * b / getGCD(a, b); 
       }
   
   /**
    * Copy constructor for Fraction
    *      * Creates a duplicate of the fraction givenas an argument
    *      * @param f - Fraction to duplicate
    */
   public Fraction (Fraction f) {
      numerator = f.numerator;
           denominator = f.denominator;
       }
   
   /**
    * Adds this fraction with the one given as an argument
    *      * and accumulates the result in this fraction
    *      * @param f - fraction to add with
    */
   public Numeric add(Numeric f) {
      Fraction result = new Fraction(this);
           int lcm = getLCM(denominator, ((Fraction)f).denominator);
           result.numerator *= lcm / denominator;
           int fNumerator = ((Fraction)f).numerator * lcm / ((Fraction)f).denominator;
           result.numerator += fNumerator;
           result.denominator = lcm;
           result.simplify();
           return result;
       }
   
   /**
    * Subtracts from this fraction the one given as an argument
    *      * and accumulates the result in this fraction
    *      * @param f - fraction to subtract from this one
    */
   public Numeric subtract(Numeric f) {
      Fraction result = new Fraction(this);
           int lcm = getLCM(denominator, ((Fraction)f).denominator);
           result.numerator *= lcm / denominator;
           int fNumerator = ((Fraction)f).numerator * lcm / ((Fraction)f).denominator;
           result.numerator -= fNumerator;
           result.denominator = lcm;
           result.simplify();
           return result;
       }
   
   /**
    * Multiplies this fraction by the one given as an argument
    *      * and accumulates the result in this fraction
    *      * @param f - fraction to multiply with
    */
   public Numeric multiply(Numeric f) {
      Fraction result = new Fraction(this);
           result.denominator *= ((Fraction)f).denominator;
           result.numerator *= ((Fraction)f).numerator;
           result.simplify();
           return result;
       }
   
   /**
    * Divides this fraction through the one given as an argument
    *      * and accumulates the result in this fraction
    *      * @param f - fraction to divide to
    */
   public Numeric divide(Numeric f) {
      // find the sign of the result
           int sign = 
           (Integer.signum(denominator) == Integer.signum(((Fraction)f).denominator))? 1: -1;
           Fraction result = new Fraction(this);
           result.denominator = Math.abs(denominator * ((Fraction)f).numerator);
           result.numerator *= Math.abs(((Fraction)f).denominator) * sign;
           result.simplify();
           return result;
       }
   
   /**
    * Checks wether this fraction is equal to another
    *      * @param fraction to check if equal with
    *      * @return true if equal; false otherwise
    */
   public boolean equals(Fraction f) {
      return compareTo(f) == 0;
       }
   
   /**
    * Simplifies the fraction given as an argument and returns it
    *      * Does not change original fraction
    *      * @param f - fraction to simplify
    *      * @return reference to simplified fraction
    */
   public static Fraction simplify(Fraction f) {
      Fraction nf = new Fraction();
           int gcd = getGCD( f.numerator, f.denominator);
           if (gcd > 1)
           {
               nf.numerator = f.numerator / gcd;
               nf.denominator = f.denominator / gcd;
           }
           return nf;
        }
   
   /**
    * Compares this fraction to the one given as an argument
    *      * @param o - fraction to compare to
    *      * @return 1 if this is greater; 0 if equal; -1 if less
    */
   public int compareTo(Object o) {
      Fraction f = (Fraction) o;
           
           int lcm = getLCM(f.denominator, denominator);
           int a = numerator * (lcm / denominator);
           int b = f.numerator * (lcm / f.denominator);
           
           if ( a > b ) return 1;
           if (a == b) return 0;
           return -1;
       }
   
   }
