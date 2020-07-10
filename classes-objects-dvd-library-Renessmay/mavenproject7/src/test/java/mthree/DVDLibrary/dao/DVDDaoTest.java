package mthree.DVDLibrary.dao;

import dao.DVDDao;
import dao.DVDDaoFileImpl;
import dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public class DVDDaoTest {
    
    private DVDDao dao = new DVDDaoFileImpl();
    
    public DVDDaoTest() {
    }
    
    
    @BeforeEach
    public void setUp() throws Exception {
        List<DVD>dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList){
            dao.removeDVD(dvd.getTitle());
        }
    }


    /**
     * Test of addDVD method, of class DVDDao.
     */
 @Test
    public void testGetAddDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd = new DVD("Prometheus");
        dvd.setYear(LocalDate.parse("12/15/2015", df));
        dvd.setMpaaRating("R");
        dvd.setDirectorsName("Smith");
        dvd.setStudio("Solomon");
        dvd.setUserRating("Excellent");
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getTitle());
        
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDVDs method, of class DVDDao.
     */
@Test
    public void testGetAllDVDs() throws Exception {
DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd1 = new DVD("Prometheus");
        dvd1.setYear(LocalDate.parse("12/15/2015", df));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorsName("Smith");
        dvd1.setStudio("Solomon");
        dvd1.setUserRating("Excellent");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Alien");
        dvd2.setYear(LocalDate.parse("12/15/2015", df));
        dvd2.setMpaaRating("R");
        dvd2.setDirectorsName("Joey");
        dvd2.setStudio("Warner");
        dvd2.setUserRating("Scary");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
    }

    /**
     * Test of removeDVD method, of class DVDDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       DVD dvd1 = new DVD("Prometheus");
        dvd1.setYear(LocalDate.parse("12/15/2015", df));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorsName("Smith");
        dvd1.setStudio("Solomon");
        dvd1.setUserRating("Excellent");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        
        DVD dvd2 = new DVD("Alien");
        dvd2.setYear(LocalDate.parse("12/15/2015", df));
        dvd2.setMpaaRating("R");
        dvd2.setDirectorsName("Joey");
        dvd2.setStudio("Warner");
        dvd2.setUserRating("Scary");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
        
        dao.removeDVD(dvd1.getTitle());
        assertEquals(1, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd1.getTitle()));
        
        dao.removeDVD(dvd2.getTitle());
        assertEquals(0, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd2.getTitle()));
    }

    /**
     * Test of editDVD method, of class DVDDao.
     */
    @Test
    public void testEditGetDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd = new DVD("Prometheus");
        dvd.setYear(LocalDate.parse("12/15/2015", df));
        dvd.setMpaaRating("R");
        dvd.setDirectorsName("Smith");
        dvd.setStudio("Solomon");
        dvd.setUserRating("Excellent");
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getTitle());
        
        //fromDao.setTitle("Alien Covenant");
        
        dao.editDVD(fromDao.getTitle(), fromDao);
        
        assertEquals(dvd, fromDao);
    }    
}
 