# Cashflow-Minimizer
Cashflow Minimizer (Debt Simplification)
Java
License: MIT

A Java implementation of a cashflow minimization algorithm that simplifies debt settlements between multiple parties by computing the minimum number of transactions required.

Features
Calculates optimal transactions to settle debts

Minimizes the total number of payments

Handles both creditors and debtors

Simple and efficient greedy algorithm implementation

Prerequisites
Java 17 or higher

Maven (for building)

Installation
Clone the repository:

bash
Copy
git clone https://github.com/yourusername/cashflow-minimizer.git
cd cashflow-minimizer
Build the project:

bash
Copy
mvn clean package
Usage
Modify the main method in CashflowMinimizer.java to input your own debt data:

java
Copy
Person[] people = {
    new Person("Alice", -100),  // owes 100
    new Person("Bob", 50),      // should receive 50
    new Person("Charlie", 50)   // should receive 50
};
Run the program:

bash
Copy
java -jar target/cashflow-minimizer-1.0.jar
Example Output
Copy
Initial Balances:
Alice: -100
Bob: 50
Charlie: 50

Optimal Transactions:
Alice pays 50 to Bob
Alice pays 50 to Charlie

Final Balances:
Alice: 0
Bob: 0
Charlie: 0
Contributing
Contributions are welcome! Please open an issue or submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Algorithm inspired by standard debt simplification approaches

Built with Java and Maven
