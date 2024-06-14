import java.util.Arrays;

public class Practise {
    public static void main (String[] args){
   int [][] array2D= new int[4][4];
   int rows=array2D.length;
   int columns=array2D[0].length;
   int counter = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array2D[i][j]=counter++;
            }
        }
        System.out.println(Arrays.deepToString(array2D));

   }
}
