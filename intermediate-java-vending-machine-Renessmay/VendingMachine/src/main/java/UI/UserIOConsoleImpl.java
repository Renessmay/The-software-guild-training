/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Viktorija
 */

public class UserIOConsoleImpl implements UserIO{
    
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) throws VendingMachineInputFormatException {
        double input;
        System.out.println(prompt);
        String strInput = sc.nextLine();
        try {
            input = Double.parseDouble(strInput);

        } catch (NumberFormatException e) {
            throw new VendingMachineInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) throws VendingMachineInputFormatException {
        String strInput;
        double input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Double.parseDouble(strInput);
            } catch (NumberFormatException e) {
                throw new VendingMachineInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public float readFloat(String prompt) throws VendingMachineInputFormatException {
        float input;
        System.out.println(prompt);

        String strInput = sc.nextLine();

        try {
            input = Float.parseFloat(strInput);
        } catch (NumberFormatException e) {
            throw new VendingMachineInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) throws VendingMachineInputFormatException {
        String strInput;
        float input;

        do {
            System.out.println(prompt);

            strInput = sc.nextLine();
            try {
                input = Float.parseFloat(strInput);
            } catch (NumberFormatException e) {
                throw new VendingMachineInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public int readInt(String prompt) throws VendingMachineInputFormatException {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        int input;
        try {
            input = Integer.parseInt(strInput);
        } catch (NumberFormatException e) {
            throw new VendingMachineInputFormatException("must input a number", e);
        }
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) throws VendingMachineInputFormatException {
        String strInput;
        int input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Integer.parseInt(strInput);
            } catch (NumberFormatException e) {
                throw new VendingMachineInputFormatException("must input a numbert", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public BigDecimal readBigDec(String prompt) throws VendingMachineInputFormatException {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        BigDecimal input;
        try {
            input = new BigDecimal(strInput);
        } catch (NumberFormatException e) {
            throw new VendingMachineInputFormatException("must input a number", e);
        }
        return input;
    }

    @Override
    public long readLong(String prompt) throws VendingMachineInputFormatException {
        long input;
        System.out.println(prompt);
        String strInput = sc.nextLine();
        try {
            input = Long.parseLong(strInput);
        } catch (NumberFormatException e) {
            throw new VendingMachineInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) throws VendingMachineInputFormatException {
        String strInput;
        long input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Long.parseLong(strInput);
            } catch (NumberFormatException e) {
                throw new VendingMachineInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}
