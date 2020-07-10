/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.Order;
import dto.Product;
import dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Viktorija
 */
public class FlooringMasteryView {
    UserIO io;
    
    public FlooringMasteryView(UserIO io){
        this.io = io;
    }
    
    //menu selections
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. View an Order");
        io.print("6. Save Current Work");
        io.print("7. Export all Orders");   
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }
    
    //formatter for date
    public LocalDate dateInput(String date){        
            if(date.length() == 0)
            {
                return null;
            }
            String[] dateParts = date.split("-");
            LocalDate dateNow = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1])); //YYYY, MM, DD

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String tempdate = dateNow.format(dateFormat);

            LocalDate orderDate = LocalDate.parse(tempdate, dateFormat);

            return orderDate;   
    }
    
    //add order
    public Order getNewOrderInfo() {
        Order currentOrder = new Order();
        BigDecimal area = new BigDecimal(0);
        
        String customerName = io.readString("Please enter name of customer");
        if(customerName.equals("")){
            customerName = io.readString("Please enter name of customer to proceed");
        }
        String state = io.readString("Please enter state");
        if(state.equals("")){
            state = io.readString("Please enter state to proceed");
        }
        String productType = io.readString("Please enter the type of product ordered");
        if(productType.equals("")){
            productType = io.readString("Please enter the type of product ordered to proceed");
        }
        String areaInput = io.readString("Please enter area");
        if(areaInput.equals("") || areaInput.equals("0")){
            area = io.readBigDecimal("Please enter area to proceed");
        } else {
            area = new BigDecimal(areaInput);
        }
        LocalDate date = dateInput(io.readString("Please enter date of order (ex. 12-20-2016)"));
        if(date == null){
            date = dateInput(io.readString("Please enter date of order (ex. 12-20-2016) to proceed"));
        }
        
        int orderNum = currentOrder.getOrderNum();
        
        Tax taxData = new Tax();
        BigDecimal stateTax = taxData.getStateTax();
        
        Product productData = new Product();
        BigDecimal costPerSqFoot = productData.getCostPerSqFoot();
        BigDecimal laborCostPerSqFoot = productData.getLaborCostPerSqFoot();
        BigDecimal materialCost = currentOrder.getMaterialCost();
        BigDecimal laborCost = currentOrder.getLaborCost();
        BigDecimal tax = currentOrder.getTax();
        BigDecimal total = currentOrder.getTotal();
        
        currentOrder.setOrderNum(orderNum);
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setStateTax(stateTax);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        currentOrder.setCostPerSqFoot(costPerSqFoot);
        currentOrder.setLaborCostPerSqFoot(laborCostPerSqFoot);
        currentOrder.setMaterialCost(materialCost);
        currentOrder.setLaborCost(laborCost);
        currentOrder.setTax(tax);
        currentOrder.setTotal(total);
        currentOrder.setDate(date);
        
        return currentOrder;
    }
    
    public void displayAddOrderBanner() {
        io.print("=== Add Order ===");
    }
    
    public void displayAddSuccessBanner() {
        io.readString("Order successfully added.  Please hit enter to continue");
    }
    
    //get orders
    public void displayGetOrderBanner () {
        io.print("=== Display Order ===");
    }
    
    public int getOrderNumChoice() {
        int orderNum = io.readInt("Please enter the order number.");
        if(orderNum == 0){
            orderNum = io.readInt("Please enter the order number to proceed.");
        }
        return orderNum;
    }
    
    public LocalDate getOrderDate(){
        LocalDate date = dateInput(io.readString("Please enter date of order (ex. 12-20-2016)"));
        if(date == null){
            date = dateInput(io.readString("Please enter date of order (ex. 12-20-2016) to proceed"));
        }
        return date;
    }
    
    public void displayOrder(Order order) {    
        if (order != null) {
            io.print("Order number: " + Integer.toString(order.getOrderNum()));
            io.print("Customer name: " + order.getCustomerName());
            io.print("State: " + order.getState());
            io.print("State tax: $" + order.getStateTax().toString());
            io.print("Product: " + order.getProductType());
            io.print("Area: " + order.getArea().toString() + "sq ft");
            io.print("Cost: $" + order.getCostPerSqFoot().toString() + " /sq ft");
            io.print("Labor cost: $" + order.getLaborCostPerSqFoot().toString() + "/sq ft");
            io.print("Material cost: $" + order.getMaterialCost().toString());
            io.print("Total labor cost: $" + order.getLaborCost().toString());
            io.print("Total tax: $" + order.getTax().toString());
            io.print("TOTAL: $" + order.getTotal().toString());
            io.print("Date order was entered: " + order.getDate().toString());
            io.print("");
        } else {
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    //display all Orders
    public void displayOrderList(List<Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print("Order number: " + currentOrder.getOrderNum() + " | "
                    + "customer name: " + currentOrder.getCustomerName() + " | "
                    + "state: " + currentOrder.getState() + " | "
                    + "state tax: $" + currentOrder.getStateTax() + " | "
                    + "product type: " + currentOrder.getProductType() + " | "
                    + "area: " + currentOrder.getArea().toString() + "sq ft | "
                    + "cost: $" + currentOrder.getCostPerSqFoot().toString() + "/sq ft | "
                    + "labor cost: $" + currentOrder.getLaborCostPerSqFoot().toString() + "/sq ft | "
                    + "material cost: $" + currentOrder.getMaterialCost().toString() + "/sq ft | "
                    + "labor cost: $" + currentOrder.getLaborCost().toString() + " | "
                    + "total tax: $" + currentOrder.getTax().toString() + " | "
                    + "total: $" + currentOrder.getTotal().toString() + " | "
                    + "date: " + currentOrder.getDate().toString());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Orders ===");
    }
    
    //remove orders
    public void displayRemoveOrderBanner () {
        io.print("=== Remove Order ===");
    }

    public void displayRemoveSuccessBanner () {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }
    
    //edit order    
    public Order editOrder(Order order){
        io.print("Hit enter to skip to the next line.");
        int orderNum = order.getOrderNum();
        LocalDate dateUserInput = order.getDate();
        String customerName = io.readString("Enter customer name " + "(" + order.getCustomerName() + "):");
        String state = io.readString("Enter state " + "(" + order.getState() + "):");
        String productType = io.readString("Enter product type " + "(" + order.getProductType() + "):");
        LocalDate date = dateInput(io.readString("Enter date of order " + "(" + order.getDate() + "):"));
        
        order.setOrderNum(orderNum);
        if(customerName.equals(order.getCustomerName()) || customerName.length() == 0){
            order.getCustomerName();
        } else {
            order.setCustomerName(customerName);
        }
        if(state.equals(order.getState()) || state.length() == 0){
            order.getState();
        } else {
            order.setState(state);
        }
        if(productType.equals(order.getProductType()) || productType.length() == 0){
            order.getProductType();
        } else {
           order.setProductType(productType); 
        }
        if(date == null){
            order.setDate(order.getDate());
        } else {
            order.setDate(date);
        }
       
        return order;
    }
    
    public void displayEditOrderBanner () {
        io.print("=== Editing Order ===");
    }

    public void displayEditSuccessBanner () {
        io.readString("Order successfully updated. Please hit enter to continue.");
    }
    
    //save current work
    public void displaySaveWorkBanner() {
        io.print("=== Saving Current Work ===");
    }
    
    public void displaySaveWorkSuccessBanner() {
        io.readString("Current work successfully saved.  Please hit enter to continue");
    }
    
    public String displaySaveWorkResponse(){
        String response = io.readString("Please enter y/n to save current work."
                + " If you select no, you will be returned to the main menu.");
        if(response.equals("")){
            response = io.readString("Please enter y/n to proceed and return to the main menu.");
        }
        return response;
    }
    
    public void displayNoSavedWork(){
        io.readString("Work will not be saved. Please hit enter to continue.");
    }
    
    public void displayExportOrdersBanner(){
        io.print("=== Exporting Orders ===");
    }
    public void displayExportOrdersSuccessBanner(){
        
        io.readString("Orders successfully exported. Please hit enter to continue.");
    }
    
    //unknown, error and exit banners
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
