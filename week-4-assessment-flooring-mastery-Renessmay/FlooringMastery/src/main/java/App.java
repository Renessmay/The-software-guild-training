/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.FlooringMasteryController;
import dao.FlooringMasteryPersistenceException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FlooringMasteryDataValidationException;

/**
 *
 * @author Viktorija
 */
public class App {
    public static void main(String[] args) throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, FileNotFoundException, IOException {        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringMasteryController controller = ctx.getBean("controller", FlooringMasteryController.class);
        controller.run();
    }
}
