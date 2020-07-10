/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.VendingMachinePersistenceException;
import DTO.VendingMachineChange;
import DTO.VendingMachineItem;
import UI.VendingMachineInputFormatException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Viktorija
 */

public interface VendingMachineServiceLayer {
    
    VendingMachineChange buyItem(String itemName, BigDecimal monies) throws VendingMachineInsufficientFundsException, VendingMachinePersistenceException, VendingMachineNoItemInventoryException;

    List<VendingMachineItem> getAllItems();

    VendingMachineItem removeItems(String itemName) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException;

    int addItem(VendingMachineItem item) throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineInputFormatException;

    VendingMachineChange calcChange(BigDecimal monies, BigDecimal Price);

    VendingMachineItem getItem(String itemName) throws VendingMachineNoItemInventoryException;

    String addToMoney(BigDecimal money);

    BigDecimal getCurrentMoney();

}
