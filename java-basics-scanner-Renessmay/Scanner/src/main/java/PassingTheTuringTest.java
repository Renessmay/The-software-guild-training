
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
public class PassingTheTuringTest {
    public static void main(String[] args){
        
        String name;
        String favcolor;
        String food;
        String number;
        
        float numberflt;
        float sum;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Hello there!\nWhat is your name?");
        name = inputReader.next();
        
        System.out.print("Hi, "+name+"! I'm Ava.\nWhat's your favorite color?");
        favcolor = inputReader.next();
        
        System.out.println("Huh, "+favcolor+"? Mine's Electric Blue!\n");
        System.out.print("I really like watermelons. They're my favorite fruit, too.\n"
                + "What's your favorite fruit, "+name+"?");
        food = inputReader.next();
        
        System.out.println("Really? "+food+"? That's wild!\nSpeaking of favorites, what's your favorite number?");
        number = inputReader.next();
        
        numberflt = Float.parseFloat(number);
        
        sum = numberflt * 13;
        
        System.out.println(number+" is a cool number. Mine is 13.\nDid you know "+number+" * 13 is "+sum+"? That's a cool number too!");
        
        System.out.println("Well, thanks for talking to me, "+name+"!");
               
        
        
    }
    
}
