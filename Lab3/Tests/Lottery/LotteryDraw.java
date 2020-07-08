import java.util.Random;

/**
 * LotteryDraw is used for simulation lottery draws
 * 
 * @author Marius Joldos
 * @version 2009.10.15
 */
public class LotteryDraw
{
	/**
	 * invariant: the highest value which can be drawn
	 * for any LotteryDraw object
	 */
	public static final int VAL_MAX = Long.SIZE;
	/**
	 * invariant: value used to divide the maximum drawable number
	 * to set a limit on the maximum numbers to be drawn
	 */
	public static final int QUOTA_NUMBERS_DRAWN = 8;
	private static Random generator = new Random(); // random number generator used for the draw
	private int valMax = 49; // maximum value to draw
	private int nbOfNumbers = 6; // maximum number of draws
	private long numbersDrawn = 0L; // bitset representation of the drawn numbers


	/**
	 * Constructor for  LotteryDraw objects
	 * Defaults to a 6 out of 49 lottery
	 */
	public LotteryDraw()
	{
		this(6, 49);
	}
	/**
	 * Constructor Constructor for  LotteryDraw objects
	 * @param n how many numbers to draw
	 * @param m biggest drawable number
	*/
	public LotteryDraw(int n, int m)
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
			System.err.println("Illegal arguments. Maximum allowed value given="
							+ m + " number of numbers per draw=" + n);
	}
	

	private void drawOneNumber()
	{
		numbersDrawn |= (1L << generator.nextInt(valMax));
	}
	/**
	 * Executes a draw
	 */
	public void draw()
	{
		if (Long.bitCount(numbersDrawn) >= nbOfNumbers)
			return;
		do
			drawOneNumber();
		while (Long.bitCount(numbersDrawn) < nbOfNumbers);
	}
	/**
	 * Returns a String representation of this LotteryDraw object
	 */
	public String toString()
	{
		String s = "LotteryDraw " + nbOfNumbers + " of " + valMax
				+ ".\nNumbers drawn: ";
		for (int i = 0; i < valMax; i++)
			if ((numbersDrawn & (1L << i)) != 0)
				s += (i + 1) + " ";
		return s;
	}
	/**
	 * Prints info on this lottery
	 */
	public void list()
	{
		System.out.println(this);
	}
	/**
	 * Check to see which numbers on the given ticket match the draw
	 * Writes to System.out the matching ones
	 * @param b a LotteryTicket object to check against this draw
	 */
	public void checkWins(LotteryTicket b)
	{
		int n = 0;
		int[] numbers = b.whatNumbers();
        if (numbers.length != nbOfNumbers)
        {
            System.out.println("Ticket is not for this kind of lottery draw ("
            + nbOfNumbers + "!=" + numbers.length + ")");
            return;
        }
		System.out.print("Numbers which match draw are: ");
		for (int i = 0; i < numbers.length; i++)
		{
			if ((numbersDrawn & (1L << (numbers[i] - 1))) != 0L)
			{
				System.out.print(numbers[i] + " ");
				n++;
			}
		}
		if (n == 0)
			System.out.println(" none");
	}
}
