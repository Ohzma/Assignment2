/*
 * Class: CMSC203 CRN 22297
 * Instructor: Prof. Grigoriy Grinberg
 * Description: Build an application that will receive a guess and report 
   if your guess is the random number that was generated.  Your application
   will narrow down the choices according to your previous guesses and continue
   to prompt you to enter a guess until you guess correctly.
 * Due: 27SEP2021
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Daniel Cortes Gratacos
*/

import java.util.Scanner;

public class RandomNumberGuesser 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int randNum, nextGuess, highGuess, lowGuess;
		String resp;
		char response = 0;
		
		Scanner keyboard= new Scanner (System.in);
		//RNG class object
		RNG rng= new RNG(); 
		
		do
		{
			//Required variables declaration
			lowGuess=1;
			highGuess=100;
			//Generating random number by calling rand() method
			randNum=RNG.rand();
			RNG.resetCount();
			//Program begins, requests user input
			System.out.println("Enter your first guess");
			
			nextGuess= keyboard.nextInt();
			
			//Program will loop and keep track of guesses until correct number is input
			
			do 
			{
				//If guess is greaterthan randNum, highGuess is guessed number
				if (nextGuess>randNum) 
				{
					if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
					{
						if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
						{
							lowGuess=nextGuess;
							}
						if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
						{
							highGuess=nextGuess;
							}
						}
					System.out.println("Number of guesses is "+rng.getCount());
					System.out.println("Your guess is too high");
					highGuess=nextGuess;
					System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
					nextGuess= keyboard.nextInt();
					}
				//If guess is lowerthan randNum, lowGuess is guessed number
				else if (nextGuess<randNum) 
				{
					if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
					{
						if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
						{
							lowGuess=nextGuess;
							}
						if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
						{
							highGuess=nextGuess;
							}
						}
					System.out.println("Number of guesses is "+rng.getCount());
					System.out.println("Your guess is too low");
					lowGuess=nextGuess;
					System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
					nextGuess= keyboard.nextInt();
					}
				}
			//If guess is correct
			while (nextGuess!=(randNum));
			if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
			{
				if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
				{
					lowGuess=nextGuess;
					}
				if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
				{
					highGuess=nextGuess;
					}
				}
			System.out.println("Number of guesses is "+rng.getCount());
			System.out.println("Congratulations, you guessed correctly \n Try again (y or n)");
			resp=keyboard.next();
			response=resp.charAt(0);
			//If user does not input appropriate responses
			while (response != 'Y' && response != 'y' && response != 'N' && response != 'n')
			{ 
				System.out.print("Please enter Yes or No: ");
				resp=keyboard.nextLine();
				response=resp.charAt(0);
				}
			}
		while (response=='Y' || response=='y');
		//Program ends with thankyou message and programmer name
		System.out.println("Thank you for playing...");
		System.out.println("PROGRAMMER: Daniel Cortes Gratacos");
		}
	}