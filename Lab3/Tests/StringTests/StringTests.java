
/**
 * Write a description of class StringTests here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringTests
{
    public static void main(String[] args)
    {
        String mango = "mango";
        String mango2 = "mango";
        String mango3 = new String("mango");
        System.out.println("Strings defined:");
        System.out.println("String mango = \"mango\"");
        System.out.println("String mango2 = \"mango\"");
        System.out.println("String mango3 = new String(\"mango\")");
        System.out.println("Now, a number of operations:");
        System.out.println("mango != mango2: " + (mango != mango2));
        System.out.println("mango == mango2: " + (mango == mango2));
        System.out.println("mango3 != mango2: " + (mango3 != mango2));
        System.out.println("mango3 == mango2: " + (mango3 == mango2));
        System.out.println("mango+\" \"+ mango2: " + "\"" + mango+" "+ mango2+"\"");
        System.out.println("mango != mango2: " + (mango != mango2));
        System.out.println("mango == mango2: " + (mango == mango2));
        System.out.println("System.identityHashCode(mango): " +
            System.identityHashCode(mango));
        System.out.println("System.identityHashCode(mango2): " +
            System.identityHashCode(mango2));
        System.out.println("System.identityHashCode(mango3)" + 
            System.identityHashCode(mango3));
    }
}