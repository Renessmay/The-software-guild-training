/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viktorija
 */
public class OrderDaoFileImplStub implements OrderDao {
    Order onlyOrder;
    List<Order> allOrders = new ArrayList<>();
    
    public OrderDaoFileImplStub(){
        onlyOrder = new Order();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        onlyOrder = new Order(1);
        onlyOrder.setCustomerName("Viktorija");
        onlyOrder.setState("CA");
        onlyOrder.setStateTax(new BigDecimal(25.00));
        onlyOrder.setProductType("Wood");
        onlyOrder.setArea(new BigDecimal(20));
        onlyOrder.setCostPerSqFoot(new BigDecimal(2.25));
        onlyOrder.setLaborCostPerSqFoot(new BigDecimal(2.10));
        onlyOrder.setMaterialCost(new BigDecimal(20));
        onlyOrder.setLaborCost(new BigDecimal(40));
        onlyOrder.setTax(new BigDecimal(1.25));
        onlyOrder.setTotal(new BigDecimal(100));
        onlyOrder.setDate(LocalDate.parse("12/15/2015", df));
        
        allOrders.add(onlyOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order addOrder(int orderNum, Order order) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order getOrder(int orderNum, LocalDate date) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(int orderNum, Order order) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(int orderNum) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public void loadOrderData() {

    }

    @Override
    public int generateOrderNum(Order order) {
        return onlyOrder.getOrderNum();
    }
}
