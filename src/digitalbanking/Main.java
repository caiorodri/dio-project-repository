package digitalbanking;

public class Main {

	public static void main(String[] args) {
		
		Bank bank = new Bank("Nubank");
		
		Client joao = new Client("João");
		Client pedro = new Client("Pedro");
		
		Account joaoCurrentAccount = new CurrentAccount(joao);
		Account joaoSavingsAccount = new SavingsAccount(joao);
		Account pedroSavingsAccount = new SavingsAccount(pedro);
		
		bank.addAccount(joaoCurrentAccount);
		bank.addAccount(joaoSavingsAccount);
		bank.addAccount(pedroSavingsAccount);
		
		joaoCurrentAccount.accountStatement();
		joaoSavingsAccount.accountStatement();
		
		joaoCurrentAccount.deposit(2000);
		joaoCurrentAccount.transfer(1200, joaoSavingsAccount);
		
		pedroSavingsAccount.deposit(5000);
		
		joao.describeAccounts();
		pedro.describeAccounts();
		
		bank.describeClients();
	}
	
}
