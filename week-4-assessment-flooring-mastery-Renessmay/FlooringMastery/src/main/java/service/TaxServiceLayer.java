/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FlooringMasteryPersistenceException;
import dao.NoSuchStateException;
import java.math.BigDecimal;

/**
 *
 * @author Viktorija
 */
public interface TaxServiceLayer {
    
    void loadTaxData() throws FlooringMasteryPersistenceException;
    BigDecimal validateUserTaxData(String state) throws FlooringMasteryPersistenceException, NoSuchStateException;
}
