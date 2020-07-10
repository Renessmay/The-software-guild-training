/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) { }
        } else if (action.equals("go to the house")) {
            System.out.println("In the house you see stairs leading upstairs and hallway to the kitchen.");
            System.out.println("Go upstairs or to the kitchen?");
            action = userInput.nextLine();
            if(action.equals("go upstairs")){
               System.out.println("You go upstairs and see long hallway and bedroom at the end of it.");
                System.out.println("Go back out or go to the bedroom?");
                action = userInput.nextLine();
                if(action.equals("go back out")){
                     System.out.println("You go back downstairs. You exit the house and go back to the open field.");
                }
                else if(action.equals("go to the bedroom")){
                     System.out.println("The room looks too creepy. You get scared and run out to the clearing.");
                }
            if(action.equals("go to the kitchen")){
                 System.out.println("The kitchen is old and abandoned. You get scared and run out to the clearing.");
            }
            }}      
                    
                
          }
        }
    
