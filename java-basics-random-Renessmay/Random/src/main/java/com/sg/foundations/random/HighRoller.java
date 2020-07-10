/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
package com.sg.foundations.random;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {
        
        String usernr;
        int user;

        Random diceRoller = new Random();

        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please enter the number: ");
        usernr=inputReader.next();
        user=Integer.parseInt(usernr);
                int rollResult = diceRoller.nextInt(user) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        else if(rollResult ==6){
            System.out.println("You rolled a critical! Nice job!");
        }
    }
}