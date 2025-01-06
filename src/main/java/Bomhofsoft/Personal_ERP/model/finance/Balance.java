package Bomhofsoft.Personal_ERP.model.finance;
import java.time.LocalDateTime;

public class Balance {
	public double balance;
	public LocalDateTime dateTime;
	
public Balance(double balance) {
	this.balance = balance;
	this.dateTime = LocalDateTime.now();
	}
public Balance() {
	this.balance = 0.0d;
	this.dateTime = LocalDateTime.now();
	}
public void update(double balance) {
	this.balance = balance;
	this.dateTime = LocalDateTime.now();
}

}


