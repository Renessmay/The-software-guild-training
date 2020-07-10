/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.dao;

/**
 *
 * @author Viktorija
 */
public class ClassRosterPersistenceException extends Exception {
    
public ClassRosterPersistenceException(String msg) {
    super(msg);
}    

public ClassRosterPersistenceException (String msg, Throwable cause){
    super (msg, cause);
    
}
}
