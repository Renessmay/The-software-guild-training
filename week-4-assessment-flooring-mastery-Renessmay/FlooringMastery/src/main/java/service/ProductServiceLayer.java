/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FlooringMasteryPersistenceException;
import dao.NoSuchProductException;
import java.math.BigDecimal;

/**
 *
 * @author Viktorija
 */
public interface ProductServiceLayer {
    
    void loadProductData() throws FlooringMasteryPersistenceException;
    BigDecimal setMaterialCost(String productType) throws FlooringMasteryPersistenceException, NoSuchProductException;
    BigDecimal setLaborCost(String productType) throws FlooringMasteryPersistenceException, NoSuchProductException;
}
