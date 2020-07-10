
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
public class IO implements UserIO{
    Scanner in=new Scanner(System.in);
    String user;
    int userin;
    double useri;
    float userinp;
    long userint;
    
    @Override
    public void print(String message){
        
        System.out.println(message);
    }
    
    @Override
    public String readString(String prompt){
        
        System.out.println(prompt);
        user = in.next();
        return user;
    }
    
    @Override
    public int readInt(String prompt){
        
        System.out.println(prompt);
        do{
            try{
                user=in.next();
                userin=Integer.parseInt(user);
                return userin;
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid userin, please try again: ");
            }
        } while(true);
        
        }
    
    @Override
    public int readInt(String prompt, int min, int max){
        
        System.out.println(prompt);
        do {
            try {
                user=in.next();
                userin=Integer.parseInt(user);
                if (userin > min && userin < max) {
                    break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
        return userin;
    }
    
    @Override
    public double readDouble(String prompt){
        
         System.out.println(prompt);
        do {
            try {
                return Double.parseDouble(in.next());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
    }
    
    @Override   
    public double readDouble(String prompt, double min, double max){
        
        System.out.println(prompt);
        do {
            try {
                useri = Double.parseDouble(in.next());
                if (useri > min && useri < max) {
                    break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
        return useri;
    }
    
    @Override
    public float readFloat(String prompt){
        
           System.out.println(prompt);
        do {
            try {
                return Float.parseFloat(in.next());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
    }
    
    @Override
    public float readFloat(String prompt, float min, float max){
        
        System.out.println(prompt);
        do {
            try {
                userinp = Float.parseFloat(in.next());
                if (userinp > min && userinp < max) {
                    break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
        return userinp;
    }
    
    @Override
    public long readLong(String prompt){
         System.out.println(prompt);
        do {
            try {
                return Long.parseLong(in.next());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
    }
    
    @Override
    public long readLong(String prompt, long min, long max){
        
        long userint;
        System.out.println(prompt);
        do {
            try {
                userint = Long.parseLong(in.next());
                if (userint > min && userint < max) {
                    break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid userin: ");
            }
        } while(true);
        return userint;
    }
}
