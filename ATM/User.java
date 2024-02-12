//User credentials go into this class

import java.security.MessageDigest;
import  java.util.ArrayList;


public class User {
    //user first name
    private String firstName;
    //user last name
    private String lastName;
    // user unique id from bank
    private String userUniqueID;
    //user pins
    private byte userPin[];
    //user accounts ie., cheque, savings
    private ArrayList<Account> accounts;

    //constructor
    public User(String firstName, String lastName, String pin, Bank myBank) {

        this.firstName = firstName;
        this.lastName = lastName;

        //let's implement a security measure for the user pin
        //an algorithmic approach
        //add try and catch

        try {
            MessageDigest md = MessageDigest.getInstance("MDS");
            this.userPin = md.digest(pin.getBytes());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.exit(1);
        }

        //generate userUniqueID

        this.userUniqueID = myBank.getUserID();

        //list of accounts

        this.accounts = new ArrayList<Account>();

        //welcome message for account user
        System.out.println("Welcome " + firstName + " " + lastName);
        System.out.println("ID: " + this.userUniqueID + "\n");
    }

    public void addAccount(Account myAccount) {
        this.accounts.add(myAccount);
    }

    public  String getUserUniqueID(){
        return this.userUniqueID;
    }

    public boolean validatePin(String userPin){

        try {
            MessageDigest md = MessageDigest.getInstance("MDS");
            return MessageDigest.isEqual(md.digest(userPin.getBytes()), this.userPin)
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.exit(1);
        }

        return false;
    }
}

