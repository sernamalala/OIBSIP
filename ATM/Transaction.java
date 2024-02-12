
import java.util.Date;
 class Transaction {

    //amount that will be transacted

    private double amount;

    //date to be displayed

    private Date currentTime;

    //current account user is using

     private Account currentAccount;

     //constructor
     public Transaction(double amount, Account currentAccount){

      this.amount = amount;
      this.currentAccount = currentAccount;
      this.currentTime = new Date();

     }

     
}

