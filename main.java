import java.util.*;

class Person {
    String name;
    int balance;
    
    public Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}

public class CashflowMinimizer {
    
    public static void minimizeCashFlow(Person[] people) {
        calculateNetBalances(people);
        
        List<String> transactions = new ArrayList<>();
        
        while (true) {
            Person maxCreditor = getMaxPerson(people, true);
            Person maxDebtor = getMaxPerson(people, false);
            
            if (maxCreditor.balance == 0 && maxDebtor.balance == 0) {
                break;
            }
            
            int minAmount = Math.min(maxCreditor.balance, -maxDebtor.balance);
            
            transactions.add(maxDebtor.name + " pays " + minAmount + " to " + maxCreditor.name);
            
            maxCreditor.balance -= minAmount;
            maxDebtor.balance += minAmount;
        }
        
        System.out.println("\nOptimal Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
    
    private static void calculateNetBalances(Person[] people) {
    }
    
    private static Person getMaxPerson(Person[] people, boolean getCreditor) {
        Person maxPerson = null;
        int maxAmount = 0;
        
        for (Person person : people) {
            if ((getCreditor && person.balance > maxAmount) || 
                (!getCreditor && person.balance < maxAmount)) {
                maxAmount = person.balance;
                maxPerson = person;
            }
        }
        
        return maxPerson;
    }
    
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", -100),
            new Person("Bob", 50),
            new Person("Charlie", 50)
        };
        
        System.out.println("Initial Balances:");
        for (Person p : people) {
            System.out.println(p.name + ": " + p.balance);
        }
        
        minimizeCashFlow(people);
        
        System.out.println("\nFinal Balances:");
        for (Person p : people) {
            System.out.println(p.name + ": " + p.balance);
        }
    }
}
