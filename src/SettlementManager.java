import com.sun.nio.file.ExtendedOpenOption;

import java.util.HashMap;

public class SettlementManager {

    private HashMap<User,Double> clearBalance = new HashMap<>();
    Expense newExpense;

    public SettlementManager(Expense newExpense, BalanceManager userShare){

        setClearBalance(newExpense,userShare);
        setNewExpense(newExpense);

    }

    public void setNewExpense(Expense newExpense){

        this.newExpense = newExpense;

    }

    public Expense getNewExpense(){
        return newExpense;
    }


    public void setClearBalance(Expense newExpense, BalanceManager userShare){

        for(User participants : newExpense.getParticipants()){

            if(participants != newExpense.getPayer()){
                this.clearBalance.put(participants,0 - userShare.getUserShare().get(participants));
            } else{
                this.clearBalance.put(participants,newExpense.getAmount() - userShare.getUserShare().get(participants));
            }

        }

        if(!newExpense.getParticipants().contains(newExpense.getPayer())){
            this.clearBalance.put(newExpense.getPayer(), newExpense.getAmount());
        }
    }

    public void printClearBalance(){
        for(User entry : clearBalance.keySet()){
            if(clearBalance.get(entry) > 0){
                System.out.println(entry.getName() + " is owed " + clearBalance.get(entry));
            }

            else {
                System.out.println(entry.getName() + " owes " + (0 - clearBalance.get(entry)));
            }
        }
    }

    public HashMap<User,Double> getClearBalance(){
        return clearBalance;
    }


//    @Override
//    public String toString(){
//        return "The Payer: " + newExpense.getPayer().getName() + " must get " + clearBalance.get(newExpense.getPayer());
//    }

    // TODO Extend the logic to all players.
    // TODO Handle multiple expenses and balances





}
