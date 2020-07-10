/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Viktorija
 */
public interface OrderDao {
    List<Order> getAllOrders() throws FlooringMasteryPersistenceException;
    Order addOrder(int orderNum, Order order) throws FlooringMasteryPersistenceException;
    Order getOrder(int orderNum, LocalDate date) throws FlooringMasteryPersistenceException;
    Order editOrder(int orderNum, Order order) throws FlooringMasteryPersistenceException;
    Order removeOrder(int orderNum) throws FlooringMasteryPersistenceException;
    void loadOrderData() throws FlooringMasteryPersistenceException;
    int generateOrderNum(Order order) throws FlooringMasteryPersistenceException;
}
