

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer joe = new Customer();
		joe.setFirstName("Joe");
		joe.setLastName("Jackson");
		joe.setEmailAddress("Joe@joe.com");
		//joe.setBalance(100.00);
		Account joe1 = new Account();
		joe1.setAccountType("Savings");
		joe1.setBalance(100.00);
		joe1.setId("777");
		
		joe1.debit(10);
		joe1.credit(20);
		
		
		joe.setAccounts(joe1);
		
		joe1.viewTransactions();
	}

}
