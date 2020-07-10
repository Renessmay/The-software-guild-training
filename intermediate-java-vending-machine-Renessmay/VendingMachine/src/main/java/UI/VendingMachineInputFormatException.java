/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Viktorija
 */

public class VendingMachineInputFormatException extends Exception{
    
    public VendingMachineInputFormatException(String msg) {
        
        super(msg);
    }

    public VendingMachineInputFormatException(String msg, Throwable cause) {
        
        super(msg, cause);
    }
}
