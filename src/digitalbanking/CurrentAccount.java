package digitalbanking;

public class CurrentAccount extends Account{

	public CurrentAccount(Client client) {
		super(client);
		this.setName("Conta Corrente");
	}

}
