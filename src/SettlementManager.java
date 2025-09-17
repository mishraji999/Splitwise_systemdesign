import com.sun.nio.file.ExtendedOpenOption;

import java.util.HashMap;

public class SettlementManager {

    HashMap<User,Double> clearBalance = new HashMap<>();
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
        if(!newExpense.getParticipants().contains(newExpense.getPayer())){
            this.clearBalance.put(newExpense.getPayer(),newExpense.getAmount());
        }
        else{
            this.clearBalance.put(newExpense.getPayer(),newExpense.getAmount() - userShare.getUserShare().get(newExpense.getPayer()));
        }
    }

    public HashMap<User,Double> getClearBalance(){
        return clearBalance;
    }


    @Override
    public String toString(){
        return "The Payer: " + newExpense.getPayer().getName() + " must get " + clearBalance.get(newExpense.getPayer());
    }





}
