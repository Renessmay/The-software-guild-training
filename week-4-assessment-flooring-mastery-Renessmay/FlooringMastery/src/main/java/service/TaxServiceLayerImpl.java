/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FlooringMasteryPersistenceException;
import dao.NoSuchStateException;
import dao.TaxDao;
import java.math.BigDecimal;

/**
 *
 * @author Viktorija
 */
public class TaxServiceLayerImpl implements TaxServiceLayer {
    
    TaxDao taxDao;

    public TaxServiceLayerImpl(TaxDao dao) {
        this.taxDao = dao;
    }

    public TaxServiceLayerImpl() {
        
    }

    @Override
    public void loadTaxData() throws FlooringMasteryPersistenceException {
        taxDao.loadTaxData();
    }

    @Override
    public BigDecimal validateUserTaxData(String state) throws FlooringMasteryPersistenceException, NoSuchStateException {
        boolean correctState = taxDao.validateUserTaxData(state);
        if(!correctState){
            throw new NoSuchStateException("NoSuchStateException: This state is not available.");
        } else {
            return taxDao.setStateTax(state);
        }
    }
}
