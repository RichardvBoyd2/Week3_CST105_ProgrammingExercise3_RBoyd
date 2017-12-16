/** Program: Guessing Game
 * File: GuessingGame.java
 * Summary: Makes user guess between 1 and 10,000 until they get it
 * Author: Richard Boyd
 * Date: December 15th, 2017
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	
	private static Scanner scan;
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);                                        //This block sets up the game
		Random rand = new Random();
		System.out.println("Welcome to Guessing Game!");
		System.out.println("I have randomly selected a number between 1 and 10,000");
		System.out.println("Enter a guess between 1 and 10,000");
		int bot = 1, top = 10000, answer = rand.nextInt(top) + bot, guess = scan.nextInt(), guessCount = 1;
		while (guess < bot || guess > top) {                       //Witty prompt if user chooses a number not in the range
			System.out.println("Are you listening to me? I said enter a guess between " + bot + " and " + top);
			guess = scan.nextInt();
		}
		
		while (guess != answer) {                                  //This is the while loop the guessing in built in
			
			if (guess < answer) {                                
				System.out.println("INCORRECT");
				System.out.println("The number I have choosen is higher than " + guess);
				bot = guess + 1;
				System.out.println("Enter a guess between " + bot + " and " + top);
				guess = scan.nextInt();
				while (guess < bot || guess > top) {               //Witty prompt if user chooses a number not in the range
					System.out.println("Are you listening to me? I said enter a guess between " + bot + " and " + top);
					guess = scan.nextInt();
				}
				guessCount = guessCount + 1;
			}
			
			else {
				System.out.println("INCORRECT");
				System.out.println("The number I have choosen is lower than " + guess);
				top = guess - 1;
				System.out.println("Enter a guess between " + bot + " and " + top);
				guess = scan.nextInt();
				while (guess < bot || guess > top) {              //Witty prompt if user chooses a number not in the range
					System.out.println("Are you listening to me? I said enter a guess between " + bot + " and " + top);
					guess = scan.nextInt();
				}
				guessCount = guessCount + 1;
			}
			
		}
		
		if (guessCount == 1) {                                                 //First guess win!
			System.out.println("CORRECT");
			System.out.println("It only took you 1 guess! You got lucky!");
		}
		
		else {                                                                 //Win!
			System.out.println("CORRECT");
			System.out.println("The number I chose was " + answer);
			System.out.println("It took you " + guessCount + " guesses.");
		}
	}
}



