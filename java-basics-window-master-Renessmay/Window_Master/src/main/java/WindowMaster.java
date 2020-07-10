
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
public class WindowMaster {
    
    public static void main(String[] args){
        
        float height;
        float width;
        float window;
        float trim;
        float windowsnumber;
        
        String stringHeight;
        String stringWidth;
        String costWindow;
        String costTrim;
        String WindowNr;
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        float totalcost;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Please enter window height: ");
        stringHeight = myScanner.nextLine();
        
        System.out.println("Please enter window width: ");
        stringWidth = myScanner.nextLine();
        
        System.out.println("Please enter number of windows: ");
        WindowNr = myScanner.nextLine();
        
        System.out.println("Please enter cost of window: ");
        costWindow = myScanner.nextLine();
        
        System.out.println("Please enter cost of trim: ");
        costTrim = myScanner.nextLine();


        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        window = Float.parseFloat(costWindow);
        trim = Float.parseFloat(costTrim);
        windowsnumber = Float.parseFloat(WindowNr);
        
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        
        cost = ((window * areaOfWindow) + (trim * perimeterOfWindow));
        
        totalcost = cost * windowsnumber;
        
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Number of windows = " + WindowNr);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + totalcost);
        
        /*
        try {
            stringHeight = myScanner.readLine();
            height = Float.parseFloat(stringHeight);
            
        }
        catch(NumberFormatException ex){
            System.out.println("Input is invalid");
        }
        */
    }
    
}
