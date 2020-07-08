public class Fraction implements Comparable {
    private int numerator;
    private int denominator;

    /**
     * Constructor for Fraction
     * creates a unitary fraction
     */
    public Fraction()
    {
        denominator = numerator = 1;
    }

    /**
     * Constructor for Fractionm
     * @param n - numerator, integer
     * @param m - denominator, integer
     * By convention, the sign is kept with the numerator; 
     * thus, negative deniminators are not legal 
     */
    public Fraction(int n, int d) 
    {
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
     * Copy constructor for Fraction
     * Creates a duplicate of the fraction givenas an argument
     * @param f - Fraction to duplicate
     */
    public Fraction( Fraction f)
    {
        numerator = f.numerator;
        denominator = f.denominator;
    }
    /**
     * Adds this fraction with the one given as an argument
     * and accumulates the result in this fraction
     * @param f - fraction to add with
     */
    public void add(Fraction f) 
    {
        int lcm = getLCM(denominator, f.denominator);
        numerator *= lcm / denominator;
        int fNumerator = f.numerator * lcm / f.denominator;
        numerator += fNumerator;
        denominator = lcm;
        simplify();
    }
    /**
     * Subtracts from this fraction the one given as an argument
     * and accumulates the result in this fraction
     * @param f - fraction to subtract from this one
     */
    public void subtract(Fraction f) 
    {
        int lcm = getLCM(denominator, f.denominator);
        numerator *= lcm / denominator;
        int fNumerator = f.numerator * lcm / f.denominator;
        numerator -= fNumerator;
        denominator = lcm;
        simplify();
    }
    /**
     * Multiplies this fraction by the one given as an argument
     * and accumulates the result in this fraction
     * @param f - fraction to multiply with
     */
    public void multiply(Fraction f) 
    {
        denominator *= f.denominator;
        numerator *= f.numerator;
        simplify();
    }
    /**
     * Divides this fraction through the one given as an argument
     * and accumulates the result in this fraction
     * @param f - fraction to divide to
     */
    public void divide(Fraction f) 
    {
        // find the sign of the result
        int sign = 
        (Integer.signum(denominator) == Integer.signum(f.denominator))? 1: -1;
        denominator = Math.abs(denominator * f.numerator);
        numerator *= Math.abs(f.denominator) * sign;
        simplify();
    }
    /**
     * Simplifies this fraction
     */
    public void simplify() 
    {
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
     * @return a double approx. equal to this fraction
     */
    public double toDouble() 
    {
       return (double)numerator / (double)denominator;
    }
    /**
     * Checks wether this fraction is equal to another
     * @param fraction to check if equal with
     * @return true if equal; false otherwise
     */
    public boolean equals(Fraction f) 
    {
        return compareTo(f) == 0;
    }
    public int getNumerator() 
    {
        return numerator;
    }
    public int getDenominator() 
    {
        return denominator;
    }
    /**
     * @retruns a String representation of this fraction
     */
    public String toString() 
    {
        return numerator + "/" + denominator;
    }
    /**
     * Compares this fraction to the one given as an argument
     * @param o - fraction to compare to
     * @return 1 if this is greater; 0 if equal; -1 if less
     */
    public int compareTo(Object o) 
    {
        Fraction f = (Fraction) o;
        
        int lcm = getLCM(f.denominator, denominator);
        int a = numerator * (lcm / denominator);
        int b = f.numerator * (lcm / f.denominator);
        
        if ( a > b ) return 1;
        if (a == b) return 0;
        return -1;
    }
    /**
     * Simplifies the fraction given as an argument and returns it
     * Does not change original fraction
     * @param f - fraction to simplify
     * @return reference to simplified fraction
     */
    public static Fraction simplify(Fraction f) 
    {
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
     * Greatest common divisor of two integers a and b
     */
    private static int getGCD(int a, int b) 
    {
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
    private static int getLCM(int a, int b) 
    {
       if (a < 0) a = -1;
       if (b < 0) b = -b;
       return a * b / getGCD(a, b); 
    }
}
