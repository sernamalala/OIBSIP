//main class of our ATM
//basic ATM interface

import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //Bank

        Bank myBank = new Bank("Bank of CHAT-GPT"); 

        //add new user and create new account ie savings

        User addUser = myBank.addUser("Serna", "Malala", "sernamalala");
        Account newAccount = new Account("Student Account", addUser, myBank);
        addUser.addAccount(newAccount);
        myBank.addAccount(newAccount);

    }
}