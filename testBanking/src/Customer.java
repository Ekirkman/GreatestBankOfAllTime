

import java.util.ArrayList;

public class Customer {
	
		private String firstName;
		private String lastName;
		private String telephone;
		private Address address;
		private String userName;
		private String password;
		private String emailAddress;
		private Double balance;
		private ArrayList<Account> accounts = new ArrayList<Account>();

		public Customer() {}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public Double getBalance() {
			return balance;
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		}

		public ArrayList<Account> getAccounts() {
			return accounts;
		}

		public void setAccounts(Account account) {
			accounts.add(account);
		}

		public void transferFunds(Account account1, Account account2, double transactionAmount) {
			
			account1.credit(transactionAmount);
			account2.debit(transactionAmount);
			
		}
		public void closeAccount(Account account) {
			accounts.remove(account);
		}
		public void addAccount(Account account) {
			accounts.add(account);
		}
		}
		


