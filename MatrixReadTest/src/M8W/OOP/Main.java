package M8W.OOP;

import java.io.File;
import java.util.Scanner;

public class Main
{
    private static char[][] readMatrix(String filepath)
    {
        char[][] data;

        int row, column;

        try{
            Scanner in = new Scanner(new File(filepath));
            row = in.nextInt();
            column = in.nextInt();

            data = new char[row][column];

            in.nextLine();

            for(int i = 0; i < row; i++)
            {
                data[i] = in.nextLine().toCharArray();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            data = null;
        }

        return data;
    }

    private static void writeMatrix(char[][] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
                System.out.print(data[i][j] + " ");
            }

            System.out.printf("\n");
        }
    }

    public static void main(String[] args)
    {
        char data[][] = readMatrix("Data.txt");

        Scanner enterscan = new Scanner(System.in);

        while(true)
        {
            writeMatrix(data);
            System.out.println();
            String s = enterscan.nextLine();

            if(s.compareTo("e") == 0){
                break;
            }
        }
    }
}
