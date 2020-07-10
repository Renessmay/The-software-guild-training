package app;
import controller.DVDController;
import dao.DVDDao;
import dao.DVDDaoFileImpl;
import ui.DVDView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktorija
 */



public class App {
	   
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DVDDao myDao = new DVDDaoFileImpl();
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }
}