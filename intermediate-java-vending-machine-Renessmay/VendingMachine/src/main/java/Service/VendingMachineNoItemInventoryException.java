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

public class VendingMachineNoItemInventoryException extends Exception{
    
    public VendingMachineNoItemInventoryException(String msg) {
        super(msg);
    }

    public VendingMachineNoItemInventoryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    @Override
    public String toString() {
        return "NoItemInvException thrown: ";
    }
    
}
