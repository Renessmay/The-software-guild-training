
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
public class DoItBetter {
    public static void main(String[] args){
        
        String miles;
        String hotdogs;
        String lang;
        
        float miles1;
        float hotdogs1;
        float lang1;
        
        float milesbetter;
        float hotdogsbetter;
        float langbetter;
             
                
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("How many miles can you run? ");
        miles = inputReader.nextLine();
        miles1 = Float.parseFloat(miles); 
        milesbetter = miles1*2+1;
        System.out.println("Ha! I can run "+milesbetter+" miles! ");
                
        System.out.print("How many hot dogs can you eat?");
        hotdogs = inputReader.nextLine();
        hotdogs1 = Float.parseFloat(hotdogs);
        hotdogsbetter = hotdogs1*2+1;
        System.out.println("Ha! I can eat "+hotdogsbetter+" hotdogs! ");
        
        System.out.print("How many languages do you know?");
        lang = inputReader.nextLine();
        lang1 = Float.parseFloat(lang);
        langbetter = lang1*2+1;
        System.out.println("Ha! I can speak "+langbetter+" languages! ");
        
        
    }
    
    
}
