import java.util.Scanner;

public class MatrixMult {

    public static void main(String[] args) {
        //time measurement variables
        long startTime, endTime, executionTime;

        //creating a scanner to read in the first two square matrices
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the matrix size and the matrix element: ");
        //prompt the user to enter two integers (matrix size and the matrix element)
        //it is assumed that all the matrix elements are the same.
        int size = scan.nextInt();
        int value = scan.nextInt();

        int[][] a = new int[size][size];
        int[][] b = new int[size][size];

        //reading matrix 1 and matrix 2
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = value;

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                b[i][j] = value;

        //declaring a matrix to store the result of the multiplication of matrix 1 and matrix 2
        int[][] resultmatrix = new int[size][size];

        //calling the method to multiply the two matrices and measuring the elapsed time
        startTime = System.currentTimeMillis();
        resultmatrix = multiplyMatrix(a, b);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

            System.out.println("Size:" + size + " Time:" + executionTime + " ms");
        }

        /**
         * multiplies the 2 matrices
         * @param a
         * @param b
         * @return result of MatrixMultiplication
         */
        public static int[][] multiplyMatrix(int[][] a, int[][] b) {
            int n = a.length;
            int[][] resultMatrix = new int[n][n];

            // Matrix multiplication using triple nested loops
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        resultMatrix[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            return resultMatrix;
        }
}
