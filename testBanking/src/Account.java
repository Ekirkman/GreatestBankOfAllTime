

import java.util.ArrayList;

public class Account {


	private double intrestRate;
	private String accountType;
	private double balance;
	private String id;
	private ArrayList<Transaction> statement= new ArrayList<Transaction>();
	
	public Account() {}

	

	public double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		Transaction transaction = new Transaction(balance, "debit",0.0);
		balance= transaction.getCurrentBal();
		statement.add(transaction);
	}
	
	
	
	public void returnBalance() {
		System.out.println("Balance: "+balance);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public void debit(double transactionAmount) {
		Transaction transaction = new Transaction(transactionAmount, "debit",this.balance);
		this.balance= transaction.getCurrentBal();
		
		statement.add(transaction);
	}

	public void credit(double transactionAmount) {
		Transaction transaction = new Transaction(transactionAmount, "credit",this.balance);
		this.balance= transaction.getCurrentBal();
		statement.add(transaction);
	}

	public ArrayList<Transaction> getStatement() {
		return statement;
	}

	public void setStatement(ArrayList<Transaction> statement) {
		this.statement = statement;
	}
	public void addTransaction(Transaction transaction) {
		statement.add(transaction);
	}
	public void  viewTransactions() {
		for (Transaction transaction : statement) {
			System.out.println(transaction);
		}
	}
}
