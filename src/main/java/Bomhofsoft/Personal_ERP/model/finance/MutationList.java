package Bomhofsoft.Personal_ERP.model.finance;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MutationList {
	public ArrayList<Mutation> mutations;
	public BankAccount bankAcount;
	
	
	public void setBankaccount(BankAccount bankaccount) {
		bankAcount = bankaccount;
	}

	public MutationList(){
		this.mutations = new ArrayList<>();
	}
	
	public MutationList(Mutation mutation){
		this();
		this.mutations.add(mutation);
	}
	
	public MutationList(ArrayList<Mutation> mutations){
		this();
		this.mutations = mutations;
	}
	
	public void add(Mutation mutation) {
		mutation.setList(this);
		this.mutations.add(mutation);
	}
	
	public void add(MutationList mutationList) {
		mutationList.setList(this);
		this.mutations.addAll(mutationList.mutations);
	}	
	public void add(double amount, LocalDateTime dateTime, String category) {
		
		Mutation newMutation =new Mutation(amount, dateTime, category);
		newMutation.setList(this);
		this.mutations.add(newMutation);
	}	
	
	public void setList(MutationList mutationList) {
		for (Mutation mutation : this.mutations) {
			mutation.setList(mutationList);
		}
	}
	
	public void remove(Mutation mutation) {
		while (this.mutations.contains(mutation)){ 
			this.mutations.remove(mutation); 
			}
	}
	
	public void remove(ArrayList<Mutation> mutations) {
		for (Mutation mutation : mutations){ 
			this.remove(mutation); 
			}
	}
	
	public MutationList select(String category) {
		ArrayList<Mutation> output = new ArrayList<Mutation>();
		for (Mutation mutation : this.mutations) {
			if (mutation.category == category) { 
				output.add(mutation);
			}
		}
		return new MutationList(output);	
	}
	
	
	public MutationList select(ArrayList<String> category) {
		ArrayList<Mutation> output = new ArrayList<Mutation>();
		for (Mutation mutation : this.mutations) {
			if (category.contains(mutation.category)) { 
				output.add(mutation);
			}
		}
		return new MutationList(output);		
	
	}
	
	public MutationList select() {
		return this;
	}
	
	public double sum() {
		double output = 0.0d;
		for (Mutation mutation : mutations) {
			output += mutation.amount;
		}
		return output;
	}
	
	public double avg() {
		double output = 0.0d;
		for (Mutation mutation : mutations) {
			output += mutation.amount;
		}
		return output/mutations.size();
	}
	
	public Mutation max() {
		Mutation output = null;
		double currentN = 0.0d;
		for (Mutation mutation : mutations) {
			if (mutation.amount > currentN) {
			currentN = mutation.amount;
			output = mutation;
			}
		}
		return output;
	}

	public Mutation min() {
		Mutation output = null;
		double currentN = 0.0d;
		for (Mutation mutation : mutations) {
			if (mutation.amount < currentN) {
			currentN = mutation.amount;
			output = mutation;
			}
		}
		return output;
	}

}
