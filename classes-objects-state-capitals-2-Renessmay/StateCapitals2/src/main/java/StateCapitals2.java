
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */

public class StateCapitals2 {
    
public static void main(String[] args) throws Exception {

        Random rng = new Random();
        // variable to count the number of states and number of guesses
        int stateCount = 0;
        int numberOfGuess;
        // Initalising Scanner object to read the file
        // opens the file
        // reads each linen
        Scanner myScanner = new Scanner(System.in);
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        String[] parts;
        // Creates an instance of a hashmap that fufills the interface Map
        // with keys and values passed in as string
        Map<String, String> capitals = new HashMap<>();
        // gets the set of keys from the hash map and assigns to the key variable
        Set<String> states = capitals.keySet();
        // gets a collection of values from out hash map
        Collection<String> stateCapitals = capitals.values();
        // ends when there’s no more lines
        // data isn’t getting read in correctky for some reason
        // get metadata/gibberish at the top
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            // need to weed out the gibberish
            // ensures that only lines we want read in will be broken
            // up and entered into the hash map
            if (currentLine.contains("::")) {
                parts = currentLine.split("::");
                // need to use this method to give a string representation to 1d arrays.
                capitals.put(parts[0], parts[1]);
            }
        }
        // transfer the set of states to an array
        // to generate a random capital
        String[] statesArray = new String[states.size()];
        // interates through set of states and prints each key
        // as well as incrementing the state count
        // sets the value in the statesArray to the state
        for (String s: states) {
            System.out.println(s);
            statesArray[stateCount] = s;
            stateCount ++;
        }
        System.out.println(stateCount + " STATES & CAPITALS ARE LOADED.\n======");
        System.out.println("How many guesses would you like?");
        do {
            try {
                numberOfGuess = Integer.parseInt(myScanner.nextLine());
                break;
            }
            catch (NumberFormatException ex) {
                System.out.println("Error, invalid input, please try again: ");
            }
        } while(true);
        for (int i = 0; i < numberOfGuess; i ++) {
            // generates a random state
            String guessState = statesArray[rng.nextInt(states.size())];
            System.out.println("What is the capital of " + guessState + "?");
            String capitalGuessed = myScanner.nextLine();
            // retrives the capital the user needs to guess
            String capitalToGuess = capitals.get(guessState);
            // gets rid of the backslash that for some reason is loaded in
            // on the file, probably better to do this earlier for each value
            // but don’t need to print out values for this exercise
            capitalToGuess = capitalToGuess.replace("\\", "");
            // if guess is the same as the value that goes along with the key
            if (capitalGuessed.equals(capitalToGuess)) {
                System.out.println("What a good guess!");
            // else give user the value with a comiseration message
            } else {
                System.out.println("No! It is " + capitalToGuess);
            }
        }
    }
}
         


