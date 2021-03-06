/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.advice;

import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Viktorija
 */
public class loggingAdvice {
 ClassRosterAuditDao auditDao;
 
    public loggingAdvice(ClassRosterAuditDao audit){
    this.auditDao = audit;
}
    
public void createAuditEntry(JoinPoint jp){
    Object[] args = jp.getArgs();
    
    String auditEntry = jp.getSignature().getName() + ": ";
    
    for (Object currentArg: args){
        auditEntry += currentArg;
    }
    
    try{
        auditDao.writeAuditEntry(auditEntry);
    } catch (ClassRosterPersistenceException e) {
        System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
    }
    
    
}    
}
