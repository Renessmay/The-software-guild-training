/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTests;

import DAO.VendingMachineDao;
import DAO.VendingMachineFileImpl;
import DAO.VendingMachinePersistenceException;
import DTO.VendingMachineItem;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Viktorija
 */
public class VendingMachineFileImplTests {
    
    
    public static VendingMachineDao dao;

    static {
        try {
            dao = new VendingMachineFileImpl();
        } catch (VendingMachinePersistenceException e) {
            System.out.println("Error");
        }
    }

    public VendingMachineFileImplTests() { 
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws VendingMachinePersistenceException {
        List<VendingMachineItem> itemList = dao.getAllItems();

        for (VendingMachineItem i : itemList) {
            dao.removeItem(i.getName());
        }
    }

    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testBuyItem() throws VendingMachinePersistenceException {
        VendingMachineItem toAdd = new VendingMachineItem("Candy");
        toAdd.setNumInStock(2);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        dao.buyItem(toAdd.getName());

        VendingMachineItem fromDao = dao.getItem(toAdd.getName());

        assertEquals(1, fromDao.getNumInStock());
        assertEquals(toAdd, fromDao);

    }

    @Test
    public void testRemoveItems() throws VendingMachinePersistenceException {
        VendingMachineItem toAdd = new VendingMachineItem("Candy");
        toAdd.setNumInStock(2);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VendingMachineItem toAdd1 = new VendingMachineItem("Cola");
        toAdd.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addNewItem(toAdd1);

        dao.removeItem(toAdd.getName());

        assertEquals(1, dao.getAllItems().size());
        assertNull(dao.getItem("Candy"));

        dao.removeItem(toAdd1.getName());

        assertEquals(0, dao.getAllItems().size());
        assertNull(dao.getItem("Cola"));
    }

    @Test
    public void testAddToItem() throws Exception {
        VendingMachineItem toAdd = new VendingMachineItem("Candy");
        toAdd.setNumInStock(1);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VendingMachineItem toAdd1 = new VendingMachineItem("Candy");
        toAdd1.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addToItem(toAdd1);

        assertEquals(1, dao.getAllItems().size());
        assertEquals(8, dao.getItem(toAdd.getName()).getNumInStock());
    }

    @Test

    public void testAddNewItem() throws Exception {

        VendingMachineItem toAdd = new VendingMachineItem("Candy");
        toAdd.setNumInStock(1);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VendingMachineItem toAdd1 = new VendingMachineItem("Cola");
        toAdd.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addNewItem(toAdd1);

        assertEquals(2, dao.getAllItems().size());

    }
}

