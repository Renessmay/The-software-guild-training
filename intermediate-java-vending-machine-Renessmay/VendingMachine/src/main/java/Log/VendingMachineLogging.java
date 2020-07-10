/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import DAO.VendingMachineAuditDao;
import DAO.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Viktorija
 */

public class VendingMachineLogging {
        VendingMachineAuditDao audit;

    public VendingMachineLogging(VendingMachineAuditDao audit) {
        this.audit = audit;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();

        String auditEntry = jp.getSignature().getName() + ": ";

        for (Object currentArg : args) {
            auditEntry += " " + currentArg;
        }
        try {
            audit.writeAudit(auditEntry);

        } catch (VendingMachinePersistenceException e) {
            System.err.println("Error: could not create entry");
        }
    }

    public void createAuditExcEntry(JoinPoint jp, Exception exc) {
        Object[] args = jp.getArgs();

        String auditEntry = jp.getSignature().getName() + ": ";

        auditEntry += args[0];
        try {
            audit.writeAuditExc(auditEntry, exc);

        } catch (VendingMachinePersistenceException e) {
            System.err.println("Error: could not create entry");
        }
    }

    
}
