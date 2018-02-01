
/*
 * Brad Malarkey
 * 
 * Lab 8- create a program that will calculate batting average and slugging percentage
 * based off the number of at bats and the result at each at bat.
 * 
 * 
 * I couldn't get the output to go to three decimal places. tried using DecimalFormat but it was only coming out
 * as a whole integer.
 * 
 * Also realize I could clean this up by putting the calculations and such into methods but I'm still a bit shaky on that, going to practice this weekend
 * 
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BattingStats {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int atBat;
		int sum1 = 0; // initialize this variable to be able to use in calculations later
		String cont = "y";
		System.out.println("Welcome to the batting average calculator.");
		System.out.println();
		while (cont.equalsIgnoreCase("y")) {
			atBat = Validator.getInt(scan, "Enter number of times at bat: "); // use validator class to make sure input
																				// is correct
			System.out.println(atBat);
			int[] resultPerBat = new int[atBat]; // initialize array to store the results of the user input, capacity is
													// equal to the value user enters
			System.out.println();
			System.out.println("out=0, single=1, double=2, triple=3, run=4."); // directions for the user

			for (int i = 0; i < resultPerBat.length; i++) { // iterates through array
				int result = Validator.getInt(scan, "Result for at-bat " + i + " was(enter 0-4 based on result): ", 0,
						4);
				resultPerBat[i] = result; // stores the input in the array

			}
			for (int i = 0; i < resultPerBat.length; i++) {// iterates through array and counts how many times at least
															// 1 base was scored
				switch (i) {
				case 1:
				case 2:
				case 3:
				case 4:
					sum1++;
					break;
				default: // if there were no bases nothing happens
					break;
				}

			}
			double batAvg = sum1 / atBat; // calculation for batting avg
			System.out.println("Batting average: " + batAvg);

			int sum2 = IntStream.of(resultPerBat).sum();
			double slugPercent = sum2 / atBat;
			System.out.println("Slugging Percentage: " + slugPercent);
			System.out.println();

			System.out.println("Would you like to do another player? (y/n): ");
			cont = scan.nextLine();

		}
		System.out.println("Thanks for using the batting average calculator. Goodbye!");

	}

}
