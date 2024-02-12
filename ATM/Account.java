/**
 * Account
 */
import java.security.MessageDigest;
import java.util.ArrayList;

public class Account {

    //account name
    private String name;

    //user unique id from bank
    private String userUniqueID;

    //current user of account mentioned
    private User currentUser;

    private ArrayList<Transaction> transactions;

    //constructor

    public Account(String name, User currentUser, Bank myBank){

    //sets account name and holder

        this.name = name;
        this.currentUser = currentUser;

        //get account unique id

        this.userUniqueID = myBank.getUserAccountID();
        //current transactions made in account
        this.transactions = new ArrayList<Transaction>();

    }

    public String getAccountUniqueID(){

        return this.userUniqueID;
    }
}
