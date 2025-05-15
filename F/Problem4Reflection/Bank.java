package Problem4Reflection;


/**
 * Write a description of class Bank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bank {

	public static void main(String[] args) {
		Account savings = new Account();
		System.out.println("balance = $" + savings.dispatch("deposit", 100.0));
		System.out.println("balance = $" + savings.dispatch("withdraw", 80.50));
	}
	/*
	Prints:
	  balance = $100.0
      balance = $19.5
    */

}
