//Solution to Q1 A
//Sebastian Jose
//1923070

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1a {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        //Get user input on how big magic square should be
        do { //Do until valid input is obtained
            try {
                System.out.print("Enter a positive ODD integer: "); //Prompt user
                num = Math.abs(in.nextInt()); //Accept a positive integer 
            } catch (InputMismatchException e) { //If any other input is entered
                in.nextLine(); //Clear out scanner input for retry
            }
        } while (num % 2 == 0); //Number should be odd
        in.close(); //Close scanner as no more input is required
        int square[][] = new int[num][num]; //Initialise magic square
        int x = 0; //Set up variables for algorith,
        int y = (num - 1) / 2;
        square[x][y] = 1;
        for (int i = 2; i <= num * num; i++) {
            if (square[Math.floorMod(x-1, num)][Math.floorMod(y-1, num)] == 0) { //Wrap around logic
                x = Math.floorMod(x-1, num); //Calculate mod to work out wrap around position
                y = Math.floorMod(y-1, num);
            } else {
                x = Math.floorMod(x+1, num);
            }
            square[x][y] = i;
        }
        printSquare(square); //Print magic square generated
    }

    private static void printSquare(int square[][]) { //Function to print magic square
        for (int x = 0; x < square.length; x++) { //Iterate throw the rows and columns
            for (int y = 0; y < square.length; y++) {
                System.out.printf("%-5d", square[x][y]); //Print row with correct spacing between each column element
            }
            System.out.println(); //Print new line for the next row
        }
    }
}