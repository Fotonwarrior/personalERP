package Bomhofsoft.Personal_ERP.model.finance;

public class BankAccount {
	private static int i = 1;
	public int internalId;
	public String name;
	public String accountNumber;
	public Balance balance;
	public MutationList mutations;
	
	public BankAccount(String name, String accountNumber) {
		internalId = i;
		i++;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = new Balance();
		this.mutations = new MutationList();
		this.mutations.setBankaccount(this);
	}	
	
	public BankAccount(String name, String accountNumber, double startingBalance) {
		this(name, accountNumber);
		Mutation startingMutation = new Mutation(startingBalance, "Opening Balance");
		MutationList mutationList = new MutationList(startingMutation);
		this.update(startingBalance, mutationList);
	}	
	public void update(double balance, MutationList mutations) {
		
		double mutationNorm = balance - this.balance.balance;
		double mutationsSum = mutations.sum();
		boolean checkn =  (Math.abs(mutationNorm - mutationsSum) < 1e-9);
		if (!checkn){
			String msg = String.format("Based on the current balance (%f) and the new balance (%f) the expected mutation should be %f, but the mutations provided summed up to %f.",this.balance.balance, balance, mutationNorm, mutationsSum);
			throw new IllegalArgumentException(msg);
		}
		this.balance.update(balance);
		this.mutations.add(mutations);
	
	}	
}