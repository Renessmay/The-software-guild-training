package app;

import controller.DVDController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
  // UserIO myIo = new UserIOConsoleImpl();
        // ClassRosterView myView = new ClassRosterView(myIo);
        // ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // ClassRosterAuditDao myAuditDao = 
        //       new ClassRosterAuditDaoFileImpl();
        // ClassRosterServiceLayer myService = 
        //       new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // ClassRosterController controller = 
        //       new ClassRosterController(myService, myView);
        // controller.run();
 
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller = ctx.getBean("controller", DVDController.class);
        controller.run();
}
}