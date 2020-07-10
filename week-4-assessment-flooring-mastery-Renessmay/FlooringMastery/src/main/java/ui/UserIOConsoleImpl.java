/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Viktorija
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner userInput = new Scanner(System.in);
    
    @Override
    public void print(String message){
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        double numInput = Double.parseDouble(input);
        
        return numInput; 
    }

    @Override
    public double readDouble(String prompt, double min, double max){
       // boolean incorrectRange = true;
        double userNum = 0;
        
            System.out.println(prompt);
            String input = userInput.nextLine();
            userNum = Double.parseDouble(input);
            
        while(userNum < min || userNum > max){
            
            if(userNum < min || userNum > max){
                System.out.println("Please input the correct number");
                input = userInput.nextLine();
                userNum = Double.parseDouble(input);
              //  incorrectRange = true;
            } 
            
        }
        return userNum; 
    }
    
    @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        int numInput = Integer.parseInt(input);
        
        return numInput;
    }

    @Override
    public int readInt(String prompt, int min, int max){
       // boolean incorrectRange = true;
        int userNum = 0;
        
      
            System.out.println(prompt);
            String input = userInput.nextLine();
        
            userNum = Integer.parseInt(input);
         while(userNum < min || userNum > max){
             
            if(userNum < min || userNum > max){
                System.out.println("Please input the correct number");
                input = userInput.nextLine();
        
                userNum = Integer.parseInt(input);
          
            
            }
        }
        
        return userNum;
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        return input;
    }
    
    @Override
    public long readLong(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        long numInput = Long.parseLong(input);
        
        return numInput;
    }

    @Override
    public long readLong(String prompt, long min, long max){
        boolean incorrectRange = true;
        long userNum = 0;
        
            System.out.println(prompt);
            String input = userInput.nextLine();
        
            userNum = Long.parseLong(input);
        while(userNum < min || userNum > max){
             
            if(userNum < min || userNum > max){
                System.out.println("Please input the correct number");
           
                input = userInput.nextLine();
        
                userNum = Long.parseLong(input);
                incorrectRange = true;
           
            }
        }
        
        return userNum;
    }
    
    @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        float numInput = Float.parseFloat(input);
        
        return numInput;
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        boolean incorrectRange = true;
        float userNum = 0;
        
  
            System.out.println(prompt);
            String input = userInput.nextLine();
        
            userNum = Float.parseFloat(input);
         while(userNum < min || userNum > max){
             
            if(userNum < min || userNum > max){
                System.out.println("Please input the correct number");
           
            
                input = userInput.nextLine();
        
                userNum = Float.parseFloat(input);
                incorrectRange = true;
            
            }
        }
        
        return userNum;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        boolean incorrectRange = true;
        BigDecimal userNum = new BigDecimal(0);
        
        while(incorrectRange){
            System.out.println(prompt);
            String input = userInput.nextLine();
        
            userNum = new BigDecimal(input);
        
            if(userNum.compareTo(min) < 0){
                System.out.println(prompt);
                input = userInput.nextLine();
        
                userNum = new BigDecimal(input);
                incorrectRange = true;
            } else if(userNum.compareTo(max) > 0){
                System.out.println(prompt);
                input = userInput.nextLine();
        
                userNum = new BigDecimal(input);
                incorrectRange = true;
            } 
            
        }
        
        return userNum;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        BigDecimal numInput = new BigDecimal(input);
        
        return numInput;
    }
}
