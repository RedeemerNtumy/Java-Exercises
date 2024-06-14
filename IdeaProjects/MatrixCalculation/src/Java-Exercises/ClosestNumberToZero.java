public class ClosestNumberToZero {
    public static int findClosestToZero(int[] array) {
        int closest = array[0];
        for (int number : array) {
            closest=Math.abs(closest)>=Math.abs(number) || (Math.abs(closest)==Math.abs(number) && number>closest)? number:closest;
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] myList = {-1, 1, 3, -2};
        int closest = findClosestToZero(myList);
        System.out.println(closest);
    }
}
