import java.util.Random;
/**
 * Write a description of class Useful here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Provided
{
    private static String[] classIds = new String[60];
    private static int classIdsIndex = -1;
    private static String vowels="aeiouy";
    private static String consonants="bcdfghjklmnpqrstvwxz";
    // instance variables - replace the example below with your own
    private static Random gen=new Random();
    /**
     * Generate person info
     * @return an array of String of size 3 with SSN (13 digit unique number), (dummy) name, 
     * and birth date (4-digit year, 2-digit month, 2 digit day) in order
     */
    public static final String[] generatePersonInfo()
    {
        String[] result = new String[3];
        // SSN
        result[2] = Integer.toString((1900 + gen.nextInt(116))*10000+(gen.nextInt(12)+1)*100+1+gen.nextInt(29));
        result[0] = generateSSN(result[2]);
        result[1] = generateText(35);
      
        return result;
    }
    /**
     * Generate info for a classroom
     * @return an array of String of size 2 with identification (at 0) and number of desks (at 1)
     */
    public static final String[] generateClassRoomInfo(char wing, int floor)
    {
        String[] result = new String[2];
        result[1] = Integer.toString(20 + gen.nextInt(7));
        boolean haveIt;
        do
        {
            haveIt = false;
            result[0] = genClassroomInfo(wing, floor);
            for (int i=0; i < classIdsIndex && !haveIt; i++)
                if (result[0].equals(classIds[i])) haveIt = true;
        }
        while(haveIt);
        if (++classIdsIndex < 60)
        {
            classIds[classIdsIndex] = result[0];
        }
        return result;
    }
    private static final String generateSSN(String birthDate)
    {
        return Integer.toString(gen.nextInt() % 2 + 
            ((Integer.parseInt(birthDate.substring(0,4)) < 2000)?
            1: 4)) + birthDate.substring(2,8) + 
            Integer.toString(100000 + gen.nextInt(899999));
    }

    private static final String generateText(int len)
    {
        int spacesIndex[] = new int[1 + gen.nextInt(3)];
        spacesIndex[0] = 4 + gen.nextInt(len/3);
        for (int i = 1; i < spacesIndex.length; i++)
            spacesIndex[i] = spacesIndex[i-1] + gen.nextInt(len - 5);
        StringBuffer text = new StringBuffer(len);
        char c =((gen.nextInt()%2 == 1)? vowels.charAt(gen.nextInt(vowels.length())):
            consonants.charAt(gen.nextInt(consonants.length())));
        text.append(Character.toUpperCase(c));
        loop:
        for (int i=1; i < len; i++)
        {
            boolean capitalize = false;
            for (int j=0; j < spacesIndex.length; j++)
            {
                if (i == spacesIndex[j])
                {
                    text.append(' ');
                    continue loop;
                }
                if (i - 1 == spacesIndex[j])
                    capitalize = true;
                if (i > j)
                    break;
            }
            text.append((gen.nextInt()%2 == 1)? vowels.charAt(gen.nextInt(vowels.length())):
                consonants.charAt(gen.nextInt(consonants.length())));        
            if (capitalize)
            {
                c = text.charAt(i);
                text.setCharAt(i, Character.toUpperCase(c));
            }
        }
        return text.toString();
    }
    private static final String genClassroomInfo(char wing, int floor)
    {
        StringBuffer aux = new StringBuffer(6);
        aux.append(wing);
        aux.append(Integer.toString(floor));
        aux.append('-');
        aux.append(Integer.toString(1 + gen.nextInt(10)));
        aux.append((char)('A' + gen.nextInt(10)));
        return aux.toString();
    }
}
