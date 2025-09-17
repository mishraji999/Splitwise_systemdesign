import java.util.*;

public class BalanceManager {

    Map<User,Double> userShare = new HashMap<>();


    public BalanceManager(Expense expense){
        setUserShare(expense);
    }

    public double calculateShare(Expense expense){
        double numberOfParticipants = expense.getParticipants().size();
        return expense.getAmount()/numberOfParticipants;
    }

    public void setUserShare(Expense expense){

        for(User entry : expense.getParticipants()){
            this.userShare.put(entry,calculateShare(expense));
        }

    }

    public Map<User,Double> getUserShare(){
        return userShare;
    }

    public void printUserShare(){
        System.out.println("Per Use share in the payment");
        for(User entry : userShare.keySet()){
            System.out.println(entry.getName() +"'s share is " + userShare.get(entry));
        }
    }





    // TODO: Support different split types (percentage, exact amounts)
    // TODO: Extend to cumulative balances across multiple expenses
    // TODO: calculate net balances (paid vs owed) in future



//    @Override
//
//    public String toString(){
//        return
//    }
}
