import java.util.Scanner;
import java.util.Arrays;

public class GradeStatistics {
    public static void main(String args[]) {
        calculateGrade();
    }

    //Main calculates the scores and calls displayScoreStatistics method
    public static void calculateGrade() {
        System.out.println("Enter the grades separated by space:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] scores = parsedScores(input);
        Arrays.sort(scores);
        showScoreStatistics(scores);
        showScoreDistribution(scores);
    }

    //Shows the Maximum, Minimum and Average
    public static void showScoreStatistics(int[] scores) {
        int min = scores[0];
        int max = scores[scores.length - 1];
        double avg = Arrays.stream(scores).average().orElse(0);
        System.out.println("The maximum grade is " + max);
        System.out.println("The minimum grade is " + min);
        System.out.println("The average grade is " + avg);
        System.out.println();
    }

    //Categorizes the scores
    public static void showScoreDistribution(int[] scores) {
        int[] stats = new int[5];

        for (int stat : scores) {
            if (stat > 80) {
                stats[4]++;
            } else if (stat > 60) {
                stats[3]++;
            } else if (stat > 40) {
                stats[2]++;
            } else if (stat > 20) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }

        barChart(stats);
    }

    // Displays the scores data
    public static void barChart(int[] distribution) {
        int highestHeight = Arrays.stream(distribution).max().orElse(0);
        for (int i = highestHeight; i >= 1; i--) {
            System.out.printf("%2d  > ", i);
            for (int count : distribution) {
                System.out.print(count >= i ? "#######   " : "          ");
            }
            System.out.println();
        }
        System.out.println("  +-----------+---------+---------+---------+---------+");
        System.out.println("  I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");
    }

    // Parses a string of space-separated scores into an integer array.
    static int[] parsedScores(String input) {
        String[] splitArray = input.split(" ");
        int[] scores = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            scores[i] = Integer.parseInt(splitArray[i]);
        }
        return scores;
    }
}
