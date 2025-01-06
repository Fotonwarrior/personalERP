package Bomhofsoft.Personal_ERP.model.finance;

import java.util.ArrayList;

public class FinanceModule {
	
	public ArrayList<BankAccount> bankAccounts;

	public FinanceModule() {
		bankAccounts = new ArrayList<>();
	}
	
	public void addAccount(BankAccount account) {
		bankAccounts.add(account);
	}
}
