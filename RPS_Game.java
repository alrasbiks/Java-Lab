import java.util.Random;
import java.util.Scanner;

public class RPS_Game {
    public static void main(String[] args) {
        String[] choices = new String[]{"rock", "paper", "scissors"};
        String computerChoice, userChoice;
        int ties = 0, computerWins = 0, userWins = 0;
        greeting();
        for (int game = 1; game <= 3; game++) {
            computerChoice = choices[generateComputersChoice()];
            userChoice = choices[enterPlayersChoice(game)];
            System.out.println("For game " + game);
            System.out.println("\nYou played " + userChoice + " and\n" +
                    "Computer played " + computerChoice);
            System.out.println();

            if (computerChoice.equals(userChoice)) {
                ties++;
                System.out.println("It's a tie!");
            } else if (userChoice.equals("rock")) {
                if (computerChoice.equals("scissors")) {
                    System.out.println("Rock crushes scissors!");
                    System.out.println("You win!");
                    userWins++;
                } else if (computerChoice.equals("paper")) {
                    System.out.println("Paper eats rock!");
                    System.out.println("You lose!");
                    computerWins++;
                }
            } else if (userChoice.equals("paper")) {
                if (computerChoice.equals("scissors")) {
                    System.out.println("Scissor cuts paper!");
                    System.out.println("You lose!");
                    computerWins++;
                } else if (computerChoice.equals("rock")) {
                    System.out.println("Paper eats rock!");
                    System.out.println("You win!");
                    userWins++;
                }
            } else if (userChoice.equals("scissors")) {
                if (computerChoice.equals("paper")) {
                    System.out.println("Scissor cuts paper!");
                    System.out.println("You win!");
                    userWins++;
                } else if (computerChoice.equals("rock")) {
                    System.out.println("Rock breaks scissors!");
                    System.out.println("You lose!");
                    computerWins++;
                }
            }
            System.out.println();
        }
        //printing game results
        System.out.println("For a total of 3 wins,\n" +
                "There were " + ties + " ties\n" +
                "There were " + userWins + " for you\n" +
                "There were " + computerWins + " wins for the computer");
    }

    /**
     * The function displays the purpose of the program
     */
    public static void greeting() {
        System.out.println("The program implements Rock-Paper-Scissors amd allows user to play three games of the games");
    }

    /**
     * The function generates and returns a random integer which represents the computer choice for the
     * game
     *
     * @return
     */
    public static int generateComputersChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        return choice;
    }

    public static int enterPlayersChoice(int gameNumber) {
        Scanner scanner = new Scanner(System.in);
        char userChoice;
        System.out.println("Enter your selection for game #" + gameNumber);
        System.out.println("Enter");
        System.out.println("'R' for rock,");
        System.out.println("'P' for paper, or");
        System.out.println("'S' for scissors.");
        do {
            userChoice = scanner.next().charAt(0);
            if (userChoice != 'R' && userChoice != 'P' && userChoice != 'S') {
                System.out.println("Invalid choice. Enter again");
            } else {
                if (userChoice == 'R') {
                    return 0;
                } else if (userChoice == 'P') {
                    return 1;
                } else {
                    return 2;
                }
            }
        } while (true);

    }
}
