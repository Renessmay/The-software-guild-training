/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendingMachinePersistenceException;
import DTO.VendingMachineChange;
import DTO.VendingMachineItem;
import Service.VendingMachineDataValidationException;
import Service.VendingMachineInsufficientFundsException;
import Service.VendingMachineNoItemInventoryException;
import Service.VendingMachineServiceLayer;
import UI.VendingMachineInputFormatException;
import UI.VendingMachineView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Viktorija
 */

public class VendingMachineController {
    
    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    // Main menu
    public void run() {
        String menuSell;

        boolean keepGoing = true;

        while (keepGoing) {
            menuSell = view.displayMainMenu();
            switch (menuSell) {
                case "1":
                    userPanel();
                    break;
                case "2":
                    keepGoing = false;
                    break;
                case "abc":
                    secretMenu();
                    break;
                default:
                    view.displayErrorMsg("Unknown command");
                    break;
            }
        }
        view.displayExitBanner();

    }

    // Secret menu
    private void secretMenu() {

        int ownerSelectn = 0;
        boolean hasErrors = false;
        boolean keepGoing = true;
        do {
            try {
                ownerSelectn = view.displaySecretMenu();
                hasErrors = false;

                switch (ownerSelectn) {
                    case 1:
                        addItem();
                        break;

                    case 2:
                        listAll();
                        break;
                    case 3:
                        removeItem();
                        break;
                    case 4:
                        hasErrors = false;
                        keepGoing = false;

                        break;
                }
            } catch (VendingMachineInputFormatException e) {
                hasErrors = true;
                view.displayErrorMsg(e.getMessage());
            }

        } while (hasErrors || keepGoing);
    }

    // user menu
    private void userPanel() {

        boolean hasErrors = false;

        VendingMachineChange change;

        List<VendingMachineItem> allItems = service.getAllItems();
        ArrayList<VendingMachineItem> orderedItems = new ArrayList<>(allItems);
        do {

            try {

                BigDecimal moneyFromConsumer = view.displayUserMenuItemsGetMoney(allItems, service.getCurrentMoney());

                service.addToMoney(moneyFromConsumer);
                VendingMachineItem itemSelected = view.getItemSelectn(orderedItems);

                if (itemSelected == null) {

                    view.printExitWithMoney(service.getCurrentMoney());
                    hasErrors = false;

                } else {

                    change = service.buyItem(itemSelected.getName(), service.getCurrentMoney());
                    hasErrors = false;

                    view.displayPurchaseSuccessBanner(itemSelected);
                    view.printChange(change);

                }

            } catch (VendingMachinePersistenceException | VendingMachineNoItemInventoryException | VendingMachineInsufficientFundsException | VendingMachineInputFormatException e) {
                hasErrors = true;
                view.displayErrorMsg(e.getMessage());
            }

        } while (hasErrors);
    }

    private void addItem() {
        view.displayAddBanner();

        try {
            VendingMachineItem itemToAdd = view.getItemToAdd();

            service.addItem(itemToAdd);

            view.displayAddSuccess(itemToAdd);

        } catch (VendingMachineInputFormatException | VendingMachinePersistenceException | VendingMachineDataValidationException e) {

            view.displayErrorMsg(e.getMessage());
        }

    }

    private void listAll() {
        List<VendingMachineItem> list = service.getAllItems();
        view.displayAllItems(list);

    }

    private void removeItem() {

        view.displayRemoveItemBanner();

        String mapKey = view.removeItem();
        try {
            service.removeItems(mapKey);
            view.displayRemoveItemSuccess();

        } catch (VendingMachinePersistenceException | VendingMachineNoItemInventoryException e) {

            view.displayErrorMsg(e.getMessage());
        }

    }
}
