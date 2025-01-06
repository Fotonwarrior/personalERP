package Bomhofsoft.Personal_ERP.model.general;

import java.time.LocalDateTime;

public class UserAccount {
	String Name;
	LocalDateTime creationDate;	
	
	public UserAccount(String name) {
		super();
		Name = name;
		this.creationDate = LocalDateTime.now();
	}

}
