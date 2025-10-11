import java.util.Random;

public class Main {

    // Method to compute one element of w
    public static double computeElement(long sValue, double xValue) {
        double result;

        if (sValue == 12) {
            result = Math.tan(Math.asin(Math.sin(xValue)));
        } else if (sValue == 3 || sValue == 4 || sValue == 5 ||
                sValue == 11 || sValue == 13 || sValue == 14) {
            result = Math.log(Math.acos(Math.cos(xValue)));
        } else {
            // Formula for "other cases"
            result = Math.cos(
                    Math.log(
                            Math.pow(
                                    Math.E,
                                    Math.pow(
                                            Math.tan(xValue),
                                            (1 - Math.pow(3.0 / xValue, 3)) * 3
                                    )
                            )
                    )
            );
        }

        return result;
    }

    // Method to print 2D array with 3 decimal places
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("10%.3f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Step 1: Array s (long) from 3 to 15
        long[] s = new long[13];
        for (int i = 0; i < 13; i++) {
            s[i] = i + 3;
        }

        // Step 2: Array x (double) with 19 random numbers from -15.0 to 11.0
        double[] x = new double[19];
        Random random = new Random();
        for (int j = 0; j < 19; j++) {
            x[j] = -15.0 + (11.0 + 15.0) * random.nextDouble();
        }

        // Step 3: 2D array w (13 x 19)
        double[][] w = new double[13][19];

        // Fill w using computeElement()
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 19; j++) {
                w[i][j] = computeElement(s[i], x[j]);
            }
        }

        // Step 4: Print result
        printMatrix(w);
    }
}
