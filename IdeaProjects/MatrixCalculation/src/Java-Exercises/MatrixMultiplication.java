import java.util.InputMismatchException;
import java.util.Scanner;
public class MatrixMultiplication {
    public static void main(String[] args) {
     int[][] firstMatrix= askForMatrix("Matrix A: ");
     int[][] secondMatrix= askForMatrix("Matrix B: ");
     checkValidity(firstMatrix,secondMatrix);
    }

    //Asks the user for the size and values of the Matrix and checks for errors
    public static int[][] askForMatrix(String userInput){
        Scanner scanner = new Scanner(System.in);
        System.out.print(userInput);
        try {
            String matrixInput = new String(scanner.nextLine());
            int rows = Integer.parseInt(String.valueOf(matrixInput.charAt(0)));
            int columns = Integer.parseInt(String.valueOf(matrixInput.charAt(2)));
            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            return matrix;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid format for matrix dimensions. Please enter numbers");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("Error: It seems what you entered is not an integer. Please enter integers.");
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    //Checks if the size of the first matrix's row is equal to the size of the second matrix's column
    public static void checkValidity(int[][] matrix1, int[][] matrix2){
        if(matrix1[0].length != matrix2.length){
            System.out.println("This matrix multiplication is not valid");
        } else {
            int[][] finalAnswer = matrixMultiplication(matrix1, matrix2);
            printMatrix(finalAnswer);
        }
    }

    //Does the matrix multiplication and returns the resultant matrix
    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2){
        int[][] finalMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    finalMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return finalMatrix;
    }

    // Prints the resultant matrix
    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix C:");
        for (int[] row : matrix) {
            System.out.print("| ");
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println("|");
        }
    }
}

