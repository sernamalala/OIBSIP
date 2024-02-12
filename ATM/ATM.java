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

        //Login message

        User currentUser;

        while(true){
            //remain on login until succesful credentials entered

            currentUser = ATM.mainMenuMessage(myBank, input);
            ATM.printUserMenu(currentUser, input);
        }

    }

    public static User mainMenuMessage(Bank myBank, Scanner input){

        String userID;
        String userPin;
        User authorisation;

        //prompt user for ID and Pin . Until correct comination is received
        do {
            System.out.println("\n\nWelcome to "+myBank.getName());
            System.out.println("Enter user ID: ");
            userID = input.nextLine();
            System.out.println("Enter your pin: ");
            userPin = input.nextLine();

            //retrive user with exact id and pin

            authorisation = myBank.Login(userID, userPin);

            if(authorisation==null){
                System.out.println("Incorrect user ID / pin combination.\nPlease Try Again!");
            }

        } while (authorisation == null);

        //returning autheticated user
        return authorisation;
    }

    public static void printUserMenu(User currentUser, Scanner input){

        //print summary of account(s)

        currentUser.printAccountSummary();

        int userChoice;
        do {
            System.out.println("Welcome, "+currentUser.);
        } while (condition);

    }
}