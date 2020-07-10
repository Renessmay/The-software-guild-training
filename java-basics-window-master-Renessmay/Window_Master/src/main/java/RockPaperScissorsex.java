/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsex {
 
public static void main(String[] args) {
    
    // Declare and initialise scanner to collect user input
    Scanner userinput = new Scanner(System.in);
    
    Random rnd = new Random();

        int computerInt;
        int numberOfRounds = 0;
        int roundCounter, compWins, userwins, ties;
        String userInput, compInput;
        String userPlay;
        String computerMove = "";
        
        String playagain = "y";
        
        Boolean isValid = false;
        
        // declare and initialise rng for computeres choice

        String[] rps={"R", "P", "S"};
        
        System.out.println("Let's play Rock, Paper, Scissors!\n" +"Rock = R, Paper = P, and Scissors = S.");
        
        while(playagain.equals("y")){
            
        do {
            // collects user input for number of rounds
            System.out.print("\nPlease enter the number of rounds you wish to play: ");
            // try and catch for dealing with user input, if not a valid input
            // or not within range
            try {
                numberOfRounds = Integer.parseInt(userinput.nextLine());
                if (numberOfRounds < 1 || numberOfRounds > 10) {
                    System.out.println("Error, invalid input");
                    System.exit(0);
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Error, invalid input");
                System.exit(0);
            }
            
            
            for (int i = 1; i <= numberOfRounds; i++) {
                
                // which will deal with the mechanics of playing the game
                //System.out.println();
                computerInt = rnd.nextInt(3)+1;
                if (computerInt == 1)
                   computerMove = rps[0];
                else if (computerInt == 2)
                   computerMove = rps[1];
                else if (computerInt == 3)
                   computerMove = rps[2];
                System.out.print("Enter your play: ");
                userPlay = userinput.next();
                userPlay = userPlay.toUpperCase();
                System.out.println("\nComputer play is: " + computerMove+ "\n");
                
                if (userPlay.equals(computerMove)){
                   System.out.println("It's a tie!\n");
                }
                //
                else if (userPlay.equals("R")){
                   if (computerMove.equals("S"))
                        System.out.println("Rock crushes scissors. You win!!\n");
                    else if (computerMove.equals("P"))
                        System.out.println("Paper eats rock. You lose!!\n");
                }
                //
                else if (userPlay.equals("P")){
                   if (computerMove.equals("S"))
                   System.out.println("Scissor cuts paper. You lose!!\n");
                else if (computerMove.equals("R"))
                        System.out.println("Paper eats rock. You win!!\n");
                }
                else if (userPlay.equals("S")) {
                    if (computerMove.equals("P"))
                        System.out.println("Scissor cuts paper. You win!!\n");
                    else if (computerMove.equals("R"))
                        System.out.println("Rock breaks scissors. You lose!!\n");
                }
                else
                     System.out.println("Invalid user input.");
                }
                    break;
                    }
                while (!isValid);{
                }
                

            System.out.print("Want to keep going? (y/n) :");
            playagain = userinput.next();
        }
    

    
        }}