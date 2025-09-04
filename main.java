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
        List<String> transactions = new ArrayList<>();
        
        while (true) {
            // Find person who owes the most (most negative balance)
            Person maxDebtor = null;
            for (Person p : people) {
                if (maxDebtor == null || p.balance < maxDebtor.balance) {
                    maxDebtor = p;
                }
            }
            
            // Find person who is owed the most (most positive balance)
            Person maxCreditor = null;
            for (Person p : people) {
                if (maxCreditor == null || p.balance > maxCreditor.balance) {
                    maxCreditor = p;
                }
            }
            
            // Stop if everyone is settled
            if (maxDebtor.balance == 0 && maxCreditor.balance == 0) {
                break;
            }
            
            // Calculate payment amount
            int amount = Math.min(-maxDebtor.balance, maxCreditor.balance);
            
            // Record transaction
            transactions.add(maxDebtor.name + " pays " + amount + " to " + maxCreditor.name);
            
            // Update balances
            maxDebtor.balance += amount;
            maxCreditor.balance -= amount;
        }
        
        // Print all transactions
        System.out.println("\nOptimal Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
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
