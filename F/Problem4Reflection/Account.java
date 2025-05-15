package Problem4Reflection;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Account extends Dispatcher {
	Double balance = 0.0;
	public Double deposit(Double amt) {
		balance += amt;
		return balance;
	}
	public Double withdraw(Double amt) {
		balance -= amt;
		return balance;
	}
}

//.getClass().getMethod(methodName);