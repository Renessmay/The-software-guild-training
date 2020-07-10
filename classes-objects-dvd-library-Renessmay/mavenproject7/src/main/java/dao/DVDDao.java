package dao;

import dto.DVD;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */
public interface DVDDao {
    
    DVD addDVD(String title, DVD dvd)
            throws DVDDaoException;

    List<DVD> getAllDVDs()
            throws DVDDaoException;

    DVD getDVD(String title)
            throws DVDDaoException;

    DVD removeDVD(String title)
            throws DVDDaoException;

    DVD editDVD(String title, DVD dvd)
            throws DVDDaoException;
}
