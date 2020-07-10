
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
public class YourLifeInMovies {
    public static void main(String[] args) {

        String age;
        String name;
        int age1;

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Hey, let's play a game! What's your name? ");
        name = inputReader.next();

        System.out.print("Ok, "+name+", when were you born? ");
        age = inputReader.next();
        age1 = Integer.parseInt(age);

        System.out.println("Well "+name+"...");

        if(age1<2005){
            System.out.println("Did you know that that Pixar's 'Up' came out over a decade ago?");

        }
        if(age1<1995){
            System.out.println("Did you know that that the first Harry Potter came out over 15 years ago.");
        }
        if(age1<1985){
            System.out.println("Did you know that that Space Jam came out not last decade, but the one before THAT.");
        }

        if(age1<1975){
            System.out.println("Did you know that that the original Jurassic Park release is closer to the first lunar landing than it is to today.");
        }

        if(age1<1965){
            System.out.println("Did you know that that the MASH TV series has been around for almost half a century!");
        }
    }
}
