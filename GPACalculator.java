
package gpacalculator;

import java.util.Scanner;


public class GPACalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of courses");
        int courses = scanner.nextInt();
        int[] points = new int[courses];
        for (int i = 0; i < points.length; i++) {
            System.out.println("Enter the points for course " + (i+1));
            points[i] = scanner.nextInt();     
        }
        int[] creditHours = new int[courses];
        for (int i = 0; i < creditHours.length; i++) {
            System.out.println("Enter the credut hours for course " + (i+1));
            creditHours[i] = scanner.nextInt();     
        }
        
        double gpa = calculateGPA(points, creditHours);
        printResult("", gpa);
    }
    private static double calculateGPA (int[] points, int creditHours[]){
        int totalPoints = 0;
        int totalCredit = 0;
        for (int i = 0; i < points.length; i++) {
            totalPoints = totalPoints +  points[i];
        }
        for (int i = 0; i < creditHours.length; i++) {
            totalCredit = totalCredit +  creditHours[i];
        }
        return totalCredit/totalPoints; 

        
    }
    private static void printResult (String table, double gpa){
        System.out.println("GPA " +  gpa);
    }
    
}
