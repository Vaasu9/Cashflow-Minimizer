
import java.util.*;

public class CashflowMinimizer {
    
    public static void main(String[] args) {
        // Sample input: people and their net balances
        // Negative = owes money, Positive = is owed money
        int[] balances = {-100, 50, 50}; // Alice owes 100, Bob owed 50, Charlie owed 50
        String[] names = {"Alice", "Bob", "Charlie"};
        
        System.out.println("Initial Balances:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + balances[i]);
        }
        
        System.out.println("\nTransactions:");
        settleDebts(balances, names);
        
        System.out.println("\nFinal Balances:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + balances[i]);
        }
    }
    
    public static void settleDebts(int[] balances, String[] names) {
        while (true) {
            // Find person with max debt (most negative)
            int maxDebtor = 0;
            for (int i = 1; i < balances.length; i++) {
                if (balances[i] < balances[maxDebtor]) {
                    maxDebtor = i;
                }
            }
            
            // Find person with max credit (most positive)
            int maxCreditor = 0;
            for (int i = 1; i < balances.length; i++) {
                if (balances[i] > balances[maxCreditor]) {
                    maxCreditor = i;
                }
            }
            
            // If both are zero, we're done
            if (balances[maxDebtor] == 0 && balances[maxCreditor] == 0) {
                break;
            }
            
            // Calculate amount to pay
            int amount = Math.min(-balances[maxDebtor], balances[maxCreditor]);
            
            // Make transaction
            balances[maxDebtor] += amount;
            balances[maxCreditor] -= amount;
            
            // Print transaction
            System.out.println(names[maxDebtor] + " pays " + amount + " to " + names[maxCreditor]);
        }
    }
}
