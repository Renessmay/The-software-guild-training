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

public interface VendingMachineAuditDao {
    //writes to audit file
    void writeAudit(String entry) throws VendingMachinePersistenceException;

    void writeAuditExc(String itemReq, Exception exc) throws VendingMachinePersistenceException;
}
