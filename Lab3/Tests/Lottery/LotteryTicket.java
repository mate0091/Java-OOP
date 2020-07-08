import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Simulates a lottery ticket
 * 
 * @author Marius Joldos
 * @version 2009.10.16
 */
public class LotteryTicket
{
    /**
     * invariant: the highest number which can be written
     * on any lottery ticket
     */
    public static final int VAL_MAX = Long.SIZE;
    /**
     * invariant: the quota of numbers which can be drawn, i.e.
     * the value used to divide the set size inorder to get how many
     * numbers one can draw
     */
    public static final int QUOTA_NUMBERS_DRAWN = 8;
    private long numbersOnTicket; // bit reprezentation of the set o numbers written on this ticket
    private int valMax = 49; // value of highest drawn number
    private int nbOfNumbers = 6; // how many numbers are allowed on a ticket

    /**
     * Constructor for objects of class LotteryTicket
     * @param n how many numbers one can write on a ticket
     * @param m highest value which can be written on a ticket
     */
    public LotteryTicket(int n, int m)
    {
        boolean ok = false;
        if (m >= 1 && m <= VAL_MAX && m / QUOTA_NUMBERS_DRAWN >= 1)
        {
            if (n >= 1 && n <= m / QUOTA_NUMBERS_DRAWN)
            {
                nbOfNumbers = n;
                valMax = m;
                ok = true;
            }
        }
        if (!ok)
            System.err.println("Illegal arguments. Maximum allowed value given=" + m + " number of numbers allowed on ticket=" + n);

    }
    /**
     * Returns a String with the numbers on this lotto ticket
     */
    public String toString()
    {
        String s = "Lottery ticket for " + nbOfNumbers + " out of " + valMax
                + ".\nNumbers written: ";
        for (int i = 0; i < valMax; i++)
            if ((numbersOnTicket & (1L << i)) != 0)
                s += (i + 1) + " ";
        return s;
    }
    /**
     * Prints to System.out the contents of this ticket
     */
    public void list()
    {
        System.out.println(this);
    }
    /**
     * Accepts numbers to write on this tiicket from System.in
     * and writes them on the ticket
     */
    public void readNumbers()
    {
        if (Long.bitCount(numbersOnTicket) >= nbOfNumbers)
        {
            System.out.println("Already used ticket: " + this);
            return;
        }
        System.out.print("Your numbers for lottery " + nbOfNumbers
                + " of " + valMax + ": ");
        Scanner sc = new Scanner(System.in);
        int currentNumber = -1;
        boolean ok = true;
        String s;
        do
        {
            if (sc.hasNext("\\d+"))
            {
                s = sc.next("\\d+");
                System.err.print(s + " ");
                int val = Integer.parseInt(s);
                if (val >= 1 && val <= valMax)
                {
                    numbersOnTicket |= (1L << (val - 1));
                    System.out
                            .println("Number accepted: "
                                    + val
                                    + ((nbOfNumbers - Long.bitCount(numbersOnTicket) > 0) ? (". Need to get "
                                            + (nbOfNumbers - Long.bitCount(numbersOnTicket)) + " more numbers")
                                            : (". Set of numbers complete")));
                }
                else
                    System.out.println("Invalid number:" + val);
            }
            else
            {
                if (sc.hasNext("\\D+"))
                {
                    s = sc.next("\\D+");
                    System.out.print(s + " ignored\n");
                }
                else
                    if (sc.hasNext("(\\d+\\D*)+|(\\D+\\d*)+"))
                    {
                        s = sc.next("(\\d+\\D*)+|(\\D+\\d*)+");
                        System.out.print(s + " ignored\n");
                    }

            }
        }
        while (Long.bitCount(numbersOnTicket) < nbOfNumbers);
    }
    /** 
     * returns an array of numbers written on this ticket
     * @return array of ints with the numbers on this ticket
     */
    public int[] whatNumbers()
    {
        int[] numbers = new int[nbOfNumbers];
        for (int i = 0, j = 0; i < valMax; i++)
        {
            if ((numbersOnTicket & (1L << i)) != 0)
                numbers[j++] = i + 1;
        }
        return numbers;
    }
    /**
     * Autofills a ticket with random numbers
     */
    public void autofill()
    {
        Random gen = new Random(new Date().getTime());
        if (Long.bitCount(numbersOnTicket) < nbOfNumbers)
        do
        {
            numbersOnTicket |= (1L << gen.nextInt(valMax));
        }
        while (Long.bitCount(numbersOnTicket) < nbOfNumbers);   
    }
}
