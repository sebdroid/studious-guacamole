//Solution to Q1 B
//Sebastian Jose
//1923070

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Q1b {
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
        Random r = new Random(); //Initialise random number system
        for (int i = 0; i < num * num; i++) { //Shuffle magic square
            x = r.nextInt(num); //What element to be shuffled
            y = r.nextInt(num);
            int direction = r.nextInt(4); //What direction to swap
            square = swap(square, x, y, direction); //Swap elements
        }
        // printSquare(square); //Show solution
        in.nextLine(); //Clear anything in scanner
        int moves = 0; //Start couting moves
        do { //Do until magic square is solved
            ArrayList<Integer> coords = new ArrayList<>(); //Initialise input variables
            char direction = 'z';
            do { //Do until valid input is obtained
                printSquare(square);
                System.out.println("Enter '(row) (column) (u/d/l/r)' to swap: "); //Prompt user
                try {
                    while (in.hasNextInt() && coords.size() != 2) { //Do until two valid integers inputs are obtained 
                        int input = in.nextInt(); //Get next integer
                        if (input > 0 && input <= num) { //If it is a valid location
                            coords.add(input); //Add it to ArrayList
                        } else {
                            throw new InputMismatchException(); //Otherwise throw an error
                        }
                    }
                    if (in.hasNext(Pattern.compile("[udlr]", Pattern.CASE_INSENSITIVE))) { //If the next input is a valid character input for direction
                        direction = Character.toLowerCase(in.next().charAt(0)); //Set it as the direction
                    } else {
                        throw new InputMismatchException(); //Otherwise throw an error
                    }
                } catch (InputMismatchException e) { //If an error was thrown
                    in.nextLine(); //Clear out the scanner so new input can be obtained
                    coords.clear(); //Clear out the ArrayList for new location
                    System.out.println("Invalid input entered. Please enter in the format specified."); //Help the user out
                }
            } while (coords.size() != 2 || direction == 'z'); 
            swap(square, coords.get(0) - 1, coords.get(1) - 1, direction); //Swap the elements with type promotion for direction
            moves++; //Increment the number of moves used
        } while (!checkAnswer(square));
        in.close(); //Close scanner as no more input is required
        System.out.println("\nCongratulations! You have solved the magic square in " + moves + " moves."); //Tell the user the score
    }

    private static void printSquare(int square[][]) { //Function to print magic square
        for (int x = 0; x < square.length; x++) { //Iterate throw the rows and columns
            for (int y = 0; y < square.length; y++) {
                System.out.printf("%-5d", square[x][y]); //Print row with correct spacing between each column element
            }
            System.out.println(); //Print new line for the next row
        }
    }

    private static int[][] swap(int square[][], int x, int y, int direction) { //Function to swap elements
        int temp = 0; //Instantiate temp variable
        int num = square.length; //Find number of elements
        switch (direction) { //Depending on direction
            case 0: //UP using random number generation
            case 117: //UP using type promotion from user input
                temp = square[x][y]; //Swap element
                square[x][y] = square[Math.floorMod(x-1, num)][y];
                square[Math.floorMod(x-1, num)][y] = temp;
                break;
            case 1: //RIGHT using random number generation
            case 114: //RIGHT using type promotion from user input
                temp = square[x][y];
                square[x][y] = square[x][Math.floorMod(y+1, num)];
                square[x][Math.floorMod(y+1, num)] = temp;
                break;
            case 2: //DOWN using random number generation
            case 100: //DOWN using type promotion from user input
                temp = square[x][y];
                square[x][y] = square[Math.floorMod(x+1, num)][y];
                square[Math.floorMod(x+1, num)][y] = temp;
                break;
            case 3: //LEFT using random number generation
            case 108: //LEFT using type promotion from user input
                temp = square[x][y];
                square[x][y] = square[x][Math.floorMod(y-1, num)];
                square[x][Math.floorMod(y-1, num)] = temp;
                break;
        }
        return square; //Return swapped square
    }

    private static boolean checkAnswer(int square[][]) { //Function to check the solution
        int num = square.length; //Find number of elements
        int magic = (num * ((num * num) + 1)) / 2; //Calculate magic number
        int sum = 0; //Temporary variable to hold sum
        for (int i = 0; i < num; i++) { //Calculate diagonal sum
            sum += square[i][i];
        }
        if (magic != sum) { //If it is not the magic number
            return false; //Not solved
        }
        sum = 0; //Reset temp variable
        for (int i = 0; i < num; i++) { //Calculate other diagonal sum
            sum += square[i][num - 1 - i];
        }
        if (magic != sum) {
            return false;
        }
        for (int i = 0; i < num; i++) { //Calculate row sum
            sum = 0; 
            for (int j = 0; j < num; j++) {
                sum += square[i][j];
            }
            if (magic != sum) {
                return false;
            }
        }
        for (int i = 0; i < num; i++) { //Calculate column sum
            sum = 0;
            for (int j = 0; j < num; j++) {
                sum += square[j][i];
            }
            if (magic != sum) {
                return false;
            }
        }
        return true; //Magic square is solved
    }
}