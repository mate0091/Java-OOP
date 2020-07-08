
public class Matrix {
    private Fraction[][] matrix;
    /**
     * Constructor for Matrix
     * @param rows number of rows in the matrix
     * @param cols number of cols in the matrix
     * pre rows > 0 and cols > 0
     * post a bidimensional array of references to fractions is allcated and assigned to elem
     */
    public Matrix(int rows, int cols) 
    {
        matrix = new Fraction[rows][cols];
    }
    /**
     * Adds this Matrix with the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to add with this
     */
    public void add(Matrix m) 
    {
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
            matrix[r][c].add(m.matrix[r][c]);
    }
    /**
     * Subtracts from this Matrix the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to subtract from this
     */
    public void subtract(Matrix m) 
    {
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
            matrix[r][c].subtract(m.matrix[r][c]);
    }
    /**
     * Multiplies this Matrix by a Fraction given as an argument
     * accumulates the result in this one
     * @param f - Fraction to multiply by 
     */
    public void multiply(Fraction f) 
    {
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
            matrix[r][c].multiply(f);
    }
    /**
     * Multiplies this Matrix by the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to multiply by 
     */
    public Matrix multiply(Matrix m) 
    {
       Matrix result = new Matrix(matrix.length, m.matrix[0].length);
       
       for( int i = 0; i < matrix.length; i++ )
          for( int j = 0; j < result.matrix[0].length; j++ )
          {
              Fraction c = new Fraction(0, 1);
              for( int k = 0; k < matrix[0].length; k++ )
              {
                  Fraction f = new Fraction(matrix[ i ][ k ]);
                  f.multiply(m.matrix[ k ][ j ]);
                  c.add( f );
              }
              result.matrix[ i ][ j ] = c;
           }
        return result;
    }
    /**
     * Divides this Matrix through a Fraction given as an argument
     * accumulates the result in this one
     * @param f - Fraction to divide thorugh 
     */
    public void divide(Fraction f) 
    {
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
            matrix[r][c].divide(f);
    }
    /**
     * Transposes this matrix
     */
    public void transpose() 
    {
       Fraction[][] t = new Fraction[matrix[0].length][matrix.length];
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
            t[c][r] = matrix[r][c];
       matrix = t;
    }
    /**
     * Matrix reciprocal. Not implemented
     */
    public void inverse() 
    {
       System.err.println("Matrix inverse not implemented");
    }
    /**
     * Checks iof this matrix is equal to another
     * @param m - matrix to check if equal with this
     * @return true if equal; false otherwise
     */
    public boolean equals(Matrix m) 
    {
       for (int r = 0; r < matrix.length; r++)
          for (int c = 0; c < matrix[r].length; c++)
             if (matrix[r][c].compareTo(m.matrix[r][c]) != 0) return false;
       return true;
    }
    /**
     * Sets an element of a matrix to the given fraction
     * @param row - row coordinate in the matrix
     * @param col - column coordinate in the matrix
     * @param val - fraction to store (argument is duplicated)
     * Note that row and col range from 0
     */
    public void setElem(int row, int col, Fraction val) 
    {
        matrix[row][col] = new Fraction( val );
    }
    /**
     * Returns a String representation of this matrix
     * @return matrix as a String
     */
    public String toString() 
    {
       String s = "";
       for (int r = 0; r < matrix.length; r++)
       {
          for (int c = 0; c < matrix[r].length; c++)
            s = s + matrix[r][c].toString() + "\t";
          s = s + "\n";
       }
       return s;
    }
    /**
     * For test purposes only
     */
    public static void main(String[] args)
    {
        Matrix m = new Matrix(3, 3);
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
               m.setElem(r, c, new Fraction(r + 1, c + 1));
        System.out.println(m);
        Matrix m1 = new Matrix(3, 3);
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
               m1.setElem(r, c, new Fraction(10*r + 1, 10*c + 1));
        System.out.println(m1);
        m1.subtract(m);
        System.out.println(m1);
        Matrix m2 = new Matrix(3, 2);
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 2; c++)
               m2.setElem(r, c, new Fraction(r + 1, c + 1));
        System.out.println(m2);
        m2.transpose();
        System.out.println(m2);
    }
}
