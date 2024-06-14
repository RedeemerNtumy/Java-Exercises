import java.util.Arrays;
import java.util.Scanner;
public class Pascal {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter your n : ");
        int userInput=scanner.nextInt();

        int [][] pascalArray= new int[userInput+1][userInput+1];
        if(userInput>0){
            for (int i = 0; i < pascalArray.length; i++) {
                for (int j = 0; j <= i ; j++) {
                    if(j==0 || i==j){
                        pascalArray[i][j]=1;
                    }
                    else{
                        pascalArray[i][j]=pascalArray[i-1][j-1]+pascalArray[i-1][j];
                    }

                }
            }

        }
        for (int[] row : pascalArray) {
            for (int num : row) {
                if (num != 0) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
    }


//