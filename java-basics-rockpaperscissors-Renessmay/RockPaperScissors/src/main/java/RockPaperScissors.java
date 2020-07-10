
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */

public class RockPaperScissors {
    
    public static int CollectingInput(String prompt, int lowerBound, int upperBound) {
        
        // declaring an intialising reader to collect input
        // Declare and initialise scanner to collect user input
        Scanner inputReader = new Scanner(System.in);
        
        // declaring input variable which will be used to store user input
        int input = 0;
        // collects user input for number of rounds
        
            System.out.println(prompt);
            while (true) {
                
                // try and catch for dealing with user input, if not a valid input
                // or not within range
                // if integer entered and within the range,
                // break keyword exits loop, otherwise keeps looping
                
                try {
                    input = Integer.parseInt(inputReader.nextLine());
                    if (input < lowerBound || input > upperBound) {
                         System.out.println("Error, please enter a valid input: ");
                       // System.exit(0);
                        
                    } else {
                        // breaks out of loop if a valid input is entered
                        break;
                    }
                }
                
                // if a number is not entered will jump to catch
                // and output error message before looping again
                catch (NumberFormatException ex) {
                    System.out.println("Error, invalid input.");
 
                }
            }
            
        // returns input which will be assigned to the relevant variable
        // when the method is called
        return input;
    }
    public void App() {
        
        // declaring variables
        int numberOfRounds;
        int computerChoice, userChoice;
        int keepPlaying;
        
        // declare and initialise rng for computeres choice
        Random rng = new Random();
        
        // String which stores the rock paper scissors strings which can be
        // accessed using the number to play minus 1
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        do {
            // Resets these variabbles each time a new game is selected
            int computerWinsCounter = 0;
            int userWinsCounter = 0;
            int tiesCounter = 0;
            
            // using the method to collect user input on the number of rounds
            // using the bounds to place contraints
            numberOfRounds = CollectingInput("Please enter the number of rounds  you wish to play: ", 1, 10);
            for (int i = 1; i <= numberOfRounds; i++) {
                
                // assigning variable userChoice the int that the Scanner reads in
                // by calling the method
                userChoice = CollectingInput("Please enter your choice, rock is 1, paper is 2, scissors are 3: ", 1, 3);
                
                // randomly generates the computers choice using an rng
                computerChoice = rng.nextInt(3) + 1;
                
                // if both choices are equal tiesCounter increments and prints out
                // the choice and that the game is a tie
                if (userChoice == computerChoice) {
                    tiesCounter++;
                    System.out.println("You both chose " + moves[userChoice-1] + "! Game is a tie.");
                    
                // very clunky, easier way using modulo, not sure how to do it
                // comparing users choice with computers choice and selecting
                // appropriate response e.g. user wins!
                } else if (userChoice == 1 && computerChoice == 2 || userChoice == 2 && computerChoice == 3 || userChoice == 3 && computerChoice == 1) {
                    computerWinsCounter ++;
                    System.out.println("You chose " + moves[userChoice - 1] + ", and the computer chose " + moves[computerChoice - 1] + ". The computer won.");
                } else {
                    System.out.println("You chose " + moves[userChoice - 1] + ", and the computer chose " + moves[computerChoice - 1]+ ". You won.");
                    userWinsCounter ++;
                }
            }
            
            // prints the number of rounds won lost and drawn
            System.out.println("\nThere were " + userWinsCounter + " rounds won by you, " + computerWinsCounter + " rounds won by the computer, and " + tiesCounter + " rounds ended in a tie.");
            
            // if stattement that determins who won and prints the relevant message
            if (userWinsCounter == computerWinsCounter) {
               System.out.println("Game ends in a draw!");
            } else if (userWinsCounter > computerWinsCounter) {
                System.out.println("You won!!");
            } else {
                System.out.println("The computer won!");
            }
            
            // requires the user to type 1 or 2 as opposed to yes or no
            // but allows calling of the same method
            keepPlaying = CollectingInput("Do you wish to keep playing, yes is 1, no is 2: ", 1, 2);
            
        } while (keepPlaying == 1);
        System.out.println("Thank you for playing!");
    }
}