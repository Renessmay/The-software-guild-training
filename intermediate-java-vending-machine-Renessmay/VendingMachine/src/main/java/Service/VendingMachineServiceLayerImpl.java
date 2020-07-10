/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.VendingMachineDao;
import DAO.VendingMachinePersistenceException;
import DTO.VendingMachineChange;
import DTO.VendingMachineItem;
import DTO.VendingMachineMoneyIn;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Viktorija
 */

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    
    private VendingMachineDao dao;
    
    private VendingMachineMoneyIn moneyInMachine = new VendingMachineMoneyIn();

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;

    }

    @Override
    public VendingMachineChange buyItem(String itemName, BigDecimal monies)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInventoryException {

        VendingMachineItem itemToBuy = dao.getItem(itemName);

        if (itemToBuy == null) {
            throw new VendingMachineNoItemInventoryException("No item exists in vending machine.");
        } else if ((itemToBuy.getNumInStock() == 0)) {

            throw new VendingMachineNoItemInventoryException("Out of stock!!");
        } else {
            BigDecimal price = itemToBuy.getPrice();

            if (monies.compareTo(price) >= 0) {

                dao.buyItem(itemName);
                resetMoney();
                return calcChange(monies, price);

            } else {
                throw new VendingMachineInsufficientFundsException("Not enough funds added.");

            }

        }
    }

    @Override
    public List<VendingMachineItem> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public VendingMachineItem removeItems(String itemName)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInventoryException {

        VendingMachineItem found = dao.getItem(itemName);

        if (found != null) {
            dao.removeItem(itemName);
            return found;
        } else {
            throw new VendingMachineNoItemInventoryException("No item exists to remove.");
        }
    }

    @Override
    public int addItem(VendingMachineItem item) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        validateItem(item);

        VendingMachineItem found = dao.getItem(item.getName());

        if (found == null) {

            dao.addNewItem(item);
            return item.getNumInStock();
        } else {
            
            dao.addToItem(item);
            return dao.getItem(item.getName()).getNumInStock();

        }

    }

    @Override
    public VendingMachineChange calcChange(BigDecimal monies, BigDecimal price) {

        BigDecimal initChange = monies.subtract(price);
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal calcChange = initChange.multiply(hundred);
        BigDecimal formatChange = calcChange.setScale(0);

        String strChange = formatChange.toString();
        Integer change = Integer.parseInt(strChange);

        Integer quarters = 0;
        Integer dimes = 0;
        Integer nickels = 0;
        Integer pennies = 0;
        Integer remainder = 0;

        if ((change / 25) >= 1) {
            quarters = change / 25;
            remainder = change % 25;

            if ((remainder / 10) >= 1) {
                dimes = remainder / 10;
                remainder = remainder % 10;

            }
            if ((remainder / 5) >= 1) {
                nickels = remainder / 5;
                remainder = remainder % 5;
            }

        } else if ((change / 10) >= 1) {
            dimes = change / 10;
            remainder = change % 10;

            if ((remainder / 5) >= 1) {
                nickels = remainder / 5;
                remainder = remainder % 5;
            }

        } else if ((change / 5) >= 1) {
            nickels = change / 5;
            remainder = change % 5;

        } else {
            remainder = change;
        }

        pennies = remainder;

        VendingMachineChange changeToReturn = new VendingMachineChange();

        changeToReturn.setQuarter(quarters);

        changeToReturn.setDime(dimes);

        changeToReturn.setNickel(nickels);

        changeToReturn.setPenny(pennies);

        return changeToReturn;
    }

    @Override
    public VendingMachineItem getItem(String itemName) throws VendingMachineNoItemInventoryException {
        VendingMachineItem found = dao.getItem(itemName);

        if (found != null) {
            return found;
        } else {
            throw new VendingMachineNoItemInventoryException("No item exists.");
        }
    }

    private void validateItem(VendingMachineItem item)
            throws VendingMachineDataValidationException {

        Integer numInStock = item.getNumInStock();
        BigDecimal price = new BigDecimal("0");
        price = item.getPrice();
        String strPrice = price.toString();

        if (item.getName() == null
                || item.getName().trim().length() == 0
                || numInStock == null
                || numInStock == 0
                || strPrice == null
                || strPrice.trim().length() == 0
                || strPrice == "0") {

            throw new VendingMachineDataValidationException("All fields are required and cannot be zero.");

        }

    }

    @Override
    public String addToMoney(BigDecimal money) {

        BigDecimal currentMoney = moneyInMachine.getMoneyInMachine();
        BigDecimal newMoney = money;

        BigDecimal total = currentMoney.add(newMoney);
        String strTotal = total.toString();
        moneyInMachine.setMoneyIn(strTotal);

        return moneyInMachine.getMoneyInMachine()
                .toString();
    }

    private void resetMoney() {
        String reset = "0";
        moneyInMachine.setMoneyIn(reset);
    }

    @Override
    public BigDecimal getCurrentMoney() {
        return moneyInMachine.getMoneyInMachine();
    }

}
