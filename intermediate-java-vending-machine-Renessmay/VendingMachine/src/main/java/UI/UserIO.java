/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;

/**
 *
 * @author Viktorija
 */

public interface UserIO {
    
    void print(String msg);

    double readDouble(String prompt) throws VendingMachineInputFormatException ;

    double readDouble(String prompt, double min, double max) throws VendingMachineInputFormatException ;

    float readFloat(String prompt) throws VendingMachineInputFormatException ;

    float readFloat(String prompt, float min, float max) throws VendingMachineInputFormatException ;

    int readInt(String prompt) throws VendingMachineInputFormatException;

    int readInt(String prompt, int min, int max) throws VendingMachineInputFormatException;

    BigDecimal readBigDec(String prompt) throws VendingMachineInputFormatException;

    long readLong(String prompt) throws VendingMachineInputFormatException ;

    long readLong(String prompt, long min, long max) throws VendingMachineInputFormatException ;

    String readString(String prompt);
}

