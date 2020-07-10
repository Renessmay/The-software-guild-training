
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
public class GuessMe {
    public static void main(String[] args) {
        
        int mynumber = 13;
        String usernumber;
        int usernr;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("I've chosen a number. Betcha can't guess it!\n");
        System.out.print("Your guess: ");
        usernumber = inputReader.next();
        usernr = Integer.parseInt(usernumber);
        
        if(usernr<mynumber){
            System.out.println("Ha, nice try - too low! I chose "+mynumber+ ".");
           
        }
        if(usernr==mynumber){
            System.out.println("Wow, nice guess! That was it!");
        }
        if(usernr>mynumber){
            System.out.println("Too bad, way too high. I chose " +mynumber+".");
        }
    }
}
