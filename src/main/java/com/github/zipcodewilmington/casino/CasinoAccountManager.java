package com.github.zipcodewilmington.casino;

import java.io.*;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 7/21/2020.
 * `CasinoAccountManager` stores, manages, and retrieves `CasinoAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager implements Serializable {
    Map<String, CasinoAccount> accounts = new TreeMap<>();
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `CasinoAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        CasinoAccount returnVal;
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        if (accounts.get(accountName) == null) {
            returnVal = null;
        } else if (accounts.get(accountName).testPasswordEquals(accountPassword)) {
            returnVal = accounts.get(accountName);
        } else {
            returnVal = null;
        }


        if (returnVal == null) {
            System.out.println("Incorrect username or password.");
        } else {
            System.out.println("Account found!");
        }
        return returnVal;
    }

    /**
     * logs & creates a new `CasinoAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `CasinoAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        if (accounts.containsKey(accountName)) {
            System.out.println("Could not create account!");
            return null;
        }
        System.out.println("Account created successfully!");
        return new CasinoAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `CasinoAccount` to `this.getCasinoAccountList()`
     *
     * @param casinoAccount the casinoAccount to be added to `this.getCasinoAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        if (casinoAccount == null) {
            System.out.println("This account already exists!");
        } else {
            accounts.put(casinoAccount.name, casinoAccount);
            System.out.println("Account successfully registered!");
        }
    }

    public void readFromFile() {
        File input = new File("./accountMgr.ser");
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(input);
            ois = new ObjectInputStream(fis);
            CasinoAccountManager oldAccountMgr = (CasinoAccountManager) ois.readObject();
            this.accounts.putAll(oldAccountMgr.accounts);
        } catch (FileNotFoundException ignored) {
            System.out.println("Account manager serial file not found.\n" +
                    "Skipping reconstruction.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while trying to recreate casino accounts.");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Account Manager class not found in Account Manager serial file.\n" +
                    "Skipping reconstruction.");
        }
    }

    public void writeToFile() {
        File output = new File("./accountMgr.ser");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(output);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (FileNotFoundException fnfe) {
            try {
                output.createNewFile();
                fos = new FileOutputStream(output);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(this);
                oos.close();
                fos.close();
            } catch (IOException ioe) {
                System.err.println("Could not serialize the account manager. Data will be lost.");
                throw new RuntimeException(ioe);
            }
        } catch (IOException ioe) {
            System.err.println("An IO error occurred while trying to write account manager to file.");
            throw new RuntimeException(ioe);
        }
    }
}
