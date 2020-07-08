
public class Matrix {
    String id;
    private Numeric[][] matrix;
    /**
     * Constructor for Matrix
     * @param rows number of rows in the matrix
     * @param cols number of cols in the matrix
     * pre rows > 0 and cols > 0
     * post a bidimensional array of references to fractions is allcated and assigned to elem
     */
    public Matrix(int rows, int cols, String id) 
    {
        matrix = new Numeric[rows][cols];
        this.id = id;
    }

    /**
     * Constructor for Matrix.
     * Creates a copy of the matrix given as its argument
     */
    public static Matrix copy(Matrix matrixToCopy)
    {
        Matrix result = new Matrix(matrixToCopy.matrix.length, matrixToCopy.matrix[0].length, matrixToCopy.id);
        for (int r = 0; r < matrixToCopy.matrix.length; r++)
            for (int c = 0; c < matrixToCopy.matrix[r].length; c++)
                result.setElem(r, c, matrixToCopy.matrix[r][c]);
        return result;
    }

    /**
     * Sets an element of a matrix to the given fraction
     * @param row - row coordinate in the matrix
     * @param col - column coordinate in the matrix
     * @param val - fraction to store (argument is duplicated)
     * Note that row and col range from 0
     */
    public void setElem(int row, int col, Numeric val) 
    {
        matrix[row][col] = val.copy();
    }

    /**
     * Adds this Matrix with the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to add with this
     */
    public Matrix add(Matrix m) 
    {
        Matrix result = Matrix.copy(this); 
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                result.matrix[r][c]=result.matrix[r][c].add(m.matrix[r][c]);
        result.id = this.id + " + " + m.id;
        return result;
    }

    /**
     * Subtracts from this Matrix the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to subtract from this
     */
    public Matrix subtract(Matrix m) 
    {
        Matrix result = Matrix.copy(this); 
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                result.matrix[r][c]=result.matrix[r][c].subtract(m.matrix[r][c]);
        result.id = this.id + " - " + m.id;
        return result;
    }

    /**
     * Multiplies this Matrix by a Numeric given as an argument
     * accumulates the result in this one
     * @param f - Numeric to multiply by 
     */
    public Matrix multiply(Numeric f) 
    {
        Matrix result = Matrix.copy(this); 
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                result.matrix[r][c]=result.matrix[r][c].multiply(f);
        result.id = this.id + " * " + f.toString();
        return result;

    }

    /**
     * Multiplies this Matrix by the one given as an argument
     * accumulates the result in this one
     * @param m - matrix to multiply by 
     */
    public Matrix multiply(Matrix m) 
    {
        Matrix result = Matrix.copy(this); 

        for( int i = 0; i < matrix.length; i++ )
            for( int j = 0; j < result.matrix[0].length; j++ )
            {
                Numeric c = matrix[0][0].getZero();
                for( int k = 0; k < matrix[0].length; k++ )
                {
                    Numeric f = matrix[ i ][ k ].copy();
                    f=f.multiply(m.matrix[ k ][ j ]);
                    c=c.add( f );
                }
                result.matrix[ i ][ j ] = c;
        }
        result.id = this.id + " * " + m.id;
        return result;
    }

    /**
     * Divides this Matrix through a Numeric given as an argument
     * accumulates the result in this one
     * @param f - Numeric to divide thorugh 
     */
    public Matrix divide(Numeric f) 
    {
        Matrix result = Matrix.copy(this); 

        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                result.matrix[r][c].divide(f);
        return result;
    }

    /**
     * Transposes this matrix
     */
    public void transpose() 
    {
        Numeric[][] t = new Numeric[matrix[0].length][matrix.length];
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
     * Returns a String representation of this matrix
     * @return matrix as a String
     */
    public String toString() 
    {
        String s = id + "\n----------------\n";
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
        Matrix m = new Matrix(3, 3, "m: 3 by 3 with row+1/col+1");
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
                m.setElem(r, c, new Fraction(r + 1, c + 1));
        System.out.println(m);
        Matrix m1 = new Matrix(3, 3, "m1: 3 by 3 with 10*row+1/10*col+1");
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
                m1.setElem(r, c, new Fraction(10*r + 1, 10*c + 1));
        System.out.println(m1);
        Matrix m3 = m1.subtract(m);
        System.out.println(m3);
        Matrix m2 = new Matrix(3, 2, "m2: 3 by 2 with 10*row+1/10*col+1" );
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 2; c++)
                m2.setElem(r, c, new Fraction(r + 1, c + 1));
        System.out.println(m2);
        System.out.println("\nTranspose of 3 by 2 with 10*row+1/10*col+1\n");
        m2.transpose();
        System.out.println(m2);
    }
}
