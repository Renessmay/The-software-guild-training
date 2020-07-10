/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayerTests;

import DTO.VendingMachineChange;
import DTO.VendingMachineItem;
import Service.VendingMachineDataValidationException;
import Service.VendingMachineInsufficientFundsException;
import Service.VendingMachineNoItemInventoryException;
import Service.VendingMachineServiceLayer;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Viktorija
 */

public class VendingMachineServiceLayerImplTest {

    // private VendingMachineDao dao = new VendingMachineDaoStubImpl();
    // private VendingMachineAuditLogDao audit = new VendingMachineAuditDaoStubImpl();
    
    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VendingMachineServiceLayer.class);

    }

    /**
     * Test of buyItem method. Will search dao for item and return it.
     */
    @Test
    public void testInInvEnoughFund() throws Exception {

        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.00");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());

        assertEquals(0, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());

    }
    
    //Test of MoneyTracking method
    @Test
    public void testMoneyTracking() throws Exception {
        BigDecimal cash = new BigDecimal("8.00");
        service.addToMoney(cash);

        assertEquals(cash, service.getCurrentMoney());

        BigDecimal extraCash = new BigDecimal("3");
        service.addToMoney(extraCash);

        BigDecimal total = cash.add(extraCash);
        assertEquals(total, service.getCurrentMoney());

        service.buyItem("Chicas", total);

        BigDecimal zero = new BigDecimal("0");
        assertEquals(zero, service.getCurrentMoney());

    }
    
    @Test
    public void testInInvCalcChange51() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.51");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(2, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange12() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.12");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(2, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(1, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange06() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.06");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(1, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange99() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.99");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(4, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(2, change.getDime());
        assertEquals(3, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange01() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.01");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange125() throws Exception {
        String buyableItem = "Chicas";
        VendingMachineItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("9.25");

        VendingMachineChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(0, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(5, change.getQuarter());
    }

    @Test
    public void testInInvInsuffFund() throws Exception {
        String buyableItem = "Chicas";
        BigDecimal cash = new BigDecimal("7.99");

        try {
            service.buyItem(buyableItem, cash);
            fail("expected insuff funds exc not thrown");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }

    }

    @Test
    public void testBuyOrRemoveNotInInv() throws Exception {
        String buyableItem = "cookies";
        BigDecimal cash = new BigDecimal("7.99");

        try {
            service.buyItem(buyableItem, cash);
            fail("expected no item in inv. exc not thrown");
        } catch (VendingMachineNoItemInventoryException e) {
            return;
        }
    }

    /**
     * Test of removeItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testRemoveItemInInv() throws Exception {
        String buyableItem = "Chicas";

        
        VendingMachineItem removed = service.removeItems(buyableItem);
        assertEquals(buyableItem, removed.getName());
    }

    /**
     * add method tests
     * @throws Exception
     */
    @Test
    public void testAddItemFieldMissing() throws Exception {
        VendingMachineItem item = new VendingMachineItem("Paperclips");
        item.setNumInStock(3);

        try {
            item.setPrice("");
            fail("Expected num format exc not thrown");
        } catch (NumberFormatException e) {
            return;
        }
        try {
            service.addItem(item);
            fail("Expected data validatn exc not thrown");
        } catch (VendingMachineDataValidationException e) {
            return;
        }
    }

    @Test
    public void testAddItemNotInInv() throws Exception {
        VendingMachineItem item = new VendingMachineItem("Paperclips");
        item.setNumInStock(3);
        item.setPrice("12.00");

        assertEquals(3, service.addItem(item));

    }

    @Test
    public void testAddItemInInv() throws Exception {
        VendingMachineItem item = new VendingMachineItem("Chicas");
        item.setNumInStock(75);
        item.setPrice("12.00");

        int newNum = service.addItem(item);

        assertEquals(78, newNum);
    }

}
