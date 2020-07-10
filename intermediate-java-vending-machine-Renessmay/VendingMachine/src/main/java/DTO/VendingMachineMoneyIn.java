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

public class VendingMachineMoneyIn {
    //object properties, getters and setters and equals
    private BigDecimal moneyInMachine = new BigDecimal("0");

    public BigDecimal getMoneyInMachine() {
        return moneyInMachine;
    }

    public void setMoneyIn(String strMoneyIn) {

        this.moneyInMachine = new BigDecimal(strMoneyIn);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.moneyInMachine);
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
        final VendingMachineMoneyIn other = (VendingMachineMoneyIn) obj;
        if (!Objects.equals(this.moneyInMachine, other.moneyInMachine)) {
            return false;
        }
        return true;
    }
}
