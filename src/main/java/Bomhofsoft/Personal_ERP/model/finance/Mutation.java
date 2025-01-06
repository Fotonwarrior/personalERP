package Bomhofsoft.Personal_ERP.model.finance;

import java.time.LocalDateTime;

public class Mutation {
	private static int i = 1;
	public int internalId;
	public double amount;
	public LocalDateTime dateTime;
	public String category;
	public MutationList list;

	public Mutation(double amount,  String category) {
	this.internalId = i;
	i++;
	this.amount = amount;
	this.dateTime = LocalDateTime.now();
	this.category = category;
	}	
	
	public Mutation(double amount, LocalDateTime dateTime, String category) {
	this.amount = amount;
	this.dateTime = dateTime;
	this.category = category;
	}


	public void setList(MutationList list) {
		this.list = list;
	}
}
