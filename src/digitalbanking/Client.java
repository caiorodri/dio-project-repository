package digitalbanking;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String name;
	private List<Account> accountList = new ArrayList<>();
	
	
	
	public Client(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Account> getAccountList() {
		return accountList;
	}

	public void addAccount(Account account) {
		this.accountList.add(account);
	}
	
	public void describeAccounts(){
		
		for (Account account : accountList) {
			
			account.accountStatement();
			
		}
		
	}
	
}
