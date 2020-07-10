/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Viktorija
 */

public class VendingMachinePersistenceException extends Exception{
    public VendingMachinePersistenceException(String msg) {
        super(msg);
    }

    public VendingMachinePersistenceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
