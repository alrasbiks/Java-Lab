import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class STDcalculator {

    /**
     * This method loads an array of decimal numbers from a file
     *
     * @param fileName the file name containing decimal numbers, one per line
     * @return returns and array of doubles contained in file
     * @throws Exception associated with IO:  FileNotFound or IO exceptions
     */
    public static double[] loadNumberFromFile(String fileName) throws Exception {
        File inFile = new File(fileName);
        Scanner inScan = new Scanner(inFile);
        double[] numbers = new double[100];
        int numberCounter = 0;
        while (inScan.hasNext()) {
            numbers[numberCounter] = inScan.nextDouble();
            numberCounter++;
        }
        inScan.close();
        return numbers;
    }

    /**
     * This method takes an array of double and returns the average
     *
     * @param numbers array of numbers
     * @return average of array taken as argument
     */
    public static double averageNumbers(double[] numbers) {
        double sum = 0;
        for (int dex = 0; dex < numbers.length; dex++) {
            sum += numbers[dex];
        }
        return sum / numbers.length;
    }

    /**
     * The function prompts the user to enter the name of the file which contains the decimal numbers
     *
     * @return name of the file
     */
    public static String enterFileName() {
        //The scope of this scanner object is only within this method
        Scanner keyboard = new Scanner(System.in);

        String prompt = "Enter the filename for file\ncontaining decimal numbers!";
        System.out.println(prompt);

        String fName = keyboard.nextLine();

        return fName;
    }

    /**
     * This method displays an introduction to the program
     */
    public static void displayGreeting() {
        String greeting = "This program will calculate the average and standard deviation of numbers\n" +
                "loaded from a file containing one decimal number per line.\n" +
                "First you will be asked to enter the file name, then\n" +
                "the average and standard deviation will be displayed.\n";
        System.out.println(greeting);
    }

    /**
     * The calculates the standard deviation of the numbers passed in the function argument
     *
     * @param numbers    - array of numbers
     * @param numAverage - average of the numbers
     * @return standard deviation of array taken as argument
     */
    private static double calculateSTD(double[] numbers, double numAverage) {
        int count = numbers.length;
        double totalDistToMean = 0.0;
        double std;

        //calculating the total distance from all data points to the mean
        for (int i = 0; i < count; i++) {
            totalDistToMean = totalDistToMean + Math.pow((numbers[i] - numAverage), 2);
        }

        //calculating the standard deviation
        std = Math.sqrt(totalDistToMean / count);
        return std;
    }

    /**
     * The main function
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        displayGreeting();
        String numberFileName = enterFileName();
        double[] decNumbers = loadNumberFromFile(numberFileName);
        double numAverage = averageNumbers(decNumbers);
        double numSTD = calculateSTD(decNumbers, numAverage);
        NumberFormat format = new DecimalFormat("#.###");
        String results = "The average of the numbers in file: " + numberFileName +
                "\nis " + format.format(numAverage) + " and standard deviation: " + format.format(numSTD) + "\n\nProgram terminating.";
        System.out.println(results);
    }
}
