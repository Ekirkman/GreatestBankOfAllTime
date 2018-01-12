

public class Transaction {

private double transactionAmount;
private double previousBal;
private double currentBal;
private String transactionType;


public Transaction() {}

public Transaction(double transactionAmount, String transactionType, double previousBal) {
	if(transactionType.equals("credit"))
	{
		this.previousBal = previousBal;
		this.currentBal = previousBal - transactionAmount;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}
	else
	{
		this.previousBal = previousBal;
		this.currentBal = previousBal + transactionAmount;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}
}



public double getTransactionAmount() {
	return transactionAmount;
}



public void setTransactionAmount(double transactionAmount) {
	this.transactionAmount = transactionAmount;
}



public double getPreviousBal() {
	return previousBal;
}



public void setPreviousBal(double previousBal) {
	this.previousBal = previousBal;
}



public double getCurrentBal() {
	return currentBal;
}



public void setCurrentBal(double currentBal) {
	this.currentBal = currentBal;
}



private String getTransactionType() {
	return transactionType;
}



public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}



public String toString() {
	return("Previous Balance: "+ this.previousBal+" \nTransaction Amount: "+this.transactionAmount+"Transaction Type: "+this.transactionType+"\nNew Balance: "+this.currentBal);
	// fix this class to return new balance instead of balance twice
}

}
