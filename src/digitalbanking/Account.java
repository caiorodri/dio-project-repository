package digitalbanking;

public abstract class Account {

	private static int SEQUENCE = 1;
	private static int DEFAULT_AGENCY = 1;

	private String name;
	private Client client;
	private int number;
	private int agency;
	private double balance;
	
	
	
	public Account(Client client) {

		this.client = client;
		this.number = SEQUENCE++;
		this.agency = DEFAULT_AGENCY;
		this.balance = 0;
		this.client.addAccount(this);
	
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Client getClient() {
		return client;
	}
	public int getNumber() {
		return number;
	}
	public int getAgency() {
		return agency;
	}
	public double getBalance() {
		return balance;
	}
	
	public Boolean withdraw(double value){
		
		if (value <= 0 || value > this.balance) {
			
			return false;
			
		} else {
			
			this.balance -= value;
			return true;
			
		}
		
	}
	
	public Boolean deposit(double value) {

		if (value <= 0) {
			
			return false;
			
		} else {
			
			this.balance += value;
			return true;
		}
		

	}

	public Boolean transfer(double value, Account destinationAccount) {
		
		if (value > 0 && value <= this.balance && destinationAccount != null) {
			
			this.withdraw(value);
			destinationAccount.deposit(value);
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public void accountStatement() {
		
		System.out.println("\n=============================\nINFORMAÇÕES DA " + this.name.toUpperCase() + "\n=============================\n");
		System.out.println(String.format("Titular: %s", this.client.getName()));
		System.out.println(String.format("Agencia: %d", this.agency));
		System.out.println(String.format("Numero: %d", this.number));
		System.out.println(String.format("Saldo: R$ %.2f", this.balance));
		
	}
}
