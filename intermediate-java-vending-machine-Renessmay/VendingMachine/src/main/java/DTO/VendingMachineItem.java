/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Viktorija
 */

public class VendingMachineItem {
    //object properties, getters and setters, equals and hashcode for unit testing
    private String name;
    private int numInStock;
    private BigDecimal price;

    public VendingMachineItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }
// changed this setter to use BigDecimal string constructor.

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + this.numInStock;
        hash = 41 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendingMachineItem other = (VendingMachineItem) obj;
        if (this.numInStock != other.numInStock) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item: " + name + " |Amount available: " + numInStock + " |Price: " + price;
    }
    
}
