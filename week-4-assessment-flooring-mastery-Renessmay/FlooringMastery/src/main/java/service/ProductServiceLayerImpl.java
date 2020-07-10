/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FlooringMasteryPersistenceException;
import dao.NoSuchProductException;
import dao.ProductDao;
import java.math.BigDecimal;

/**
 *
 * @author Viktorijaija
 */
public class ProductServiceLayerImpl implements ProductServiceLayer {
    
    ProductDao productDao;

    public ProductServiceLayerImpl(ProductDao dao) {
        this.productDao = dao;
    }

    public ProductServiceLayerImpl() {
        
    }

    @Override
    public void loadProductData() throws FlooringMasteryPersistenceException {
        productDao.loadProductData();
    }

    @Override
    public BigDecimal setMaterialCost (String productType) throws FlooringMasteryPersistenceException, NoSuchProductException {
        boolean correctProductType = productDao.validateUserProductData(productType);
        if(!correctProductType){
            throw new NoSuchProductException("NoSuchProductException: This product is not available.");
        } else {
            return productDao.readMaterialCostByProductType(productType);
        }
    }
    
    @Override
    public BigDecimal setLaborCost (String productType) throws FlooringMasteryPersistenceException, NoSuchProductException {
        boolean correctProductType = productDao.validateUserProductData(productType);
        if(!correctProductType){
            throw new NoSuchProductException("NoSuchProductException: This product is not available.");
        } else {
            return productDao.readLaborCostByProductType(productType);
        }
    }
}
