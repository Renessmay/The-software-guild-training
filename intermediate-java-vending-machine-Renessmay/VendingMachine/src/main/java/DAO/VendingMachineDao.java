/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.VendingMachineItem;
import java.util.List;

/**
 *
 * @author Viktorija
 */

public interface VendingMachineDao {
    
    //method to purchase from hashmap of items    
    VendingMachineItem buyItem(String itemName) throws VendingMachinePersistenceException;

    List<VendingMachineItem> getAllItems();

    VendingMachineItem removeItem(String itemName) throws VendingMachinePersistenceException;

    VendingMachineItem addToItem(VendingMachineItem item) throws VendingMachinePersistenceException;

    VendingMachineItem getItem(String itemName);

    VendingMachineItem addNewItem(VendingMachineItem itemToAdd) throws VendingMachinePersistenceException;
}
