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

public class VendingMachineDataValidationException extends Exception{
    
      public VendingMachineDataValidationException(String msg) {
        super(msg);
    }

    public VendingMachineDataValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
