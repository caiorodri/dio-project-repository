package digitalbanking;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	String name;
	List<Account> accountList = new ArrayList<>();
	List<Client> clients = new ArrayList<>();
	
	
	
	public Bank(String name) {
		this.name = name;
	}

	public void describeClients() {
		
		System.out.println("\nCLIENTES DO " + this.name.toUpperCase() + "\n");
		for (Client client : clients) {
			
			System.out.println(client.getName());
			
			
		}
		
	}
	
	public void addAccount(Account account) {
	
		if (!accountList.contains(account)) {
			
			accountList.add(account);
			this.addClient(account.getClient());
			
		}
			
	}
	
	private void addClient(Client client) {
		
		if (!clients.contains(client)) {
			
			clients.add(client);
			
		}
		
	}
}
