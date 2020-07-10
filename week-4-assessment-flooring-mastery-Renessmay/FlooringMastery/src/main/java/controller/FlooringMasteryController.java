/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FlooringMasteryPersistenceException;
import dao.NoSuchProductException;
import dao.NoSuchStateException;
import dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.tools.ajc.Main;
import service.FlooringMasteryDataValidationException;
import service.OrderServiceLayer;
import service.ProductServiceLayer;
import service.TaxServiceLayer;
import ui.FlooringMasteryView;

/**
 *
 * @author Viktorija
 */
public class FlooringMasteryController {
    FlooringMasteryView view;
    private OrderServiceLayer service;
    private TaxServiceLayer taxService;
    private ProductServiceLayer productService;
    
    public FlooringMasteryController(FlooringMasteryView view, OrderServiceLayer service, TaxServiceLayer taxService, ProductServiceLayer productService){
        this.service = service;
        this.view = view;
        this.taxService = taxService;
        this.productService = productService;
    }

    public void run() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, FileNotFoundException, IOException {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {
                try{
                menuSelection = getMenuSelection();
                     } catch (NumberFormatException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                     }
                switch (menuSelection) {
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        try {
                        addOrder();
                        } catch (NoSuchStateException e) {
                            view.displayErrorMessage(e.getMessage());
                        } catch (NoSuchProductException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                        editOrder();
                        } catch (NoSuchStateException e) {
                            view.displayErrorMessage(e.getMessage());
                        } catch (NoSuchProductException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        viewOrder();
                        break;
                    case 6:
                        saveCurrentWork();
                        break;
                    case 7:
                        exportOrders();
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                    }
                }
            exitMessage();
        } catch (FlooringMasteryPersistenceException e) {
                view.displayErrorMessage(e.getMessage());
            }
    }

    //menu selections
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //add order
    private void addOrder() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, NoSuchStateException, NoSuchProductException {
        
        view.displayAddOrderBanner();
        
        Order newOrder = view.getNewOrderInfo();
        
        //load tax and product data
        taxService.loadTaxData();
        productService.loadProductData();
        
        //calculate costs
        BigDecimal stateTax = taxService.validateUserTaxData(newOrder.getState());
        newOrder.setStateTax(stateTax);
        
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(newOrder.getProductType());
        newOrder.setCostPerSqFoot(materialCostPerSqFoot);
        
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(newOrder.getProductType());
        newOrder.setLaborCostPerSqFoot(laborCostPerSqFoot);
        
        BigDecimal laborCost = service.calculateLaborCost(newOrder);
        newOrder.setLaborCost(laborCost);
        
        BigDecimal materialCost = service.calculateMaterialCost(newOrder);
        newOrder.setMaterialCost(materialCost);
        
        BigDecimal totalTax = service.calculateTax(newOrder);
        newOrder.setTax(totalTax);
        
        BigDecimal total = service.calculateTotal(newOrder);
        newOrder.setTotal(total);
        
        //generate order number
        int orderNum = service.generateOrderNumber(newOrder);
        newOrder.setOrderNum(orderNum);
        
        //show summary of order
        view.displayOrder(newOrder); 
        
        //check that user wants to save work
        String response = view.displaySaveWorkResponse();
        if(response.equals("y") || response.equals("Y")){
            view.displaySaveWorkBanner();
            service.addOrder(newOrder);
            view.displayAddSuccessBanner();
            service.saveCurrentWork(newOrder);
        } else {
            view.displayNoSavedWork();
            
            //save to hashmap if want to save later
            service.addOrder(newOrder);
        }
    }
    
    //search by order number / date
    private void viewOrder() throws FlooringMasteryPersistenceException {
        view.displayGetOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        view.displayOrder(order);
    }
    
    //list all orders
    private void listOrders() throws FlooringMasteryPersistenceException {
        view.displayDisplayAllBanner();
        List<Order> orderList = service.getAllOrders();
        view.displayOrderList(orderList);
    }
    
    //remove order
    private void removeOrder() throws FlooringMasteryPersistenceException, FileNotFoundException {
        
        //retrieve order that user would like to remove
        view.displayRemoveOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        view.displayOrder(order);
        
        //check that user wants to remove order
        String response = view.displaySaveWorkResponse();
        if(response.equals("y") || response.equals("Y")){
            view.displaySaveWorkBanner();
            service.removeOrder(order.getOrderNum());
            service.removeOrderContent(order);
            view.displayRemoveSuccessBanner();
        } else {
            view.displayNoSavedWork();
        }
    }
   
    //edit order
    private void editOrder() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, NoSuchStateException, NoSuchProductException, FileNotFoundException {
        
        //retrieve order that user would like to edit
        view.displayEditOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        
        view.editOrder(order);
        
        //load tax and product data
        taxService.loadTaxData();
        productService.loadProductData();
        
        //calculate costs
        BigDecimal stateTax = taxService.validateUserTaxData(order.getState());
        order.setStateTax(stateTax);
        
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(order.getProductType());
        order.setCostPerSqFoot(materialCostPerSqFoot);
        
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(order.getProductType());
        order.setLaborCostPerSqFoot(laborCostPerSqFoot);
        
        BigDecimal laborCost = service.calculateLaborCost(order);
        order.setLaborCost(laborCost);
        
        BigDecimal materialCost = service.calculateMaterialCost(order);
        order.setMaterialCost(materialCost);
        
        BigDecimal totalTax = service.calculateTax(order);
        order.setTax(totalTax);
        
        BigDecimal total = service.calculateTotal(order);
        order.setTotal(total);
        
        //check that user wants to save updated work
        String response = view.displaySaveWorkResponse();
        if(response.equals("y") || response.equals("Y")){
            view.displaySaveWorkBanner();
            service.editOrder(order.getOrderNum(), order);
            service.removeOrderContent(order);
            service.saveCurrentWork(order);
            view.displayEditSuccessBanner();
        } else {
            view.displayNoSavedWork();
            
            //update hashmap in case want to save
            service.editOrder(order.getOrderNum(), order);
        } 
    }
    
    //save current work
    private void saveCurrentWork() throws FlooringMasteryPersistenceException {
        List<Order> orderList = service.getAllOrders();
        view.displaySaveWorkBanner();
        for(int i = 0; i < orderList.size(); ++i)
        {
            service.saveCurrentWork(orderList.get(i));
        }
        view.displaySaveWorkSuccessBanner();
    }
    
    private void exportOrders() throws FlooringMasteryPersistenceException, IOException{
        
        view.displayExportOrdersBanner();
        
        try(PrintWriter pw = new PrintWriter("D:\\Aspire\\Assignments\\github\\week-4-assessment-flooring-mastery-Renessmay\\FlooringMastery\\backup\\DataExport.txt")) {
            File f = new File("D:\\Aspire\\Assignments\\github\\week-4-assessment-flooring-mastery-Renessmay\\FlooringMastery\\orders");
            String[] s = f.list();
            if (s == null) {
                throw new IOException("Directory doesn't exist: " + f);
            }
            for (String s1 : s)
            {
                File f1 = new File(f, s1);
                if (!f1.isFile()) {
                    continue;
                }
                try (Reader reader = new FileReader(f1);
                        BufferedReader br = new BufferedReader(reader)) {
                    String line = br.readLine();
                    while (line != null)
                    {
                        pw.println(line);
                        line = br.readLine();
                    }
                }
            }
        } catch (Throwable e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }


            view.displayExportOrdersSuccessBanner();
        }
    
    
        
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
