import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        User u1 = new User(1,"Piyush","piyu8@gmail.com");
        User u2 = new User(2,"Kritika","skjbfw8@gmail.com");
        User u3 = new User(3,"Sushma","sgvwe@gmail.com");

        Set<User> group1 = new HashSet<>();
        group1.add(u1);
        group1.add(u2);

        Expense e1 = new Expense(300,"Cafe",u1,group1);

//        System.out.println(u1.toString());
//        System.out.println(e1.toString());

        e1.addParticipant(u3);

//        System.out.println(e1.toString());

        BalanceManager b1 = new BalanceManager(e1);

        b1.printUserShare();
    }
}