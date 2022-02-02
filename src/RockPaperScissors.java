import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        String[] rps = {"r" ,"p", "s"};
        Scanner scanner = new Scanner(System.in);
        String playerMove;
        String playAgain;

        while(true) {

            String computerMove = rps[new Random().nextInt(rps.length)];

            while(true) {
                System.out.println("Please enter your move (r, p, s)");
                playerMove = scanner.nextLine();
                if(playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move");
            }

            System.out.println("Computer played: " + computerMove);

            if(playerMove.equals(computerMove)) {
                System.out.println("The game was a tie!");
            } else if(playerMove.equals("r")){
                if(computerMove.equals("p")){
                    System.out.println("You lose!");
                } else if(computerMove.equals("s")) {
                    System.out.println("You won!");
                }
            } else if(playerMove.equals("p")){
                if(computerMove.equals("s")){
                    System.out.println("You lose!");
                } else if(computerMove.equals("r")) {
                    System.out.println("You won!");
                }
            } else if(playerMove.equals("s")){
                if(computerMove.equals("r")){
                    System.out.println("You lose!");
                } else if(computerMove.equals("p")) {
                    System.out.println("You won!");
                }
            }

            while(true) {
                System.out.println("Play again? (y/n)");
                playAgain = scanner.nextLine();
                if(playAgain.equals("y") || playAgain.equals("n")) {
                    break;
                }
                System.out.println(playAgain + " is not a y/n selection! Try again");
            }
            if(playAgain.equals("n")) {
                break;
            }
        }
    }
}
