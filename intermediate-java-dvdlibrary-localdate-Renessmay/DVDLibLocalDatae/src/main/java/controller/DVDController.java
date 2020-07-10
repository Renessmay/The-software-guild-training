package controller;

import dao.DVDDao;
import dao.DVDDaoException;
import dto.DVD;
import ui.DVDView;
import ui.UserIO;
import ui.UserIOConsoleImpl;
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
public class DVDController {

    DVDView view;
    DVDDao dao;

    //private UserIO io = new UserIOConsoleImpl();

    public DVDController(DVDDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                
                try {
                   menuSelection = getMenuSelection(); 
                } catch (NumberFormatException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                }
                

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
       } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void listDVDs() throws DVDDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void viewDVD() throws DVDDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void editDVD() throws DVDDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD previousDVD = dao.getDVD(title);
        DVD editedDVD = view.editDVD(previousDVD);
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEditSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
    

