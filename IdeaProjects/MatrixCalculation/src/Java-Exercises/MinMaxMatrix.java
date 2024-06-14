import java.util.InputMismatchException;
import java.util.Scanner;

public class MinMaxMatrix {
    public static void main (String[] args){
        int[][] matrix= askForMatrix("Matrix A: ");
        calculatePeak(matrix); // Should return void
    }
    public static int[][] askForMatrix(String userInput) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(userInput);
        int[][] matrix;
        try {
            String matrixInput = new String(scanner.nextLine());
            int rows = Integer.parseInt(String.valueOf(matrixInput.charAt(0)));
            int columns = Integer.parseInt(String.valueOf(matrixInput.charAt(2)));
            matrix = new int[rows][columns];
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
    //Should return a String[][]
    public static void calculatePeak(int[][] inputMatrix){
//        System.out.println(Arrays.deepToString(inputMatrix))
    }
}
