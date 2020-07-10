/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;

/**
 *
 * @author Viktorija
 */
public interface TaxDao {
    void loadTaxData()throws FlooringMasteryPersistenceException;
    boolean validateUserTaxData(String state) throws FlooringMasteryPersistenceException;
    BigDecimal setStateTax(String state) throws FlooringMasteryPersistenceException;
}
