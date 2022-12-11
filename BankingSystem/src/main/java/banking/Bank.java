package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private static Long accountNumber = 1l;

	public Bank() {
		// complete the function
		accounts= new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Account ac = new CommercialAccount(company,accountNumber, pin,startingDeposit) ;
		accounts.put(accountNumber, ac);
		accountNumber++;
		return ac.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Account ac = new ConsumerAccount(person,accountNumber, pin,startingDeposit) ;
		accounts.put(accountNumber, ac);
		accountNumber++;
		return ac.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		if(getAccount(accountNumber)!=null) {
			if(getAccount(accountNumber).validatePin(pin))
				return true;
			return false;
		}
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		Account accountdetails = accounts.get(accountNumber);
		accountdetails.creditAccount(amount);
		accounts.put(accountNumber, accountdetails);
		
	}

	public boolean debit(Long accountNumber, double amount) {
	if(accounts.get(accountNumber)!=null)
	{
		Account accountdetails = accounts.get(accountNumber);
		double bal = accountdetails.getBalance()-amount;
		if(bal >=0) {
			accountdetails.debitAccount(amount);
			accounts.put(accountNumber, accountdetails);
			return true;
		}
		return false;
	}
		
		return false;
	}
}
