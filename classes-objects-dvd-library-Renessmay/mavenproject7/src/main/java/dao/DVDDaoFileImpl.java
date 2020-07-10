/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Viktorija
 */

public class DVDDaoFileImpl implements DVDDao {

    private Map<String, DVD> dvds = new HashMap<>();

    private final String LIBRARY_FILE;
    public static final String DELIMITER = "::";
    
    public DVDDaoFileImpl(){
        LIBRARY_FILE= "library.txt";
    }
    public DVDDaoFileImpl(String dvdTextFile){
        LIBRARY_FILE=dvdTextFile;
    }

    @Override
    public DVD addDVD(String title, DVD dvd)
        throws DVDDaoException {
        DVD newDVD = dvds.put(title, dvd);
        try {
            writeDVD();
        } catch (DVDDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()
            throws DVDDaoException {
        loadDVD();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoException {
        DVD removedDVD = dvds.remove(title);
        try {
            writeDVD();
        } catch (DVDDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return removedDVD;
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVD editDVD(String title, DVD dvd) {
        //DVD editedDVD = dvds.get(title);
        dvds.put(title, dvd);
        return dvd;
    }

    private void loadDVD() throws DVDDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDDaoException(
                    "-_- Could not load library data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setGenre(currentTokens[1]);
            currentDVD.setYear(LocalDate.parse(currentTokens[2]));
            currentDVD.setStudio(currentTokens[3]);
            currentDVD.setDirectorsName(currentTokens[4]);
            currentDVD.setUserRating(currentTokens[5]);
            currentDVD.setMpaaRating(currentTokens[6]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private void writeDVD() throws DVDDaoException, IOException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDDaoException(
                    "Could not save dvd data.", e);
        }

        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {

            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getGenre() + DELIMITER
                    + currentDVD.getYear() + DELIMITER 
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getDirectorsName() + DELIMITER
                    + currentDVD.getUserRating() + DELIMITER
                    + currentDVD.getMpaaRating());

            out.flush();
        }

        out.close();
    }
 
}
