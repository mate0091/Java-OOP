import java.lang.*;

public class Matrix
{
    // instance variables - replace the example below with your own
    private int[][] data;

    /**
     * Constructor for objects of class Matrix
     */
    public Matrix(int rows, int columns)
    {
        // initialise instance variables
        data = new int[rows][columns];
    }
    
    public void setElement(int r, int c, int x)
    {
        data[r][c] = x;
    }
    
    public Matrix multiply(Matrix b)
    {
        Matrix result = new Matrix(data.length, b.data[0].length);
        
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < b.data[0].length; j++)
            {
                int sum = 0;
                
                for(int k = 0; k < data[0].length; k++)
                {
                    sum += this.data[i][k] * b.data[k][j]; 
                }
                
                result.data[i][j] = sum;
            }
        }
        
        return result;
    }
    
    public Matrix multiplyValue(int value)
    {
        Matrix result = new Matrix(data.length, data[0].length);
        
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data[0].length; j++)
            {
                result.data[i][j] *= value;
            }
        }
        
        return result;
    }
    
    public String print()
    {
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data[0].length; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    pu
}
