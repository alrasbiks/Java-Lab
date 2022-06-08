import java.io.*;
import java.util.*;

public class StateDataAnalyzer {

    private static int NUMBER_STATES = 50;

    /**
     * The function loads names of states from  a csv file
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String[] loadNamesFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        String[] array = new String[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            array[row] = fileScan.next();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * The function loads loads the average per capita income of the states from a csv file
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static double[] loadPercapitaFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            array[row] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * The function loads population data from a csv file
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static int[] loadPopulationFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        int[] array = new int[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextInt();
            fileScan.nextLine();
        }
        return array;
    }


    /**
     * The function loads land sizes from a csv file
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static double[] loadLandSizeFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextDouble();
        }
        return array;
    }


    /**
     * The function finds the index of the maximum number in the array provided in its parameter
     *
     * @param array
     * @return
     */
    public static int findMaxIndex(double[] array) {
        int maxIndex = 0;
        for (int row = 0; row < NUMBER_STATES; row++) {
            if (array[row] > array[maxIndex]) {
                maxIndex = row;
            }
        }
        return maxIndex;
    }

    /**
     * The function finds the index of the minimum number in the array provided in its parameter
     *
     * @param array
     * @return
     */
    public static int findminIndex(double[] array) {
        int minIndex = 0;
        for (int row = 0; row < NUMBER_STATES; row++) {
            if (array[row] < array[minIndex]) {
                minIndex = row;
            }
        }
        return minIndex;
    }

    /**
     * The function displays introduction message
     */
    public static void displayIntro() {
        System.out.println("Welcome to State Data Analyzer");
    }

    /**
     * The function displays a menu with vari
     */
    public static void displayMenu() {
        System.out.println("1. Find state with maximum land mass");
        System.out.println("2. Find state with minimum land mass");
        System.out.println("3. Find state with maximum population");
        System.out.println("4. Find state with minimum population");
        System.out.println("5. Find state with maximum average income");
        System.out.println("6. Find state with minimum average income");
    }


    /**
     * The main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String fileName = "State_Data.csv";
        Scanner inputScan = new Scanner(System.in);
        //display introduction
        displayIntro();
        String[] stateNames = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        int[] populationData = loadPopulationFromFile(fileName);
        double[] landSizeData = loadLandSizeFromFile(fileName);
        int option;
        do {
            //display menu
            displayMenu();
            System.out.print("Select one of the options: ");
            option = inputScan.nextInt();
            if (option == 1) {//maximum land mass
                System.out.println(stateNames[findMaxIndex(landSizeData)] + " state has the highest land mass of " + landSizeData[findMaxIndex(landSizeData)]);
            } else if (option == 2) {//minimum land mass
                System.out.println(stateNames[findminIndex(landSizeData)] + " state has the smallest land mass of " + landSizeData[findminIndex(landSizeData)]);
            } else if (option == 3) {//maximum population
                System.out.println(stateNames[findMaxIndex(Arrays.stream(populationData).asDoubleStream().toArray())] + " state has the largest population of " + populationData[findMaxIndex(Arrays.stream(populationData).asDoubleStream().toArray())]);
            } else if (option == 4) {//minimum population
                System.out.println(stateNames[findminIndex(Arrays.stream(populationData).asDoubleStream().toArray())] + " state has the smallest population " + populationData[findminIndex(Arrays.stream(populationData).asDoubleStream().toArray())]);
            } else if (option == 5) {//maximum average income
                System.out.println(stateNames[findMaxIndex(percapitaData)] + " state has the maximum average income of " + percapitaData[findMaxIndex(percapitaData)]);
            } else if (option == 6) {//minimum average income
                System.out.println(stateNames[findminIndex(percapitaData)] + " state has the minimum average income of " + percapitaData[findminIndex(percapitaData)]);
            } else {//invalid option
                System.out.println("Invalid option");
            }
        } while (true);
    }

}
