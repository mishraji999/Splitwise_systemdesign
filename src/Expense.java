import java.util.*;
public class Expense {


    private double amount;
    private String description;
    private User payer;
    private Set<User> participants = new HashSet<>();

    public Expense(double amount, String description, User payer, Set<User> participants){

        setAmount(amount);
        setDescription(description);
        setPayer(payer);
        setParticipants(participants);

    }


    public void setParticipants(Set<User> participants){
//        if(!participants.isEmpty()){
//            this.participants = participants;
//        } else{
//            System.out.println("Error: For Every Expense there must be participants!");
//        }

        if(participants == null || participants.isEmpty()){
            throw new IllegalArgumentException("Expense must have atleast 1 participant");
        }
        this.participants = participants;
    }

    public Set<User> getParticipants(){
        return participants;
    }


    public void addParticipant(User participant){
        this.participants.add(participant);
    }

    public void removeParticipant(User participant){
        this.participants.remove(participant);
    }



    public void setAmount(double amount){
//        if(amount > 0){
//            this.amount = amount;
//        }else{
//            System.out.println("Enter valid input for amount");
//        }

        if(amount <= 0){
            throw new IllegalArgumentException("Provide a valid amount of payment");
        }
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }


    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


    public void setPayer(User payer){
//        if(payer != null){
//            this.payer = payer;
//        }
//        else{
//            System.out.println("PLease Add details of the payer!");
//        }

        if(payer == null){
            throw new IllegalArgumentException("Payer cannot be null");
        }
        this.payer = payer;
    }

    public User getPayer(){
        return payer;
    }


    public Set<String> getParticipantNames(){

        Set<String> nameSet = new HashSet<>();

        for(User entry : participants){
            nameSet.add(entry.getName());
        }
        return nameSet;
    }

    @Override
//    public String toString(){
//
//        Set<String> nameSet = getParticipantName();
//
//        return "The Amount: " + amount +
//                " The description: " + description +
//                " by User: " + (payer != null ? payer.getName() : "None") +
//                " Participants: " + nameSet.toString();
//
//    }

    public String toString() {
//        Set<String> nameSet = getParticipantName();
        return "Expense{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", payer=" + (payer != null ? payer.getName() : "None") +
                ", participants=" + getParticipantNames() +
                '}';
    }



}
