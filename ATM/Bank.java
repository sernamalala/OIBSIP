import java.util.ArrayList;
import java.util.Random;

public class Bank {

    //name

    private String name;

    //current user
    private ArrayList <User> user;

    //current account

    private ArrayList <Account> accounts;

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

    public void addAccount(Account myAccount) {
        this.accounts.add(myAccount);
    }
}
