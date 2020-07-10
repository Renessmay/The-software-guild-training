/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class MenuOfChampions {
    public static void main(String[] args){
        
        String dish1 = "Slice of Big Rico Pizza";
        String dish2 = "Invisible Strawberry Pie";
        String dish3 = "Denver Omelet";
        
        String price1 = String.format("%.2f", 500.00);
        String price2 = String.format("%.2f", 2.00);
        String price3 = String.format("%.2f", 1.50);
        
        System.out.println("=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n" );
        System.out.println("            WELCOME TO RESTAURANT NIGHT VALE!");
        System.out.println("                Today's Menu Is...\n");
        System.out.println("=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n" );
        System.out.println("            $ " + price1 + " *** " + dish1);
        System.out.println("            $ " + price2 + " ***** " + dish2);
        System.out.println("            $ " + price3 + " ***** " + dish3);
    }
}
