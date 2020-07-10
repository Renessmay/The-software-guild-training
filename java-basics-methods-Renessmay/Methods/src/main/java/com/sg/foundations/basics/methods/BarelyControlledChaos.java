/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
package com.sg.foundations.basics.methods;

import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = acolor(); // call color method here
        String animal = aanimal(); // call animal method again here
        String colorAgain = acolor(); // call color method again here
        int weight = anumber(); // call number method,
            // with a range between 5 - 200 
        int distance = anumber(); // call number method,
            // with a range between 10 - 20
        int number = anumber(); // call number method,
            // with a range between 10000 - 20000
        int time = anumber(); // call number method,
            // with a range between 2 - 6        
            
            
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    public static String acolor(){
    Random color = new Random();
    
    String[] names= new String[] {"blue", "yellow", "black", "purple", "red"};
    int randomIndex = color.nextInt(names.length);
    String randomName = names[randomIndex];
    return randomName;
        
    
    }
    public static String aanimal(){
        Random animal = new Random();

        String[] names= new String[] {"orangutan", "bald eagle", "chameleon", "squirrel", "canary"};
        int randomIndex = animal.nextInt(names.length);
        String randomName = names[randomIndex];
         return randomName;
        
    }
    public static int anumber(){
        
        Random mynumber = new Random();

        int rnumber = mynumber.nextInt(20000)+3;

        return rnumber;
        
    }
}