/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Viktorija
 */

public class VendingMachineInsufficientFundsException extends Exception{
    
    public VendingMachineInsufficientFundsException(String msg) {
        super(msg);
    }

    public VendingMachineInsufficientFundsException(String msg, Throwable cause) {
        super(msg, cause);
        
    }

    @Override
    public String toString(){
        return "InsuffFundsException thrown: ";
}
}
