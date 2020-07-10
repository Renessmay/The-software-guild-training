/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.VendingMachineItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Viktorija
 */

public class VendingMachineFileImpl implements VendingMachineDao{
    
     private Map<String, VendingMachineItem> itemsMap = new HashMap<>();

    public static final String VENDING_FILE = "ItemList.txt";
    public static final String DELIMITER = "::";

    public VendingMachineFileImpl() throws VendingMachinePersistenceException {
        
        loadFile();

    }

    @Override
    public VendingMachineItem buyItem(String itemName) throws VendingMachinePersistenceException {
        VendingMachineItem itemToBuy = itemsMap.get(itemName);

        int newNumOf = (itemToBuy.getNumInStock() - 1);
        updateItemStock(itemName, newNumOf);

        writeFile();
        return itemToBuy;
    }

    @Override
    public List<VendingMachineItem> getAllItems() {
        return new ArrayList<VendingMachineItem>(itemsMap.values());
    }

    @Override
    public VendingMachineItem removeItem(String itemName) throws VendingMachinePersistenceException {
        VendingMachineItem toRemove = itemsMap.get(itemName);

        itemsMap.remove(toRemove.getName());

        writeFile();
        return toRemove;
    }

    @Override
    public VendingMachineItem addToItem(VendingMachineItem itemToAdd) throws VendingMachinePersistenceException {
        VendingMachineItem itemInMap = itemsMap.get(itemToAdd.getName());

        int calcNumOf = itemInMap.getNumInStock() + itemToAdd.getNumInStock();

        updateItemStock(itemToAdd.getName(), calcNumOf);
        writeFile();
        return itemToAdd;
    }

    @Override
    public VendingMachineItem addNewItem(VendingMachineItem itemToAdd) throws VendingMachinePersistenceException {

        itemsMap.put(itemToAdd.getName(), itemToAdd);
        writeFile();
        return itemToAdd;
    }

    @Override
    public VendingMachineItem getItem(String itemName) {
        VendingMachineItem item = itemsMap.get(itemName);
        return item;
    }

    private int updateItemStock(String itemName, int calcdNumOf) {
        VendingMachineItem item = itemsMap.get(itemName);
        item.setNumInStock(calcdNumOf);

        itemsMap.replace(itemName, item);
        return itemsMap.get(itemName).getNumInStock();
    }

    private void loadFile() throws VendingMachinePersistenceException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("error", e);

        }
        String currentLine;
        String[] currentTokens;

        while (sc.hasNext()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            VendingMachineItem current = new VendingMachineItem(currentTokens[0]);
            int numOf = Integer.parseInt(currentTokens[1]);
            current.setNumInStock(numOf);
            current.setPrice(currentTokens[2]);

            itemsMap.put(current.getName(), current);

        }
        sc.close();
    }

    private void writeFile() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("No file to save to", e);
        }

        List<VendingMachineItem> list = this.getAllItems();

        for (VendingMachineItem i : list) {
            out.println(i.getName()
                    + DELIMITER
                    + String.valueOf(i.getNumInStock())
                    + DELIMITER
                    + i.getPrice().toString());

            out.flush();
        }
        out.close();
}
}
