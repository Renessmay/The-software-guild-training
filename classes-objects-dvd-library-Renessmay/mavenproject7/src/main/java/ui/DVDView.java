package ui;

import dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class DVDView {
      private UserIO io;

    public DVDView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu\n======");
        io.print("1. List DVD Titles");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);

    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD's ==="); //Menu 1.
    }

    public void displayDVDList(List<DVD> dvdList) { //Menu 1.
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + " "
                    + currentDVD.getGenre() + " "
                    + currentDVD.getYear() + " "
                    + currentDVD.getStudio() + " "
                    + currentDVD.getDirectorsName() + " "
                    + currentDVD.getUserRating() + " "
                    + currentDVD.getMpaaRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayCreateDVDBanner() { //Menu 2.
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() { //Menu 2.
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
       public LocalDate dateInput(String releaseDate){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(releaseDate, dateFormat);
        
        return date;
    }

    public DVD getNewDVDInfo() {//Menu 2.
        String title = io.readString("Please enter the DVD Title");
        String genre = io.readString("Please enter the Genre");
        LocalDate year = dateInput(io.readString("Please enter the Year"));
        String studio = io.readString("Please enter the Studio");
        String directorsName = io.readString("Please enter the Directors name");
        String userRating = io.readString("Please enter a rating 1 - 5 stars");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setGenre(genre);
        currentDVD.setYear(year);
        currentDVD.setStudio(studio);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setUserRating(userRating);
        currentDVD.setMpaaRating(mpaaRating);
        return currentDVD;
    }


    public DVD editDVD(DVD dvd) {
        
        String genre = io.readString("Please enter the Genre");
        String year = io.readString("Please enter the Year");
        String studio = io.readString("Please enter the Studio");
        String directorsName = io.readString("Please enter the Directors name");
        String userRating = io.readString("Please enter a rating 1 - 5 stars");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        
        dvd.setGenre(genre);
        dvd.setYear(year);
        dvd.setStudio(studio);
        dvd.setDirectorsName(directorsName);
        dvd.setUserRating(userRating);
        dvd.setMpaaRating(mpaaRating);
        
        return dvd;
        
//        if (dvd != null) {
//            return getNewDVDInfo();
//        } else {
//            io.print("No such DVD.");
//        }
//        return dvd;
    }

    public String getDVDTitleChoice() { //Menu 3.
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDisplayDVDBanner() { //Menu 3.
        io.print("=== Display DVD ===");
    }

    public void displayDVD(DVD dvd) { //Menu 3.
        if (dvd != null) {
            io.print(dvd.getGenre());
            io.print(dvd.getYear() + " " + dvd.getStudio());
            io.print(dvd.getDirectorsName() + " " + dvd.getUserRating());
            io.print(dvd.getMpaaRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() { //Menu 4.
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() { //Menu 4.
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditSuccessBanner() { //Menu 4.
        io.readString("DVD successfully Edited. Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
