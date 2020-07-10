/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.VendingMachineItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Viktorija
 */

public class VendingMachineDaoStubImpl implements VendingMachineDao{
    
       private Map<String, VendingMachineItem> itemsMap = new HashMap<>();
    VendingMachineItem only;

     public VendingMachineDaoStubImpl()  {
        only = new VendingMachineItem("Chicas");
        only.setNumInStock(3);
        only.setPrice("8.00");
        itemsMap.put(only.getName(), only);

    }

    //purchase method
    @Override
    public VendingMachineItem buyItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public List<VendingMachineItem> getAllItems() {
        return new ArrayList<VendingMachineItem>(itemsMap.values());
    }

    @Override
    public VendingMachineItem removeItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public VendingMachineItem getItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public VendingMachineItem addToItem(VendingMachineItem itemToAdd) {
        if (only.getName().equals(itemToAdd.getName())) {
            int currentNum = only.getNumInStock();
            int numToAdd = itemToAdd.getNumInStock();
            VendingMachineItem onlyUpdated = only;

            only.setNumInStock(numToAdd + currentNum);

            return onlyUpdated;
        } else {
            return only;
        }

    }

    @Override
    public VendingMachineItem addNewItem(VendingMachineItem itemToAdd) {
        if (only.getName().equals(itemToAdd.getName())) {
            return only;
        } else {
            return null;
        }
    }
    
}
