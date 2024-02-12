import java.util.ArrayList;
import java.util.Random;

public class Bank {

    //name

    private String name;

    //current user arraylist
    private ArrayList <User> user;

    //current account

    private ArrayList <Account> accounts;

    public Bank(String name){

        this.name = name;
        this.user = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getName(){

        return this.name;
    }
    public String getUserID(){

        String userUniqueID;
        Random rand  = new Random();
        boolean notUnique;

        do {

            //generate new unique id when not Unique is true
            userUniqueID = "";
            for (int i = 0; i < 6; i++) {

                userUniqueID += ((Integer) rand.nextInt(10)).toString();
            }

            notUnique = false;
            for (User bankUsers : this.user) {
                if (userUniqueID.compareTo(bankUsers.getUserUniqueID()) == 0) {
                    notUnique = true;
                    break;
                }
            }
        }

        while (notUnique);

            return userUniqueID;

    }

    public String getUserAccountID(){


        String accountUniqueID;
        Random rand  = new Random();
        boolean notUnique;

        do {

            //generate new unique id when not Unique is true
            accountUniqueID = "";
            for (int i = 0; i < 10; i++) {

                accountUniqueID += ((Integer) rand.nextInt(10)).toString();
            }

            notUnique = false;
            for (Account bankAccount : this.accounts) {
                if (accountUniqueID.compareTo(bankAccount.getAccountUniqueID()) == 0) {
                    notUnique = true;
                    break;
                }
            }
        }

        while (notUnique);

            return accountUniqueID;

    }

    //adds account to current available accounts of the current user
    public void addAccount(Account myAccount) {
        this.accounts.add(myAccount);
    }

    public User addUser(String firstName, String lastName, String userPin){

        //user object will be created

        User newUser = new User(firstName, lastName, userPin, this);
        this.user.add(newUser);

        //create an account ie. savings

        Account newAccount = new Account(lastName, newUser, this);
        
        //add current user to currentUser and Bank
        //updates lists as we go
       newUser.addAccount(newAccount);
       this.addAccount(newAccount);

       return newUser;
    }

    public User Login(String userID, String userPin){

        for(User currentUser: this.user){

            if(currentUser.getUserUniqueID().compareTo(userID) == 0 && currentUser.validatePin(userPin)){
                return currentUser;
            }
  
        }
        return null;
    }
}
